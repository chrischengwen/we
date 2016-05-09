package com.sxxy.service;

import java.util.List;

import com.sxxy.po.CustomerInfo;

public interface ReportFormsService {

	
	/**
	 * 统计客户状态
	 * @return
	 */
	public 	List<CustomerInfo>  countCondition ();
    
	/**
	 * 统计客户来源
	 * @return
	 */
	public 	List<CustomerInfo>  countSource();
		    
	/**
	 * 统计客户类型
	 * @return
	 */
	public 	List<CustomerInfo>  countType ();
			    
	/**
	 * 统计客户分配状态
	 * @return
	 */
	public 	List<CustomerInfo>  count ();
	
	/**
	 * 类型查询
	 * @return
	 */
	public 	List<CustomerInfo>  queryType (  int  typeId );
	
	/**
	 * 状态查询
	 * @return
	 */
	public 	List<CustomerInfo>  queryCondition ( int conditionId );
	
	/**
	 * 来源查询
	 * @return
	 */
	public 	List<CustomerInfo>  querySource (  int  sourceId);
}
