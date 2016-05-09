package com.sxxy.po;

/**
 * 联系人的实体类
 * 
 * @author 刘欢
 * 
 */

public class LinkManInfo {

	
	/**
	 * 联系人编号
	 */
	private int LinkmanId;

	/**
	 * 客户编号
	 */

	private int CoustomerId;
	
	/**
	 * 客户名称
	 */
	private String CoustomerName;
	
	/**
	 * 联系人姓名
	 */
	private String LinkmanName;

	/**
	 * 联系人性别
	 */
	private String LinkmanSex;

	/**
	 * 联系人年龄
	 */
	private int LinkmanAge;

	/**
	 * 联系人职业
	 */
	private String LinkmanJob;

	/**
	 * 联系人手机号码
	 */
	private String LinkmanMobile;

	/**
	 * 联系人与客户关系
	 */
	private String LinkmanRelation;

	/**
	 * 是否有效
	 */
	private String IsUsed;

	public int getLinkmanId() {
		return LinkmanId;
	}

	public void setLinkmanId(int linkmanId) {
		LinkmanId = linkmanId;
	}

	public String getLinkmanName() {
		return LinkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		LinkmanName = linkmanName;
	}

	public String getLinkmanSex() {
		return LinkmanSex;
	}

	public void setLinkmanSex(String linkmanSex) {
		LinkmanSex = linkmanSex;
	}

	public int getLinkmanAge() {
		return LinkmanAge;
	}

	public void setLinkmanAge(int linkmanAge) {
		LinkmanAge = linkmanAge;
	}

	public String getLinkmanJob() {
		return LinkmanJob;
	}

	public void setLinkmanJob(String linkmanJob) {
		LinkmanJob = linkmanJob;
	}

	public String getLinkmanMobile() {
		return LinkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		LinkmanMobile = linkmanMobile;
	}

	public String getLinkmanRelation() {
		return LinkmanRelation;
	}

	public void setLinkmanRelation(String linkmanRelation) {
		LinkmanRelation = linkmanRelation;
	}

	public String getIsUsed() {
		return IsUsed;
	}

	public void setIsUsed(String isUsed) {
		IsUsed = isUsed;
	}

	public int getCoustomerId() {
		return CoustomerId;
	}

	public void setCoustomerId(int coustomerId) {
		CoustomerId = coustomerId;
	}


	public String getCoustomerName() {
		return CoustomerName;
	}

	public void setCoustomerName(String coustomerName) {
		CoustomerName = coustomerName;
	}

	

}
