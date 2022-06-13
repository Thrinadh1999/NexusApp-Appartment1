package com.pranavaeet.NexusApp.common;

public class NexusAppBlocks {
	private String blockId;
	private String blockName;
	private String ventureId;

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

	@Override
	public String toString() {
		return "NexusAppBlocks [blockId=" + blockId + ", blockName=" + blockName + ", ventureId=" + ventureId + "]";
	}

}
