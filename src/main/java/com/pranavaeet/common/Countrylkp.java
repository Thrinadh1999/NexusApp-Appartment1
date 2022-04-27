package com.pranavaeet.common;

public class Countrylkp {
	
	private String id;
	private String countryName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCountryName() {
		return countryName;
	}

	public void setCountryName(String countryName) {
		this.countryName = countryName;
	}
	
	@Override
	public String toString() {
		return  "Countrylkp[id=" + id + ", countryName=" + countryName + "]";
	}
}
