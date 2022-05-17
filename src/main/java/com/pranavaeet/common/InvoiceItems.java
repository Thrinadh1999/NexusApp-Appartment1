package com.pranavaeet.common;

public class InvoiceItems {
	private String id;
	private String invoiceID;
	private String itemName;
	private String itemPrice;
	private String description;
	private String quantity;
	private String amount;

public InvoiceItems(){
	
}

public String getId() {
	return id;
}

public void setId(String id) {
	this.id = id;
}

public String getInvoiceID() {
	return invoiceID;
}

public void setInvoiceID(String invoiceID) {
	this.invoiceID = invoiceID;
}

public String getItemName() {
	return itemName;
}

public void setItemName(String itemName) {
	this.itemName = itemName;
}

public String getItemPrice() {
	return itemPrice;
}

public void setItemPrice(String itemPrice) {
	this.itemPrice = itemPrice;
}

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public String getQuantity() {
	return quantity;
}

public void setQuantity(String quantity) {
	this.quantity = quantity;
}

public String getAmount() {
	return amount;
}

public void setAmount(String amount) {
	this.amount = amount;
}

@Override
public String toString() {
	return "InvoiceItems [id=" + id + ", invoiceID=" + invoiceID + ", itemName=" + itemName + ", itemPrice=" + itemPrice
			+ ", description=" + description + ", quantity=" + quantity + ", amount=" + amount + "]";
}

}