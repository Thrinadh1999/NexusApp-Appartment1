package com.pranavaeet.NexusApp.common;

public class NexusAppUserRole {
	private String id;
	private String role;
	private String dispName;

	public NexusAppUserRole() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDispName() {
		return dispName;
	}

	public void setDispName(String dispName) {
		this.dispName = dispName;
	}

	@Override
	public String toString() {
		return "NexusAppUserRole [id=" + id + ", role=" + role + ", dispName=" + dispName + "]";
	}

}
