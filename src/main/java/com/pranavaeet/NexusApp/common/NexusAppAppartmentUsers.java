package com.pranavaeet.NexusApp.common;

public class NexusAppAppartmentUsers {
	private String id;
	private String userId;
	private String status;

	public NexusAppAppartmentUsers() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "NexusAppAppartmentUsers [id=" + id + ", userId=" + userId + ", status=" + status + "]";
	}
}