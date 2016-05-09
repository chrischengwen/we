package com.sxxy.service;

import java.util.List;

import com.sxxy.po.EmailInfo;

public interface EmailService {
	/**
	 * 添加邮件
	 * @param email
	 * @return
	 */
	public boolean add(EmailInfo email);
	/**
	 * 查询邮件
	 * @param email
	 * @return
	 */
	public EmailInfo getEmail(int emailId);
	/**
	 * 删除邮件
	 * @param email
	 * @return
	 */
	public boolean delete(int emailId);
	/**
	 * 查询已发送邮件信息
	 * @param EmailTheme
	 * @return
	 */
	public List<EmailInfo> getAllEmail(String emailIput,String queryType);
	
	/**
	 * 查询未发送邮件信息
	 * @param EmailTheme
	 * @return
	 */
	public List<EmailInfo> getNoSendAllEmail(String emailIput,String queryType);
	
	/**
	 * 更改邮件
	 * @param emaileId
	 * @return
	 */
	public boolean upadate(EmailInfo eamInfo);
	

}
