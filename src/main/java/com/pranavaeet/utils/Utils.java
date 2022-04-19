package com.pranavaeet.utils;

import java.security.SecureRandom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Utils {

	final static Logger logger = LogManager.getLogger(Utils.class);
	
	public static String generateRandomNumber(int length) {
		String CHAR_LIST = "1234567890";
		StringBuffer randStr = new StringBuffer(length);
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < length; i++)
			randStr.append(CHAR_LIST.charAt(secureRandom.nextInt(CHAR_LIST.length())));
		return randStr.toString();
	}

	public static String generateRandomString(int length) {
		String CHAR_LIST = "1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer randStr = new StringBuffer(length);
		SecureRandom secureRandom = new SecureRandom();
		for (int i = 0; i < length; i++)
			randStr.append(CHAR_LIST.charAt(secureRandom.nextInt(CHAR_LIST.length())));
		return randStr.toString();
	}
}
