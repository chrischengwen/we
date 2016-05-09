package com.sxxy.service;

import java.util.List;

import com.sxxy.po.CustomerTypeInfo;

public interface CustomerTypeService {

	/**
	 * 查询客户类型的信息
	 * @param customerConditionInfo
	 * @return 客户类型的信息
	 */
	public List<CustomerTypeInfo> query(String typeName);
	
	/**
	 * 添加客户类型的信息
	 * @param customerConditionInfo
	 * @return
	 */
	public boolean add(CustomerTypeInfo typeInfo);
	
	/**
	 * 删除客户类型信息
	 * @param conditionId
	 * @return
	 */
	public	boolean delete(int typeId);
	
	/**
	 * 修改客户类型信息
	 * @param conditionId
	 * @return
	 */
	public	boolean update(CustomerTypeInfo typeInfo);
}
