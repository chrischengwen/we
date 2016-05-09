package com.sxxy.service;

import java.util.List;

import com.sxxy.po.HouseInfo;

public interface HouseService {

	/**
	 * 增加房屋信息
	 * @param houseId
	 * @return
	 */
	
   public boolean add(HouseInfo house);
   
   /**
	 * 修改房屋信息
	 * @param houseId
	 * @return
	 */
   public boolean update(HouseInfo house);
   
   /**
	 * 删除房屋信息
	 * @param houseId
	 * @return
	 */
   public boolean delete(int houseId);
   
   /**
	 * 根据编号查询房屋信息
	 * @param houseId
	 * @return
	 */
   public HouseInfo getHouse(int houseId);
   
   /**
	 * 查询多个房屋信息
	 * @param houseType
	 * @return
	 */
   public List<HouseInfo> getAllHouse(String houseInput , String queryType  ,   int userId);
	
}
