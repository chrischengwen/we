package com.sxxy.po;

public class LinkRecordInfo {
	
	/**
	 * 客户姓名
	 */
	private String customerName;
	
	/**
	 * 联系记录编号
	 */
	private int recordId;
	
	/**
	 * 客户编号
	 */
	private int customerId;
	
	/**
	 * 联系时间
	 */
	private String linkTime;

	/**
	 * 是谁联系的
	 */
	private String whoLink;
	
	/**
	 * 联系类型
	 */
	private String linkType;
	
	/**
	 * 联系主题
	 */
	private String linkTheme;
	
	/**
	 * 下次联系时间
	 */
	private String linkNexttime;
	
	/**
	 * 联系备注
	 */
	private String linkRemark;
	
	/**
	 * 是否有效
	 */
	private String isUsed;

	public int getRecordId() {
		return recordId;
	}

	public void setRecordId(int recordId) {
		this.recordId = recordId;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getLinkTime() {
		return linkTime;
	}

	public void setLinkTime(String linkTime) {
		this.linkTime = linkTime;
	}

	public String getWhoLink() {
		return whoLink;
	}

	public void setWhoLink(String whoLink) {
		this.whoLink = whoLink;
	}

	public String getLinkType() {
		return linkType;
	}

	public void setLinkType(String linkType) {
		this.linkType = linkType;
	}

	public String getLinkTheme() {
		return linkTheme;
	}

	public void setLinkTheme(String linkTheme) {
		this.linkTheme = linkTheme;
	}

	

	public String getLinkNexttime() {
		return linkNexttime;
	}

	public void setLinkNexttime(String linkNexttime) {
		this.linkNexttime = linkNexttime;
	}

	public String getLinkRemark() {
		return linkRemark;
	}
	

	public void setLinkRemark(String linkRemark) {
		this.linkRemark = linkRemark;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}
