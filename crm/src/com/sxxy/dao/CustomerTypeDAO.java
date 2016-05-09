package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerTypeInfo;

/**
 * 客户类型的接口
 * @author 刘少林
 *
 */
public interface CustomerTypeDAO {

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
