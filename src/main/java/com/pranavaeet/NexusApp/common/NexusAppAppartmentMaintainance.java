package com.pranavaeet.NexusApp.common;

public class NexusAppAppartmentMaintainance {
	private String id;
	private String status;
	private String description;
	private String appartmentId;

	public NexusAppAppartmentMaintainance() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAppartmentId() {
		return appartmentId;
	}

	public void setAppartmentId(String appartmentId) {
		this.appartmentId = appartmentId;
	}

	@Override
	public String toString() {
		return "NexusAppAppartmentMaintainance [id=" + id + ", status=" + status + ", description=" + description
				+ ", appartmentId=" + appartmentId + "]";
	}
}