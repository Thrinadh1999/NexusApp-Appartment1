package com.pranavaeet.NexusApp.common;

public class NexusAppFloor {
	private String floorId;
	private String floorNumber;
	private String blockId;

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

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	@Override
	public String toString() {
		return "NexusAppFloor [floorId=" + floorId + ", floorNumber=" + floorNumber + ", blockId=" + blockId + "]";
	}
}