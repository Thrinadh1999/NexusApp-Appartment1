package com.pranavaeet.email.api;

public class Email {

	private String to;
	private String cc;
	private String bcc;
	private String subject;
	private String body;
	private String fromName;
	private String fromEmail;
	
	public Email() {
		
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getCc() {
		return cc;
	}

	public void setCc(String cc) {
		this.cc = cc;
	}

	public String getBcc() {
		return bcc;
	}

	public void setBcc(String bcc) {
		this.bcc = bcc;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getFromEmail() {
		return fromEmail;
	}

	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}

	@Override
	public String toString() {
		return "Email [to=" + to + ", cc=" + cc + ", bcc=" + bcc + ", subject=" + subject + ", body=" + body
				+ ", fromName=" + fromName + ", fromEmail=" + fromEmail + "]";
	}
	
}
