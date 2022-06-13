package com.pranavaeet.NexusApp.common;

public class NexusAppAppartment {
	private String appartmentId;
	private String appartmentName;
	private String appartmentOwner;
	private String appartmenStatus;
	private String description;
	private String blockId;
	private String floorId;
	private String paymentId;
	private String balance;

	public NexusAppAppartment() {

	}

	public String getAppartmentId() {
		return appartmentId;
	}

	public void setAppartmentId(String appartmentId) {
		this.appartmentId = appartmentId;
	}

	public String getAppartmentName() {
		return appartmentName;
	}

	public void setAppartmentName(String appartmentName) {
		this.appartmentName = appartmentName;
	}

	public String getAppartmentOwner() {
		return appartmentOwner;
	}

	public void setAppartmentOwner(String appartmentOwner) {
		this.appartmentOwner = appartmentOwner;
	}

	public String getAppartmenStatus() {
		return appartmenStatus;
	}

	public void setAppartmenStatus(String appartmenStatus) {
		this.appartmenStatus = appartmenStatus;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "NexusAppAppartment [appartmentId=" + appartmentId + ", appartmentName=" + appartmentName
				+ ", appartmentOwner=" + appartmentOwner + ", appartmenStatus=" + appartmenStatus + ", description="
				+ description + ", blockId=" + blockId + ", floorId=" + floorId + ", paymentId=" + paymentId
				+ ", balance=" + balance + "]";
	}

}
