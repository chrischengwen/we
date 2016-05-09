package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.CustomerConditionDAO;
import com.sxxy.dao.impl.CustomerConditionDAOImpl;
import com.sxxy.po.CustomerConditionInfo;
import com.sxxy.service.CustomerConditionService;

public class CustomerConditionServiceImpl implements CustomerConditionService {

	CustomerConditionDAO dao =new CustomerConditionDAOImpl();
	public boolean add(CustomerConditionInfo customerConditionInfo) {
		// TODO Auto-generated method stub
		return dao.add(customerConditionInfo);
	}

	public boolean delete(int conditionId) {
		// TODO Auto-generated method stub
		return dao.delete(conditionId);
	}

	public List<CustomerConditionInfo> query(	String conditionName) {
		// TODO Auto-generated method stub
		return dao.query(conditionName);
	}

	public boolean update(CustomerConditionInfo conditionInfo) {
		// TODO Auto-generated method stub
		return dao.update(conditionInfo);
	}

}
