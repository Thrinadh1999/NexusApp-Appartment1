package com.pranavaeet.NexusApp.common;

public class NexusAppVisitors {
	private String id;
	private String typeOfVisitor;
	private String appartmentName;
	private String blockName;
	private String name;
	private String mobile;
	private String inTime;
	private String inDate;
	private String outTime ;
	private String outDate;
	private String elapsedTime;
	private String expectedTime;
	private String imagePath;
	
	public NexusAppVisitors() {

}

	public String getId() {
		return id;
	}

	public String getTypeOfVisitor() {
		return typeOfVisitor;
	}

	public void setTypeOfVisitor(String typeOfVisitor) {
		this.typeOfVisitor = typeOfVisitor;
	}

	public String getAppartmentName() {
		return appartmentName;
	}

	public void setAppartmentName(String appartmentName) {
		this.appartmentName = appartmentName;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getInTime() {
		return inTime;
	}

	public void setInTime(String inTime) {
		this.inTime = inTime;
	}

	public String getInDate() {
		return inDate;
	}

	public void setInDate(String inDate) {
		this.inDate = inDate;
	}

	public String getOutTime() {
		return outTime;
	}

	public void setOutTime(String outTime) {
		this.outTime = outTime;
	}

	public String getOutDate() {
		return outDate;
	}

	public void setOutDate(String outDate) {
		this.outDate = outDate;
	}

	public String getElapsedTime() {
		return elapsedTime;
	}

	public void setElapsedTime(String elapsedTime) {
		this.elapsedTime = elapsedTime;
	}

	public String getExpectedTime() {
		return expectedTime;
	}

	public void setExpectedTime(String expectedTime) {
		this.expectedTime = expectedTime;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "NexusAppVisitors [id=" + id + ", typeOfVisitor=" + typeOfVisitor + ", appartmentName=" + appartmentName
				+ ", blockName=" + blockName + ", name=" + name + ", mobile=" + mobile + ", inTime=" + inTime
				+ ", inDate=" + inDate + ", outTime=" + outTime + ", outDate=" + outDate + ", elapsedTime="
				+ elapsedTime + ", expectedTime=" + expectedTime + ", imagePath=" + imagePath + "]";
	}

}