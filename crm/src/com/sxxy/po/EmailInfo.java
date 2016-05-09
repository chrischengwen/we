package com.sxxy.po;

/**
 * 邮件管理的实体类
 * 
 * @author 朱淼玲
 * 
 */
public class EmailInfo {

	/**
	 * 邮件编号
	 */
	private int emailId;

	/**
	 * 收件人编号
	 */
	private int customerId;

	/**
	 * 收件人
	 */
	private String addressee;

	/**
	 * 发件人编号
	 */
	private int userId;

	/**
	 * 发件人
	 */
	private String addresser;

	/**
	 * 邮件内容
	 */
	private String emailContent;

	/**
	 * 发送时间
	 */
	private String emailTime;

	/**
	 * 发送状态
	 */
	private int emailState;

	/**
	 * 邮件主题
	 */
	private String emailTheme;

	/**
	 * 是否有效
	 */
	private String isUsed;

	public int getEmailId() {
		return emailId;
	}

	public void setEmailId(int emailId) {
		this.emailId = emailId;
	}

	public String getAddressee() {
		return addressee;
	}

	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}

	public String getAddresser() {
		return addresser;
	}

	public void setAddresser(String addresser) {
		this.addresser = addresser;
	}

	public String getEmailContent() {
		return emailContent;
	}

	public void setEmailContent(String emailContent) {
		this.emailContent = emailContent;
	}

	public String getEmailTime() {
		return emailTime;
	}

	public void setEmailTime(String emailTime) {
		this.emailTime = emailTime;
	}

	public int getEmailState() {
		return emailState;
	}

	public void setEmailState(int emailState) {
		this.emailState = emailState;
	}

	public String getEmailTheme() {
		return emailTheme;
	}

	public void setEmailTheme(String emailTheme) {
		this.emailTheme = emailTheme;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}



}
