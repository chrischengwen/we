package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.CustomerCareDAO;
import com.sxxy.dao.impl.CustomerCareDAOImpl;
import com.sxxy.po.CustomerCareInfo;
import com.sxxy.service.CustomerCareService;

public class CustomerCareServiceImpl implements CustomerCareService {

	CustomerCareDAO daoCareDAO = new CustomerCareDAOImpl();
	public boolean add(CustomerCareInfo careInfo) {
		return daoCareDAO.add(careInfo);
	}

	public boolean delete(int careId) {
		return daoCareDAO.delete(careId);
	
	}

	public CustomerCareInfo getCare(int careId) {
		try {
			if(careId>0){
				
				System.out.println("执行ID查询操作");
				return daoCareDAO.getCare(careId);
				
			}
			else{
				System.out.println("没有执行ID查询");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<CustomerCareInfo> getList(String customerInput ,String queryType  ) {
		return daoCareDAO.getList(customerInput,queryType);
	}

	public boolean update(CustomerCareInfo careInfo) {
		try {
			if(careInfo!=null){
				if(careInfo.getCareId()!=0){
					//查询数据库中的内容
					CustomerCareInfo care = daoCareDAO.getCare(careInfo.getCareId());
					
					care.setCareTheme(careInfo.getCareTheme());
					care.setCarePeople(careInfo.getCarePeople());
					care.setCareRemark(careInfo.getCareRemark());
					//care.setCareTime(careInfo.getCareTime());
					care.setCareNexttime(careInfo.getCareNexttime());
					care.setCareWay(careInfo.getCareWay());
					care.setCustomerId(careInfo.getCustomerId());
					
					System.out.println("执行修改操作");
					return daoCareDAO.update(care);
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
