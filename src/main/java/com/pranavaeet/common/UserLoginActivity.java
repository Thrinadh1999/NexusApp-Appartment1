package com.pranavaeet.common;

public class UserLoginActivity {

	private String id;
	private String username;
	private String loginTime;
	private String ipAddress;
	private String location;
	private String browser;
	
	public UserLoginActivity() {}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getBrowser() {
		return browser;
	}

	public void setBrowser(String browser) {
		this.browser = browser;
	}

	@Override
	public String toString() {
		return "UserLoginActivity [id=" + id + ", username=" + username + ", loginTime=" + loginTime + ", ipAddress="
				+ ipAddress + ", location=" + location + ", browser=" + browser + "]";
	}
	
}
