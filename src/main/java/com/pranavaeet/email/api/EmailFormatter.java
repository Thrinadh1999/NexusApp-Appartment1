package com.pranavaeet.email.api;

public class EmailFormatter {

	public EmailFormatter(){
		
	}
	
	public static String startHtml() {
		String text = "<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">" + 
				"<html xmlns=\"http://www.w3.org/1999/xhtml\">";
		text += "<head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\"/>"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"/><title>Pranava Email</title></head><body style=\"margin: 0; padding: 0;\">";
		return text;
	}
	
	public static String endHtml() {
		String text = "</body></html>";		
		return text;
	}
	
	public static String htmlStartingTextForUser(String name){
		String text = "<table cellpadding=\"0\" cellspacing=\"0\" width=\"80%\" style=\"margin-left:10%\">"
			+ "<tr><td><p style=\"text-align: center;background: #000;\"><img src=\"http://pranavaeet.com/img/logo.png\" alt=\"Pranava EET\"/></p><br/>"
			+ "<p> Dear " + name + ",</p></td></tr>";
		return text;
	}
	
	public static String footerTextUser(){
		String text="<tr><td><p style='font-size:12px;'>"
			+ "<b>Disclaimer: </b>This email was sent to you because you have expressed interest in one of our products or services. "
			+ "If you believe that you received this message in error, please send an email to: <a href=\"mailto:complaints@pranavalabs.com\"><b>complaints@pranavalabs.com</b></a></p>";
		
		return text+disclaimerText();
	}
	
	private static String disclaimerText(){
		String text = "<p><b>This email does not accept any responses.</b></p>"
				+ "<p style='font-size:9px;'>"
				+ "<b>CONFIDENTIALITY NOTICE: </b>The contents of this email message and any attachments are intended solely for "
				+ "the addressee(s) and may contain confidential and/or privileged information and may be legally protected from "
				+ "disclosure. If you are not the intended recipient of this message or their agent, or if this message has been "
				+ "addressed to you in error, please immediately alert the sender by reply email and then delete this message and "
				+ "any attachments. If you are not the intended recipient, you are hereby notified that any use, dissemination, "
				+ "copying, or storage of this message or its attachments is strictly prohibited.</p></td></tr>";
		return text;
	}
}
