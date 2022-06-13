package com.pranavaeet.NexusApp.common;

public class CountryList {
	private String id;
	private String countryName;

	public CountryList() {

	}

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
		return "CountryList [id=" + id + ", countryName=" + countryName + "]";
	}

}