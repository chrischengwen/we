package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.CustomerInfo;
/**
 * 客户信息的实体类
 * @author SHAOLIN
 *
 */
public interface CustomerDAO {

	/**
	 * 查询客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public List<CustomerInfo> query(String customerInput  , String queryType  ,  int  userId );
	
	/**
	 * 查询未分配客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public  List<CustomerInfo>   getNoAdmeasure( );
	
	/**
	 * 根据ID查询客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public  CustomerInfo  getAllList(int customerId );
	
	
	/**
	 * 根据ID查询未分配客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public  CustomerInfo  getAdmeasure(int customerId );
	
	/**
	 * 添加客户信息
	 * @param customerInfo
	 * @return
	 */
	public boolean add(CustomerInfo customerInfo);
	
	/**
	 * 删除客户信息
	 * @param customerId
	 * @return
	 */
	public	boolean delete(int customerId);
	
	/**
	 * 修改客户信息
	 * @param customerInfo
	 * @return
	 */
	public	boolean update(CustomerInfo customerInfo);
	

}
