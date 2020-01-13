/**
 * 
 */
package com.beep.bot.mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.beep.bot.dto.CountryDTO;
import com.beep.bot.model.Country;
import com.beep.bot.vo.CountryVO;

/**
 * @author cis
 *
 */
@Component
public class CountryMapper extends AbstractMapper<CountryDTO, CountryVO, Country> {

	public CountryDTO mapVOtoDTO(CountryVO vo) {
		CountryDTO dto = new CountryDTO();
		super.mapVOtoDTO(vo, dto);
		return dto;
	}

	public CountryDTO mapEntitytoDTO(Country entity) {
		CountryDTO dto = new CountryDTO();
		super.mapEntitytoDTO(entity, dto);
		return dto;
	}

	public Country mapDTOtoEntity(CountryDTO dto) {
		Country entity = new Country();
		super.mapDTOtoEntity(dto, entity);
		return entity;
	}

	public List<Country> mapDTOstoEntitys(List<CountryDTO> dtos) {
		List<Country> entitys = new ArrayList<Country>();
		if (dtos != null && !dtos.isEmpty())
			entitys.addAll(dtos.stream().map(dto -> mapDTOtoEntity(dto)).collect(Collectors.toList()));
		return entitys;
	}

	public List<CountryDTO> mapEntitystoDTOs(List<Country> entites) {
		List<CountryDTO> dtos = new ArrayList<CountryDTO>();
		if (entites != null && !entites.isEmpty())
			dtos.addAll(entites.stream().map(entity -> mapEntitytoDTO(entity)).collect(Collectors.toList()));
		return dtos;
	}
}
