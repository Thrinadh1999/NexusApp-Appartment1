package com.pranavaeet.NexusApp.common;

public class NexusAppBlocks {
	private String blockId;
	private String blockName;
	private String ventureId;
	private String no_of_floors;

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

	@Override
	public String toString() {
		return "NexusAppBlocks [blockId=" + blockId + ", blockName=" + blockName + ", ventureId=" + ventureId
				+ ", no_of_floors=" + no_of_floors + "]";
	}

	

}
