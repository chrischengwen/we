package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.UserInfo;

public interface UserDAO {
	
	/**
	 * 根据条件查询员工信息
	 * @param username
	 * @return
	 */
	public List<UserInfo> getList(String userInput, String queryType);
	
	/**
	 * 根据员工id查询员工信息
	 * @param usId
	 * @return
	 */
	public UserInfo getUser(int usId);
	
	/**
	 * 添加员工信息
	 * @param usInfo
	 * @return
	 */
	public boolean add(UserInfo usInfo);

	/**
	 * 假删除员工信息
	 * @param usInfo
	 * @return
	 */
	public boolean delete(int usId);
	
	/**
	 * 修改员工信息
	 * @param usInfo
	 * @return 
	 */
	public boolean update(UserInfo usInfo);

}
