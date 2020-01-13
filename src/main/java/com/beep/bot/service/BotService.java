package com.beep.bot.service;

import com.beep.bot.dto.NewsDTO;
import com.beep.bot.dto.WeatherDTO;

public interface BotService {

	WeatherDTO getWeatherInfo(Double latitude, Double longitude);
	NewsDTO getNewsInfo(String countryCode);
}
