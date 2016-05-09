package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.HouseDAO;
import com.sxxy.dao.impl.HouseDAOImpl;
import com.sxxy.po.HouseInfo;
import com.sxxy.service.HouseService;

public class HouseServiceImpl implements HouseService{

	HouseDAO dao =new HouseDAOImpl();
	public boolean add(HouseInfo house) {
		// TODO Auto-generated method stub
		return dao.add(house);
	}

	public boolean delete(int houseId) {
		// TODO Auto-generated method stub
		return dao.delete(houseId);
	}

	public List<HouseInfo> getAllHouse(String houseInput, String queryType  ,int  userId) {
		// TODO Auto-generated method stub
		return dao.getAllHouse(houseInput, queryType ,userId);
	}

	public HouseInfo getHouse(int houseId) {
		// TODO Auto-generated method stub
		return dao.getHouse(houseId);
	}

	public boolean update(HouseInfo house) {
		try {
			if(house!=null){
				if(house.getHouseId()!=0){
					//查询数据库中的内容
					HouseInfo houseInfo = dao.getHouse(house.getHouseId());
					houseInfo.setHouseAddress(house.getHouseAddress());
					houseInfo.setHouseAmbient(house.getHouseAmbient());
					houseInfo.setHousePrice(house.getHousePrice());
					houseInfo.setTypeId(house.getTypeId());
					houseInfo.setUserId(house.getUserId());
					System.out.println("执行修改操作");
					return dao.update(houseInfo);
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
