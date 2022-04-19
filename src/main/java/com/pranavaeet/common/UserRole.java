package com.pranavaeet.common;

public class UserRole {

	private String roleName;
	private String userRole;
	private String createdBy;
	private String createdTime;
	
	public UserRole() {
		
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getUserRole() {
		return userRole;
	}

	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(String createdTime) {
		this.createdTime = createdTime;
	}

	@Override
	public String toString() {
		return "UserRole [roleName=" + roleName + ", userRole=" + userRole + ", createdBy=" + createdBy
				+ ", createdTime=" + createdTime + "]";
	}
	
}
