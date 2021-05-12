package com.te.accademy.webapi.model;

public class Country {
	private String code;
	private String country;
	private String continent;

	public Country(String code, String country, String continent) {
		this.code = code;
		this.country = country;
		this.continent = continent;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

}
