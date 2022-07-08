package com.pranavaeet.NexusApp.common;

public class NexusAppLogin {
	private String loginId;
	private String userName;
	private String loginPassword;
	private String mobileNumber;
	private String loginStatus;

	public NexusAppLogin() {

	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getLoginStatus() {
		return loginStatus;
	}

	public void setLoginStatus(String loginStatus) {
		this.loginStatus = loginStatus;
	}

	@Override
	public String toString() {
		return "NexusAppLogin [loginId=" + loginId + ", userName=" + userName + ", loginPassword=" + loginPassword
				+ ", mobileNumber=" + mobileNumber + ", loginStatus=" + loginStatus + "]";
	}

}
