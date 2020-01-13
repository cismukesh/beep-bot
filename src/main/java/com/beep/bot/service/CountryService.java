package com.beep.bot.service;

import java.util.List;

import com.beep.bot.dto.CountryDTO;

public interface CountryService {

	/**
	 * 
	 * @return
	 */
	List<CountryDTO> getCountries();
}
