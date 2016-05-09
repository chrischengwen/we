package com.sxxy.service;

import java.util.List;

import com.sxxy.po.DepartmentInfo;

public interface DepartmentService {
	/**
	 * 根据条件查询部门信息
	 * @param deName
	 * @return
	 */
	public List<DepartmentInfo> getList(String deName);
	
	/**
	 * 添加部门信息
	 * @param deInfo
	 * @return
	 */
	public boolean add(DepartmentInfo deInfo);
	
	/**
	 * 删除部门信息
	 * @param deId
	 * @return
	 */
	public boolean delete(int deId);
	
	/**
	 * 更改部门信息
	 * @param deInfo
	 * @return
	 */
	public boolean update(DepartmentInfo deInfo);
	
	/**
	 * 根据部门id查询
	 * @param deId
	 * @return
	 */
	public DepartmentInfo getDepartment(int deId);


}
