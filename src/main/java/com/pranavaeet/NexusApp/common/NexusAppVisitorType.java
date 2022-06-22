package com.pranavaeet.NexusApp.common;

public class NexusAppVisitorType {
	private String id;
	private String visitorType;
	private String description;
	
	public NexusAppVisitorType() {

}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVisitorType() {
		return visitorType;
	}

	public void setVisitorType(String visitorType) {
		this.visitorType = visitorType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NexusAppVisitorType [id=" + id + ", visitorType=" + visitorType + ", description=" + description + "]";
	}
	
}	
