package com.pranavaeet.NexusApp.common;

public class NexusAppBlocks {
	private String blockId;
	private String blockName;
	private String ventureId;
	private String no_of_floors;
	private String no_of_appartments;

	public NexusAppBlocks() {

	}

	public String getBlockId() {
		return blockId;
	}

	public void setBlockId(String blockId) {
		this.blockId = blockId;
	}

	public String getBlockName() {
		return blockName;
	}

	public void setBlockName(String blockName) {
		this.blockName = blockName;
	}

	public String getVentureId() {
		return ventureId;
	}

	public void setVentureId(String ventureId) {
		this.ventureId = ventureId;
	}
	

	public String getNo_of_floors() {
		return no_of_floors;
	}

	public void setNo_of_floors(String no_of_floors) {
		this.no_of_floors = no_of_floors;
	}
	

	public String getNo_of_appartments() {
		return no_of_appartments;
	}

	public void setNo_of_appartments(String no_of_appartments) {
		this.no_of_appartments = no_of_appartments;
	}

	@Override
	public String toString() {
		return "NexusAppBlocks [blockId=" + blockId + ", blockName=" + blockName + ", ventureId=" + ventureId
				+ ", no_of_floors=" + no_of_floors + ", no_of_appartments=" + no_of_appartments + "]";
	}
}