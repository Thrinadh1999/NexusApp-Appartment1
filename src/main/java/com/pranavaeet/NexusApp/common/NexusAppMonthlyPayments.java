package com.pranavaeet.NexusApp.common;

public class NexusAppMonthlyPayments {
	private String paymentId;
	private String paymentDue;
	private String status;
	private String description;

	public NexusAppMonthlyPayments() {

	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getPaymentDue() {
		return paymentDue;
	}

	public void setPaymentDue(String paymentDue) {
		this.paymentDue = paymentDue;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "NexusAppMonthlyPayments [paymentId=" + paymentId + ", paymentDue=" + paymentDue + ", status=" + status
				+ ", description=" + description + "]";
	}

}
