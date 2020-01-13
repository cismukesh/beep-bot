/**
 * 
 */
package com.beep.bot.dto;

/**
 * @author cis
 *
 */
public class CurrentlyTemparatureDTO {

	private String temperature;

	/**
	 * @return the temperature
	 */
	public String getTemperature() {
		return temperature;
	}

	/**
	 * @param temperature
	 *            the temperature to set
	 */
	public void setTemperature(String temperature) {
		this.temperature = temperature;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CurrentlyTemparatureDTO [temperature=");
		builder.append(temperature);
		builder.append("]");
		return builder.toString();
	}

}
