package com.pranavaeet.common;

import java.util.List;

public class Invoices {
	private String invoiceId;
	private String invoiceNo;
	private String client;
	private String clientAdress;
	private String toName;
	private String issueDate;
	private String invoiceBy ;
	private String createdTime;
	private String gst;
	private String amountInvo;
	private List<InvoiceItems> itemList;
	 

public Invoices(){
	
}

public String getInvoiceId() {
	return invoiceId;
}

public void setInvoiceId(String invoiceId) {
	this.invoiceId = invoiceId;
}

public String getInvoiceNo() {
	return invoiceNo;
}

public void setInvoiceNo(String invoiceNo) {
	this.invoiceNo = invoiceNo;
}

public String getClient() {
	return client;
}

public void setClient(String client) {
	this.client = client;
}

public String getClientAdress() {
	return clientAdress;
}

public void setClientAdress(String clientAdress) {
	this.clientAdress = clientAdress;
}

public String getToName() {
	return toName;
}

public void setToName(String toName) {
	this.toName = toName;
}

public String getIssueDate() {
	return issueDate;
}

public void setIssueDate(String issueDate) {
	this.issueDate = issueDate;
}

public String getInvoiceBy() {
	return invoiceBy;
}

public void setInvoiceBy(String invoiceBy) {
	this.invoiceBy = invoiceBy;
}

public String getCreatedTime() {
	return createdTime;
}

public void setCreatedTime(String createdTime) {
	this.createdTime = createdTime;
}

public String getGst() {
	return gst;
}

public void setGst(String gst) {
	this.gst = gst;
}

public String getAmountInvo() {
	return amountInvo;
}

public void setAmountInvo(String amountInvo) {
	this.amountInvo = amountInvo;
}

public List<InvoiceItems> getItemList() {
	return itemList;
}

public void setItemList(List<InvoiceItems> itemList) {
	this.itemList = itemList;
}

@Override
public String toString() {
	return "Invoices [invoiceId=" + invoiceId + ", invoiceNo=" + invoiceNo + ", client=" + client + ", clientAdress="
			+ clientAdress + ", toName=" + toName + ", issueDate=" + issueDate + ", invoiceBy=" + invoiceBy
			+ ", createdTime=" + createdTime + ", gst=" + gst + ", amountInvo=" + amountInvo + ", itemList=" + itemList + "]";
}



}
