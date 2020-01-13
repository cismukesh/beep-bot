package com.beep.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.beep.bot.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {

}
