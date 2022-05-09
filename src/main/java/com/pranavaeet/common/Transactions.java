package com.pranavaeet.common;

public class Transactions {
	private String transactionId;
	private String transactionBy;
	private String transactionDateTime;
	private String transDescription;
	private String transactionCategories;
	private String transactionType;
	private String amount;
public Transactions(){
		
	}
public String getTransactionId() {
	return transactionId;
}
public void setTransactionId(String transactionId) {
	this.transactionId = transactionId;
}
public String getTransactionBy() {
	return transactionBy;
}
public void setTransactionBy(String transactionBy) {
	this.transactionBy = transactionBy;
}
public String getTransactionDateTime() {
	return transactionDateTime;
}
public void setTransactionDateTime(String transactionDateTime) {
	this.transactionDateTime = transactionDateTime;
}
public String getTransDescription() {
	return transDescription;
}
public void setTransDescription(String transDescription) {
	this.transDescription = transDescription;
}
public String getTransactionCategories() {
	return transactionCategories;
}
public void setTransactionCategories(String transactionCategories) {
	this.transactionCategories = transactionCategories;
}
public String getTransactionType() {
	return transactionType;
}
public void setTransactionType(String transactionType) {
	this.transactionType = transactionType;
}
public String getAmount() {
	return amount;
}
public void setAmount(String amount) {
	this.amount = amount;
}
@Override
public String toString() {
	return "Transactions [transactionId=" + transactionId + ", transactionBy=" + transactionBy
			+ ", transactionDateTime=" + transactionDateTime + ", transDescription=" + transDescription
			+ ", transactionCategories=" + transactionCategories + ", transactionType=" + transactionType + ", amount="
			+ amount + "]";
}

}
