package com.pranavaeet.common;

public class Password {

	private String username;
	private String password;
	private String confirmPassword;
	
	public Password() {
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "Password [username=" + username + ", password=" + password + ", confirmPassword=" + confirmPassword
				+ "]";
	}
	
	
}
