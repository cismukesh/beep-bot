package com.beep.bot.dto;

import java.io.Serializable;

import com.beep.bot.dto.CurrentlyTemparatureDTO;

public class WeatherDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3285897376917050255L;

	private CurrentlyTemparatureDTO currently;

	/**
	 * @return the currently
	 */
	public CurrentlyTemparatureDTO getCurrently() {
		return currently;
	}

	/**
	 * @param currently
	 *            the currently to set
	 */
	public void setCurrently(CurrentlyTemparatureDTO currently) {
		this.currently = currently;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("WeatherDTO [currently=");
		builder.append(currently);
		builder.append("]");
		return builder.toString();
	}

}
