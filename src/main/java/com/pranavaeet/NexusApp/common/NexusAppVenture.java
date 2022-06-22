package com.pranavaeet.NexusApp.common;

public class NexusAppVenture {
	private String ventureId;
	private String ventureName;
	private String ventureAddress;
	private String description;
	private String no_of_blocks;

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

	public String getNo_of_blocks() {
		return no_of_blocks;
	}

	public void setNo_of_blocks(String no_of_blocks) {
		this.no_of_blocks = no_of_blocks;
	}

	@Override
	public String toString() {
		return "NexusAppVenture [ventureId=" + ventureId + ", ventureName=" + ventureName + ", ventureAddress="
				+ ventureAddress + ", description=" + description + ", no_of_blocks=" + no_of_blocks + "]";
	}

	
}
