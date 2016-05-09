package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.UserInfo;

public interface LoginDAO {
	
	/**
	 * 查询员工信息
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> query(UserInfo userInfo);
	
	/**
	 * 查询当前用户所有信息
	 * @param userInfo
	 * @return
	 */
	public UserInfo getAllList(String userNum);
	
	
}
