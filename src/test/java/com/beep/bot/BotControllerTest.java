/**
 * 
 */
package com.beep.bot;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.servlet.ModelAndView;

import com.beep.bot.controller.BotController;
import com.beep.bot.dto.ArticlesDTO;
import com.beep.bot.dto.CountryDTO;
import com.beep.bot.dto.CurrentlyTemparatureDTO;
import com.beep.bot.dto.NewsDTO;
import com.beep.bot.dto.WeatherDTO;
import com.beep.bot.exceptions.BadRequestException;
import com.beep.bot.mapper.CountryMapper;
import com.beep.bot.model.Country;
import com.beep.bot.service.BotService;
import com.beep.bot.service.CountryService;
import com.beep.bot.vo.UserInfoVO;

/**
 * @author cis
 *
 */
@SpringBootTest()
@RunWith(SpringRunner.class)
class BotControllerTest {

	@MockBean
	private BotService botService;
	
	@MockBean
	private CountryService countryService;
	
	@Autowired
	private CountryMapper countryMapper;
	
	@Autowired
	private BotController botController;
	
	@Autowired 
	private HttpSession httpSession;
	
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {

	}
	
	@Test
	void testShowUserInfo() throws Exception {
		UserInfoVO userInfo = new UserInfoVO();
		userInfo.setAddress("Indore");
		userInfo.setName("Demo");
		userInfo.setLatitude(22.754221317920024);
		userInfo.setLongitude(75.86651623648368);
		userInfo.setWeather(22.21);
		
		List<CountryDTO> countries = prepareCountryList();
		
		when(countryService.getCountries()).thenReturn(countries);
		
		when(botService.getWeatherInfo(22.754221317920024, 75.86651623648368)).thenReturn(getWeatherResponse());
		
		ModelAndView mv = botController.showUserInfo(userInfo, httpSession);
		assertEquals("userservice", mv.getViewName());		
        
	}
	
	@Test
	void testGetNewsInfo() throws BadRequestException {
		
		when(botService.getNewsInfo("in")).thenReturn(getNewsDetails());
		ModelAndView mv = botController.getNewsInfo("in",httpSession);
		assertEquals("news", mv.getViewName());
	}
	
	public NewsDTO getNewsDetails() {
		
		NewsDTO newsDto = new NewsDTO();
		List<ArticlesDTO> rArticlesDTOs = new ArrayList<ArticlesDTO>();
		ArticlesDTO articles = new ArticlesDTO();
		rArticlesDTOs.add(articles);
		newsDto.setArticles(rArticlesDTOs);
		
    	return newsDto;
}
	
	private WeatherDTO getWeatherResponse() {
		WeatherDTO weatherDTO = new WeatherDTO();
		CurrentlyTemparatureDTO currently = new CurrentlyTemparatureDTO();
		currently.setTemperature("22.21");
		weatherDTO.setCurrently(currently);
		return weatherDTO;
	}
	
	private List<CountryDTO> prepareCountryList() {
		List<Country> countries = new ArrayList<Country>();
		Country country = new Country();
		country.setCode("in");
		country.setCountry("India");
		country.setId(1L);
		countries.add(country);
		return countryMapper.mapEntitystoDTOs(countries);
	}

}
