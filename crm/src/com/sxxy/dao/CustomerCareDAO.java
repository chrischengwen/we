package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerCareInfo;


public interface CustomerCareDAO {
	
	/**
	 * 根据条件查询关怀信息
	 * @param 
	 * @return
	 */
	public List<CustomerCareInfo> getList(String customerInput ,String queryType);
	
	/**
	 * 根据员工id查询关怀信息
	 * @param customerId
	 * @return
	 */
	public CustomerCareInfo getCare(int careId);
	
	/**
	 * 添加关怀信息
	 * @param 
	 * @return
	 */
	public boolean add(CustomerCareInfo careInfo);

	/**
	 * 假删除关怀信息
	 * @param 
	 * @return
	 */
	public boolean delete(int careId);
	
	/**
	 * 修改关怀信息
	 * @param 
	 * @return 
	 */
	public boolean update(CustomerCareInfo careInfo);

}
