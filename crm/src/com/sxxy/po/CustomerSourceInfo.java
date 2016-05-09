package com.sxxy.po;

public class CustomerSourceInfo {

	/**
	 * 客户来源编号
	 */
	private int sourceId;

	/**
	 * 客户来源名称
	 */
	private String sourceName;

	/**
	 * 客户来源是否有效
	 */
	private String sourceIsUsed;



	public int getSourceId() {
		return sourceId;
	}

	public void setSourceId(int sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceIsUsed() {
		return sourceIsUsed;
	}

	public void setSourceIsUsed(String sourceIsUsed) {
		this.sourceIsUsed = sourceIsUsed;
	}

}
