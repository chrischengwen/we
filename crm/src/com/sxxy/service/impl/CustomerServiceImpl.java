package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.CustomerDAO;
import com.sxxy.dao.impl.CustomerDAOImpl;
import com.sxxy.po.CustomerInfo;
import com.sxxy.service.CustomerService;

public class CustomerServiceImpl  implements CustomerService{

	CustomerDAO dao=new CustomerDAOImpl();
	public boolean add(CustomerInfo customerInfo) {
		// TODO Auto-generated method stub
		return dao.add(customerInfo);
	}

	public boolean delete(int customerId) {
		// TODO Auto-generated method stub
		return dao.delete(customerId);
	}

	public List<CustomerInfo> query(String customerInput  , String queryType ,int  userId ) {
		// TODO Auto-generated method stub
		return dao.query(customerInput,queryType ,userId);
	}

	public boolean update(CustomerInfo customerInfo) {
		try {
			if(customerInfo!=null){
				if(customerInfo.getCustomerId()!=0){
					//查询数据库中的内容
					CustomerInfo customer = dao.getAllList(customerInfo.getCustomerId());
					
				
					customer.setCustomerSex(customerInfo.getCustomerSex());
					customer.setCustomerMobile(customerInfo.getCustomerMobile());
					customer.setCustomerQq(customerInfo.getCustomerQq());
					customer.setCustomerAddress(customerInfo.getCustomerAddress());
					customer.setCustomerEmail(customerInfo.getCustomerEmail());
					customer.setCustomerRemark(customerInfo.getCustomerRemark());
					customer.setCustomerJob(customerInfo.getCustomerJob());
					customer.setCustomerBlog(customerInfo.getCustomerBlog());
					customer.setCustomerTel(customerInfo.getCustomerTel());
					customer.setCustomerMsn(customerInfo.getCustomerMsn());
					customer.setCustomerChangeTime(customerInfo.getCustomerChangeTime());
					customer.setCustomerChangeMan(customerInfo.getCustomerChangeMan());
					customer.setCustomerCompany(customerInfo.getCustomerCompany());
					customer.setSourceId(customerInfo.getSourceId());
					customer.setConditionId(customerInfo.getConditionId());
					customer.setTypeId(customerInfo.getTypeId());
					customer.setUserId(customerInfo.getUserId());

					System.out.println("执行修改操作");
					return dao.update(customer);
				}
				
			}else{
				System.out.println("没有执行修改");
			}
	
		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		}
		return false;
	}

	public CustomerInfo getAllList(int customerId) {
		// TODO Auto-generated method stub
		return dao.getAllList(customerId);
	}

	public List<CustomerInfo> getNoAdmeasure() {
		// TODO Auto-generated method stub
		return dao.getNoAdmeasure();
	}

	public CustomerInfo getAdmeasure(int customerId) {
		// TODO Auto-generated method stub
		return dao.getAdmeasure(customerId);
	}

	public boolean admeasure(CustomerInfo customerInfo) {
		try {
			if(customerInfo!=null){
				if(customerInfo.getCustomerId()!=0){
					//查询数据库中的内容
					CustomerInfo customer = dao.getAdmeasure(customerInfo.getCustomerId());
					
					customer.setUserId(customerInfo.getUserId());
				

					System.out.println("执行修改操作");
					return dao.update(customer);
				}
				
			}else{
				System.out.println("没有执行修改");
			}
	
		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		}
		return false;
	}

}
