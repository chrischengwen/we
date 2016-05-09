package com.sxxy.po;

public class NoticeInfo {
	
	/**
	 * 公告人编号
	 */
	private String userName;
	
	/**
	 * 公告人编号
	 */
	private int userId;
	
	/**
	 * 公告编号
	 */
	private int noticeId;

	/**
	 * 公告主题
	 */
	private String noticeItem;

	/**
	 * 公告内容
	 */
	private String noticeContent;
	
	/**
	 * 公告时间
	 */
	private String noticeTime;
	
	/**
	 * 公告截止时间
	 */
	private String noticeEndTime;
	
	/**
	 * 公告是否有效
	 */
	private String noticeIsUsed;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getNoticeId() {
		return noticeId;
	}

	public void setNoticeId(int noticeId) {
		this.noticeId = noticeId;
	}

	public String getNoticeItem() {
		return noticeItem;
	}

	public void setNoticeItem(String noticeItem) {
		this.noticeItem = noticeItem;
	}

	public String getNoticeContent() {
		return noticeContent;
	}

	public void setNoticeContent(String noticeContent) {
		this.noticeContent = noticeContent;
	}

	public String getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(String noticeTime) {
		this.noticeTime = noticeTime;
	}

	public String getNoticeEndTime() {
		return noticeEndTime;
	}

	public void setNoticeEndTime(String noticeEndTime) {
		this.noticeEndTime = noticeEndTime;
	}

	public String getNoticeIsUsed() {
		return noticeIsUsed;
	}

	public void setNoticeIsUsed(String noticeIsUsed) {
		this.noticeIsUsed = noticeIsUsed;
	}

}
