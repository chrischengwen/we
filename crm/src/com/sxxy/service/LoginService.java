package com.sxxy.service;

import java.util.List;

import com.sxxy.po.UserInfo;

public interface LoginService {
	
	/**
	 * 查询员工信息
	 * @param userInfo
	 * @return
	 */
	public List<UserInfo> query(UserInfo userInfo);
	
	
	/**
	 * 查询员工所有信息
	 * @param userInfo
	 * @return
	 */
	public  UserInfo   getAllList(String userNum);
}
