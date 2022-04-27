package com.pranavaeet.common;

public class Statelkp {

	private String id;
	private String stateName;
	private String countryId;

	public Statelkp() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStateName() {
		return stateName;
	}

	public void setStateName(String stateName) {
		this.stateName = stateName;
	}

	public String getCountryId() {
		return countryId;
	}

	public void setCountryId(String countryId) {
		this.countryId = countryId;
	}

	@Override
	public String toString() {
		return "Statelkp[id=" + id + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}

}
