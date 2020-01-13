/**
 * 
 */
package com.beep.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.beep.bot.dto.NewsDTO;
import com.beep.bot.dto.WeatherDTO;
import com.beep.bot.service.BotService;

/**
 * @author cis
 *
 */
@Service
public class BotServiceImpl implements BotService {

	@Value("${weather.url}")
	private String weatherUrl;
	@Value("${news.url}")
	private String newsUrl;
	@Value("${google.map.api.key}")
	private String googleMapKey;
	@Value("${news.url.api.key}")
	private String newsUrlApiKey;
	@Value("${weather.url.api.key}")
	private String weatherUrlApiKey;

	@Autowired
	private RestTemplate restTemplate;
	
	/**
	 * getWeatherInfo to get weather details using latitude and longitude
	 * 
	 * @return WeatherDTO
	 */
	@Override
	public WeatherDTO getWeatherInfo(Double latitude, Double longitude) {
		String weather = weatherUrl;
		weather = weather.replace("{latitude}", latitude.toString());
		weather = weather.replace("{longitude}", longitude.toString());
		ResponseEntity<WeatherDTO> responseEntity = restTemplate.getForEntity(weather, WeatherDTO.class);
		return responseEntity.getBody();
	}
	
	/**
	 * getNewsInfo to get news Information using country code
	 * 
	 * @return NewsDTO
	 */
	@Override
	public NewsDTO getNewsInfo(String countryCode) {
		String newsUrlWithCode;
		newsUrlWithCode = newsUrl.replace("{countryCode}", countryCode);
		ResponseEntity<NewsDTO> responseEntity = restTemplate.getForEntity(newsUrlWithCode, NewsDTO.class);
		return responseEntity.getBody();
	}

}
