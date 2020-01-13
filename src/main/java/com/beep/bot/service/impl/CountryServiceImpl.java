package com.beep.bot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.beep.bot.dto.CountryDTO;
import com.beep.bot.mapper.CountryMapper;
import com.beep.bot.repository.CountryRepository;
import com.beep.bot.service.CountryService;

@Service
public class CountryServiceImpl implements CountryService {

	@Autowired
	private CountryRepository countryRepository;

	@Autowired
	private CountryMapper countryMapper;

	/**
	 * This method is used to fetch countries
	 */
	@Override
	public List<CountryDTO> getCountries() {
		return countryMapper.mapEntitystoDTOs(countryRepository.findAll());
	}

}
