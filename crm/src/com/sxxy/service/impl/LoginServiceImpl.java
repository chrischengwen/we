package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.LoginDAO;
import com.sxxy.dao.impl.LoginDAOImpl;
import com.sxxy.po.UserInfo;
import com.sxxy.service.LoginService;

public class LoginServiceImpl implements LoginService {

	/**
	 * 用户接口实现类
	 */
	LoginDAO dao=new LoginDAOImpl();
	
	/**
	 * 获取用户账号密码
	 */
	public List<UserInfo> query(UserInfo userInfo) {
		
		return dao.query(userInfo);
		
	}

	public UserInfo  getAllList(String userNum) {
		
		// 以用户的帐号查找员工的信息
		
		return dao.getAllList(userNum);
	}

}
