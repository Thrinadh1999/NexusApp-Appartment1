package com.pranavaeet.NexusApp.common;

public class StateList {

	private String id;
	private String stateName;
	private String countryId;
	

	public StateList() {

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
		return "StateList [id=" + id + ", stateName=" + stateName + ", countryId=" + countryId + "]";
	}
	
}
