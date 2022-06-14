package com.pranavaeet.NexusApp.common;

public class OtpNexusApp {
	private String  id;
	private String  number;
	private String  otp;
	public OtpNexusApp() {
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getOtp() {
		return otp;
	}
	public void setOtp(String otp) {
		this.otp = otp;
	}
	@Override
	public String toString() {
		return "OtpNexusApp [id=" + id + ", number=" + number + ", otp=" + otp + "]";
	}
	

}
