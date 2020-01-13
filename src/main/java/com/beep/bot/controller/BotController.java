package com.beep.bot.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.beep.bot.dto.CountryDTO;
import com.beep.bot.dto.NewsDTO;
import com.beep.bot.dto.ResponseDTO;
import com.beep.bot.dto.WeatherDTO;
import com.beep.bot.enums.StatusEnum;
import com.beep.bot.exceptions.BadRequestException;
import com.beep.bot.service.BotService;
import com.beep.bot.service.CountryService;
import com.beep.bot.vo.UserInfoVO;

/**
 * @author cis
 *
 */
@Controller
public class BotController {

	@Autowired
	private BotService botService;

	@Autowired
	CountryService countryService;

	/**
	 * get getWeatherInfo using latitude and longitude
	 * 
	 * @param latitude
	 * @param longitude
	 * @return ResponseDTO<?>
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/getweatherinfo")
	public ResponseDTO<?> getWeatherInfo(@RequestParam(name = "latitude") Double latitude,
			@RequestParam(name = "longitude") Double longitude) throws BadRequestException {
		if (null == latitude || latitude == 0 || null == longitude || longitude == 0) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}
		WeatherDTO weatherInfo = botService.getWeatherInfo(latitude, longitude);
		return new ResponseDTO<WeatherDTO>(StatusEnum.SUCCESS.getStatusCode(), StatusEnum.SUCCESS.getStatusMessage(),
				weatherInfo);

	}

	/**
	 * getWeatherInfo using country code
	 * 
	 * @param countryCode
	 * @return ModelAndView
	 * @throws BadRequestException
	 */
	@GetMapping(path = "/get-news-based-on-country")
	public ModelAndView getNewsInfo(@RequestParam(name = "countrycode") String countryCode, HttpSession httpSession)
			throws BadRequestException {
		if (!StringUtils.hasText(countryCode)) {
			throw new BadRequestException(StatusEnum.BAD_REQUEST.getStatusCode(),
					StatusEnum.BAD_REQUEST.getStatusMessage());
		}
		ModelAndView mv = new ModelAndView();
		mv.addObject("status", "true");
		NewsDTO newsDTO = botService.getNewsInfo(countryCode);
		List<CountryDTO> countryDTOs = countryService.getCountries();
		if (newsDTO.getArticles() == null || newsDTO.getArticles().isEmpty()) {
			UserInfoVO userInfo = (UserInfoVO) httpSession.getAttribute("userInfo");
			mv.addObject("status", "false");
			mv.addObject("message", "Currently news for this country is not supported");
			mv.addObject("user", userInfo);
			mv.addObject("country", countryDTOs);
			mv.setViewName("userservice");
			return mv;
		}
		mv.setViewName("news");
		mv.addObject("newsobj", newsDTO);
		return mv;
	}

	/**
	 * show User information based on name and location
	 * 
	 * @param userInfo
	 * @return ModelAndView
	 * @throws BadRequestException
	 */
	@PostMapping(path = "/show-user-info")
	public ModelAndView showUserInfo(@ModelAttribute UserInfoVO userInfo, HttpSession httpSession)
			throws BadRequestException {
		ModelAndView mv = new ModelAndView();
		mv.addObject("status", "true");
		httpSession.setAttribute("userInfo", userInfo);
		WeatherDTO weatherInfo = botService.getWeatherInfo(userInfo.getLatitude(), userInfo.getLongitude());
		userInfo.setWeather(Double.parseDouble(weatherInfo.getCurrently().getTemperature()));
		// fetch list of countries
		List<CountryDTO> countryDTOs = countryService.getCountries();
		if (countryDTOs == null || countryDTOs.isEmpty()) {
			mv.addObject("status", "false");
			mv.addObject("message", "Country List not found");
			mv.setViewName("location");
			return mv;
		}
		mv.setViewName("userservice");
		mv.addObject("user", userInfo);
		mv.addObject("country", countryDTOs);
		return mv;
	}

}
