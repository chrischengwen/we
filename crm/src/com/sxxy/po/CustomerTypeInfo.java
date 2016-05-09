package com.sxxy.po;
/**
 * 客户类型的实体类
 * @author SHAOLIN
 *
 */
public class CustomerTypeInfo {

	/**
	 * 客户类型编号
	 */
	private int customerTypeId;

	/**
	 * 客户类型名称
	 */
	private String customerTypeName;

	/**
	 * 客户类型是否有效
	 */
	private String customerTypeIsUsed;



	public int getCustomerTypeId() {
		return customerTypeId;
	}

	public void setCustomerTypeId(int customerTypeId) {
		this.customerTypeId = customerTypeId;
	}

	public String getCustomerTypeName() {
		return customerTypeName;
	}

	public void setCustomerTypeName(String customerTypeName) {
		this.customerTypeName = customerTypeName;
	}

	public String getCustomerTypeIsUsed() {
		return customerTypeIsUsed;
	}

	public void setCustomerTypeIsUsed(String customerTypeIsUsed) {
		this.customerTypeIsUsed = customerTypeIsUsed;
	}
}
