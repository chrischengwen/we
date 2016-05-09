package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.CustomerSourceDAO;
import com.sxxy.dao.impl.CustomerSourceDAOImpl;
import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.service.CustomerSourceService;

public class CustomerSourceServiceImpl  implements CustomerSourceService{

	CustomerSourceDAO dao =new CustomerSourceDAOImpl();
	public boolean add(CustomerSourceInfo sourceInfo) {
		// TODO Auto-generated method stub
		return dao.add(sourceInfo);
	}

	public boolean delete(int sourceId) {
		// TODO Auto-generated method stub
		return dao.delete(sourceId);
	}

	public List<CustomerSourceInfo> query(String sourceName) {
		// TODO Auto-generated method stub
		return dao.query(sourceName);
	}

	public boolean update(CustomerSourceInfo sourceInfo) {
		// TODO Auto-generated method stub
		return dao.update(sourceInfo);
	}

}
