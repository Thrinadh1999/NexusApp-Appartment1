package com.pranavaeet.email.api;

import java.util.HashMap;
import com.elasticemail.app.API;
import com.elasticemail.app.ApiTypes;
import com.elasticemail.app.ApiTypes.*;
import com.elasticemail.app.FileData;
import com.elasticemail.app.APIResponse.VoidApiResponse;

public class ElasticEmail extends API{

	public ElasticEmail() {
		API.API_KEY = "fa457384-38b1-4e52-83e9-c928fe9a9b86";
		API.API_URI = "https://api.elasticemail.com/v2";
	}

	public void sendSMS(String to, String body) throws Exception {
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("apikey", API_KEY);
		values.put("to", to);
		values.put("body", body);
		uploadValues(API_URI + "/sms/send", values, VoidApiResponse.class);
	}
	
	public ApiTypes.EmailSend send(String subject, String from, String fromName, String sender, String senderName,
			String msgFrom, String msgFromName, String replyTo, String replyToName, StringArray to, StringArray msgTo,
			StringArray msgCC, StringArray msgBcc, StringArray lists, StringArray segments, String mergeSourceFilename,
			String dataSource, String channel, String bodyHtml, String bodyText, String charset, String charsetBodyHtml,
			String charsetBodyText, ApiTypes.EncodingType encodingType, String template,
			Iterable<FileData> attachmentFiles, HashMap<String, String> headers, String postBack,
			HashMap<String, String> merge, String timeOffSetMinutes, String poolName, Boolean isTransactional,
			StringArray attachments, Boolean trackOpens, Boolean trackClicks, String utmSource, String utmMedium,
			String utmCampaign, String utmContent, String bodyAmp, String charsetBodyAmp) throws Exception {
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("apikey", API_KEY);
		values.put("subject", subject);
		values.put("from", from);
		values.put("fromName", fromName);
		values.put("sender", sender);
		values.put("senderName", senderName);
		values.put("msgFrom", msgFrom);
		values.put("msgFromName", msgFromName);
		values.put("replyTo", replyTo);
		values.put("replyToName", replyToName);
		if (to != null)
			values.put("to", joinList(to));
		if (msgTo != null)
			values.put("msgTo", joinList(msgTo));
		if (msgCC != null)
			values.put("msgCC", joinList(msgCC));
		if (msgBcc != null)
			values.put("msgBcc", joinList(msgBcc));
		if (lists != null)
			values.put("lists", joinList(lists));
		if (segments != null)
			values.put("segments", joinList(segments));
		values.put("mergeSourceFilename", mergeSourceFilename);
		values.put("dataSource", dataSource);
		values.put("channel", channel);
		values.put("bodyHtml", bodyHtml);
		values.put("bodyText", bodyText);
		values.put("charset", charset);
		values.put("charsetBodyHtml", charsetBodyHtml);
		values.put("charsetBodyText", charsetBodyText);
		values.put("encodingType", String.valueOf(encodingType));
		values.put("template", template);
		if (headers != null)
			for (String key : headers.keySet())
				values.put("headers_" + key, key + ": " + headers.get(key));
		values.put("postBack", postBack);
		if (merge != null)
			for (String key : merge.keySet())
				values.put("merge_" + key, merge.get(key));
		values.put("timeOffSetMinutes", timeOffSetMinutes);
		values.put("poolName", poolName);
		values.put("isTransactional", String.valueOf(isTransactional));
		if (attachments != null)
			values.put("attachments", joinList(attachments));
		values.put("trackOpens", String.valueOf(trackOpens));
		values.put("trackClicks", String.valueOf(trackClicks));
		values.put("utmSource", utmSource);
		values.put("utmMedium", utmMedium);
		values.put("utmCampaign", utmCampaign);
		values.put("utmContent", utmContent);
		values.put("bodyAmp", bodyAmp);
		values.put("charsetBodyAmp", charsetBodyAmp);
		return httpPostFile(API_URI + "/email/send", attachmentFiles, values, ApiTypes.EmailSend.class);
	}
	
	public ApiTypes.EmailSend sendEmail(Email email) throws Exception {
		StringArray msgTo = getStringArray(email.getTo());
		StringArray msgBcc = getStringArray(email.getBcc());
		StringArray msgCc = getStringArray(email.getCc());
		String fromName = "CMS Notification";
		String fromEmail = "no-reply@cafemanager.in";
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("apikey", API_KEY);
		values.put("subject", email.getSubject());
		values.put("from", fromEmail);
		values.put("fromName", fromName);
		values.put("sender", fromEmail);
		values.put("senderName", fromName);
		values.put("msgFrom", fromEmail);
		values.put("msgFromName", fromName);
		values.put("replyTo", fromEmail);
		values.put("replyToName", fromName);
		if (msgTo != null)
			values.put("msgTo", joinList(msgTo));
		if (msgCc != null)
			values.put("msgCC", joinList(msgCc));
		if (msgBcc != null)
			values.put("msgBcc", joinList(msgBcc));
		values.put("bodyHtml", email.getBody());
		values.put("charset", "utf-8");
		values.put("encodingType", String.valueOf(4));
		values.put("isTransactional", String.valueOf(true));
		values.put("trackOpens", String.valueOf(true));
		values.put("trackClicks", String.valueOf(false));
		return httpPostFile(API_URI + "/email/send", null, values, ApiTypes.EmailSend.class);
	}
	
	public ApiTypes.EmailSend sendEmail(Email email, String fromName, String fromEmail) throws Exception {
		StringArray msgTo = getStringArray(email.getTo());
		StringArray msgBcc = getStringArray(email.getBcc());
		StringArray msgCc = getStringArray(email.getCc());
		HashMap<String, String> values = new HashMap<String, String>();
		values.put("apikey", API_KEY);
		values.put("subject", email.getSubject());
		values.put("from", fromEmail);
		values.put("fromName", fromName);
		values.put("sender", fromEmail);
		values.put("senderName", fromName);
		values.put("msgFrom", fromEmail);
		values.put("msgFromName", fromName);
		values.put("replyTo", fromEmail);
		values.put("replyToName", fromName);
		if (msgTo != null)
			values.put("msgTo", joinList(msgTo));
		if (msgCc != null)
			values.put("msgCC", joinList(msgCc));
		if (msgBcc != null)
			values.put("msgBcc", joinList(msgBcc));
		values.put("bodyHtml", email.getBody());
		values.put("charset", "utf-8");
		values.put("encodingType", String.valueOf(4));
		values.put("isTransactional", String.valueOf(true));
		values.put("trackOpens", String.valueOf(true));
		values.put("trackClicks", String.valueOf(false));
		return httpPostFile(API_URI + "/email/send", null, values, ApiTypes.EmailSend.class);
	}
	
	private StringArray getStringArray(String input) {
		if(input == null)
			return null;
		StringArray array = new StringArray();
		array.add(input);
		return array;
	}
}
