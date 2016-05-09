package com.sxxy.dao.impl;

import java.util.List;

import com.sxxy.dao.HouseTypeDao;
import com.sxxy.po.HouseTypeInfo;
import com.sxxy.service.HouseTypeService;

public class HouseTypeServiceImpl  implements HouseTypeService{

	HouseTypeDao dao =new HouseTypeDaoImpl();
	public boolean add(HouseTypeInfo houseTypeInfo) {
		// TODO Auto-generated method stub
		return dao.add(houseTypeInfo);
	}

	public boolean delete(int houseId) {
		// TODO Auto-generated method stub
		return dao .delete(houseId);
	}

	public List<HouseTypeInfo> query(String houseTypeName) {
		// TODO Auto-generated method stub
		return dao .query(houseTypeName);
	}

	public boolean update(HouseTypeInfo houseTypeInfo) {
		// TODO Auto-generated method stub
		return dao.update(houseTypeInfo);
	}

}
