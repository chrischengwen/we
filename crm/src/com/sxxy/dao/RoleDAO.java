package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.RoleInfo;

public interface RoleDAO {
	
	/**
	 * 根据条件查询权限信息
	 * @param roleName
	 * @return
	 */
	public List<RoleInfo> getList(String roleName);
	
	/**
	 * 添加权限信息
	 * @param deInfo
	 * @return
	 */
	public boolean add(RoleInfo roleInfo);
	
	/**
	 * 删除权限信息
	 * @param deId
	 * @return
	 */
	public boolean delete(int roleId);
	
	/**
	 * 更改权限信息
	 * @param deInfo
	 * @return
	 */
	public boolean update(RoleInfo roleInfo);
	
	/**
	 * 根据权限id查询
	 * @param deId
	 * @return
	 */
	public RoleInfo getRole(int roleId);

}
