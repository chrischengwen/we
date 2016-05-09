package com.sxxy.service;

import java.util.List;

import com.sxxy.po.CustomerInfo;
/**
 * 客户信息的业务逻辑
 * @author SHAOLIN
 *
 */
public interface CustomerService {
	/**
	 * 查询客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public List<CustomerInfo> query(String customerInput  , String queryType , int  userId);
	
	/**
	 * 查询未分配客户信息
	 * @param customerInfo
	 * @return 客户信息
	 */
	public  List<CustomerInfo> getNoAdmeasure( );
	
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
	
	/**
	 * 修改未分配客户信息
	 * @param customerInfo
	 * @return
	 */
	public	boolean admeasure(CustomerInfo customerInfo);
}
