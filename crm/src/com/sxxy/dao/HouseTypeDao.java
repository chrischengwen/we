package com.sxxy.dao;

import java.util.List;

import com.sxxy.po.HouseTypeInfo;
/**
 * 房屋类型的实体类
 * @author SHAOLIN
 *
 */
public interface HouseTypeDao {

	/**
	 * 查询房屋类型的信息
	 * @param sourceName
	 * @return 房屋类型的信息
	 */
	public List<HouseTypeInfo> query(String houseTypeName);
	
	/**
	 * 添加房屋类型的信息
	 * @param sourceInfo
	 * @return
	 */
	public boolean add(HouseTypeInfo houseTypeInfo);
	
	/**
	 * 删除房屋类型信息
	 * @param conditionId
	 * @return
	 */
	public	boolean delete(int houseId);
	
	/**
	 * 修改房屋类型信息
	 * @param conditionId
	 * @return
	 */
	public	boolean update(HouseTypeInfo houseTypeInfo);
}
