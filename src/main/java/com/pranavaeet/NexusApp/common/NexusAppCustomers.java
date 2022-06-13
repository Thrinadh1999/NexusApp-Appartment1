package com.pranavaeet.NexusApp.common;

public class NexusAppCustomers {
	private String customerId;
	private String customerName;
	private String customerMobile;
	private String customerAddress;
	private String customerPincode;
	private String customerRole;
	private String ventureid;
	private String ventureName;

	public NexusAppCustomers() {

	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerMobile() {
		return customerMobile;
	}

	public void setCustomerMobile(String customerMobile) {
		this.customerMobile = customerMobile;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerPincode() {
		return customerPincode;
	}

	public void setCustomerPincode(String customerPincode) {
		this.customerPincode = customerPincode;
	}

	public String getCustomerRole() {
		return customerRole;
	}

	public void setCustomerRole(String customerRole) {
		this.customerRole = customerRole;
	}

	public String getVentureid() {
		return ventureid;
	}

	public void setVentureid(String ventureid) {
		this.ventureid = ventureid;
	}

	public String getVentureName() {
		return ventureName;
	}

	public void setVentureName(String ventureName) {
		this.ventureName = ventureName;
	}

	@Override
	public String toString() {
		return "NexusAppCustomers [customerId=" + customerId + ", customerName=" + customerName + ", customerMobile="
				+ customerMobile + ", customerAddress=" + customerAddress + ", customerPincode=" + customerPincode
				+ ", customerRole=" + customerRole + ", ventureid=" + ventureid + ", ventureName=" + ventureName + "]";
	}
}