package com.beep.bot.vo;

public class CountryVO {

	private Long id;

	private String country;

	private String code;

	private String descriptor;

	private String uncode;

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return the descriptor
	 */
	public String getDescriptor() {
		return descriptor;
	}

	/**
	 * @param descriptor
	 *            the descriptor to set
	 */
	public void setDescriptor(String descriptor) {
		this.descriptor = descriptor;
	}

	/**
	 * @return the uncode
	 */
	public String getUncode() {
		return uncode;
	}

	/**
	 * @param uncode
	 *            the uncode to set
	 */
	public void setUncode(String uncode) {
		this.uncode = uncode;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CountryVO [id=");
		builder.append(id);
		builder.append(", country=");
		builder.append(country);
		builder.append(", code=");
		builder.append(code);
		builder.append(", descriptor=");
		builder.append(descriptor);
		builder.append(", uncode=");
		builder.append(uncode);
		builder.append("]");
		return builder.toString();
	}

}