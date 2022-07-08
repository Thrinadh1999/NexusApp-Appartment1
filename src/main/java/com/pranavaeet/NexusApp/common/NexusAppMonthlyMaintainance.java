package com.pranavaeet.NexusApp.common;

public class NexusAppMonthlyMaintainance {
	private String maintainanceId;
	private String createdBy;
	private String amount;
	private String createdDate;
	private String status;
	private String description;

	public NexusAppMonthlyMaintainance() {

	}

	public String getMaintainanceId() {
		return maintainanceId;
	}

	public void setMaintainanceId(String maintainanceId) {
		this.maintainanceId = maintainanceId;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String amount) {
		this.amount = amount;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
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
		return "NexusAppMonthlyMaintainance [maintainanceId=" + maintainanceId + ", createdBy=" + createdBy
				+ ", amount=" + amount + ", createdDate=" + createdDate + ", status=" + status + ", description="
				+ description + "]";
	}

}
