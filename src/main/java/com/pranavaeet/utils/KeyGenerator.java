package com.pranavaeet.utils;

import java.security.SecureRandom;

public class KeyGenerator {

	private KeyGenerator() {}
	
	public static String generateLicenseKey() {
		String licenseKey = "";
		for(int i=0; i<4; i++) {
			licenseKey += new String(generateRandomString(4));
			if(i<3) licenseKey += "-";
		}
		return licenseKey.toUpperCase();
	}
	
	public static String generatePassword(int length) {
		return new String(generateRandomString(length));
	}
	
	public static String generateJobID() {
		return new String("PR"+generateRandomNumber(6)).toUpperCase();
	}
	
	public static String generateEmployeeID() {
		return new String("SDC"+generateRandomNumber(8)).toUpperCase();
	}
	
	public static String generateEmployeeID(String identifier) {
		return new String(identifier+generateRandomNumber(8)).toUpperCase();
	}
	
	private static String generateRandomString(int length) {
		String CHAR_LIST = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randStr = new StringBuffer(length);
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < length; i++)
			randStr.append(CHAR_LIST.charAt(secureRandom.nextInt(CHAR_LIST.length())));
		return new String(randStr.toString());
	}
	
	private static String generateRandomNumber(int length) {
		String CHAR_LIST = "1234567890";
		StringBuffer randStr = new StringBuffer(length);
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < length; i++)
			randStr.append(CHAR_LIST.charAt(secureRandom.nextInt(CHAR_LIST.length())));
		return new String(randStr.toString());
	}
	
}
