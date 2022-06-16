package com.pranavaeet.NexusApp.common;

public class NexusAppFloor {
	private String floorId;
	private String floorNumber;
	private String blockName;

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

	@Override
	public String toString() {
		return "NexusAppFloor [floorId=" + floorId + ", floorNumber=" + floorNumber + ", blockName=" + blockName + "]";
	}

}