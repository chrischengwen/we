package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerSourceInfo;
/**
 * 客户来源的接口
 * @author SHAOLIN
 *
 */
public interface CustomerSourceDAO {

	/**
	 * 查询客户来源的信息
	 * @param sourceName
	 * @return 客户来源的信息
	 */
	public List<CustomerSourceInfo> query(String sourceName);
	
	/**
	 * 添加客户来源的信息
	 * @param sourceInfo
	 * @return
	 */
	public boolean add(CustomerSourceInfo sourceInfo);
	
	/**
	 * 删除客户来源信息
	 * @param conditionId
	 * @return
	 */
	public	boolean delete(int sourceId);
	
	/**
	 * 修改客户来源信息
	 * @param conditionId
	 * @return
	 */
	public	boolean update(CustomerSourceInfo sourceInfo);
}
