package com.pranavaeet.NexusApp.common;

public class NexusAppVenture {
	private String ventureId;
	private String ventureName;
	private String ventureAddress;
	private String description;
	private String customer;
	private String customerId;

	public NexusAppVenture() {

	}

	public String getVentureId() {
		return ventureId;
	}

	public void setVentureId(String ventureId) {
		this.ventureId = ventureId;
	}

	public String getVentureName() {
		return ventureName;
	}

	public void setVentureName(String ventureName) {
		this.ventureName = ventureName;
	}

	public String getVentureAddress() {
		return ventureAddress;
	}

	public void setVentureAddress(String ventureAddress) {
		this.ventureAddress = ventureAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCustomer() {
		return customer;
	}

	public void setCustomer(String customer) {
		this.customer = customer;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "NexusAppVenture [ventureId=" + ventureId + ", ventureName=" + ventureName + ", ventureAddress="
				+ ventureAddress + ", description=" + description + ", customer=" + customer + ", customerId="
				+ customerId + "]";
	}

}
