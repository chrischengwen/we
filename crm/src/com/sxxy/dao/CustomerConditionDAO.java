package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerConditionInfo;

/**
 * 客户状态的接口
 * @author SHAOLIN
 *
 */
public interface CustomerConditionDAO {

	/**
	 * 查询客户状态的信息
	 * @param customerConditionInfo
	 * @return 客户状态的信息
	 */
	public List<CustomerConditionInfo> query(String conditionName);
	
	/**
	 * 添加客户状态的信息
	 * @param customerConditionInfo
	 * @return
	 */
	public boolean add(CustomerConditionInfo customerConditionInfo);
	
	/**
	 * 删除客户状态信息
	 * @param conditionId
	 * @return
	 */
	public	boolean delete(int conditionId);
	
	/**
	 * 修改客户状态信息
	 * @param conditionId
	 * @return
	 */
	public	boolean update(CustomerConditionInfo conditionInfo);
}
