package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.CustomerTypeDAO;
import com.sxxy.dao.impl.CustomerTypeDAOImpl;
import com.sxxy.po.CustomerTypeInfo;
import com.sxxy.service.CustomerTypeService;

public class CustomerTypeServiceImpl  implements CustomerTypeService{

	CustomerTypeDAO  dao = new CustomerTypeDAOImpl();
	public boolean add(CustomerTypeInfo typeInfo) {
		// TODO Auto-generated method stub
		return dao.add(typeInfo);
	}

	public boolean delete(int typeId) {
		// TODO Auto-generated method stub
		return dao.delete(typeId);
	}

	public List<CustomerTypeInfo> query(String typeName) {
		// TODO Auto-generated method stub
		return dao.query(typeName);
	}

	public boolean update(CustomerTypeInfo typeInfo) {
		// TODO Auto-generated method stub
		return dao.update(typeInfo);
	}

}
