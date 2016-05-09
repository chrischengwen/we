package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.ReportFormsDAO;
import com.sxxy.dao.impl.ReportFormsDAOImpl;
import com.sxxy.po.CustomerInfo;
import com.sxxy.service.ReportFormsService;

public class ReportFormsServiceImpl  implements  ReportFormsService {

	ReportFormsDAO dao =new  ReportFormsDAOImpl();
	public List<CustomerInfo> count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	public List<CustomerInfo> countCondition() {
		// TODO Auto-generated method stub
		return dao.countCondition();
	}

	public List<CustomerInfo> countSource() {
		// TODO Auto-generated method stub
		return dao.countSource();
	}

	public List<CustomerInfo> countType() {
		// TODO Auto-generated method stub
		return dao.countType();
	}

	public List<CustomerInfo> queryCondition(int conditionId) {
		// TODO Auto-generated method stub
		return dao.queryCondition(conditionId);
	}

	public List<CustomerInfo> querySource(int sourceId) {
		// TODO Auto-generated method stub
		return dao.querySource(sourceId);
	}

	public List<CustomerInfo> queryType(int  typeId) {
		// TODO Auto-generated method stub
		return dao.queryType(typeId);
	}

}
