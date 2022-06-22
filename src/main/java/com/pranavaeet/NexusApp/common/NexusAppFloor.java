package com.pranavaeet.NexusApp.common;

public class NexusAppFloor {
	private String floorId;
	private String floorNumber;
	private String blockName;
	private String no_of_appartments;

	public NexusAppFloor() {

	}

	public String getFloorId() {
		return floorId;
	}

	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}

	public String getFloorNumber() {
		return floorNumber;
	}

	public void setFloorNumber(String floorNumber) {
		this.floorNumber = floorNumber;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}
	

	public String getNo_of_appartments() {
		return no_of_appartments;
	}

	public void setNo_of_appartments(String no_of_appartments) {
		this.no_of_appartments = no_of_appartments;
	}

	@Override
	public String toString() {
		return "NexusAppFloor [floorId=" + floorId + ", floorNumber=" + floorNumber + ", blockName=" + blockName
				+ ", no_of_appartments=" + no_of_appartments + "]";
	}

	

}