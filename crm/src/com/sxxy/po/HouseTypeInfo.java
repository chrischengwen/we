package com.sxxy.po;
/**
 * 房屋类型的实体类
 * @author SHAOLIN
 *
 */
public class HouseTypeInfo {

	/**
	 * 房屋类型编号
	 */
	private int houseTypeId;

	/**
	 * 房屋类型名称
	 */
	private String houseTypeName;

	/**
	 * 房屋类型是否有效
	 */
	private String houseTypeIsUsed;



	public int getHouseTypeId() {
		return houseTypeId;
	}

	public void setHouseTypeId(int houseTypeId) {
		this.houseTypeId = houseTypeId;
	}

	public String getHouseTypeName() {
		return houseTypeName;
	}

	public void setHouseTypeName(String houseTypeName) {
		this.houseTypeName = houseTypeName;
	}

	public String getHouseTypeIsUsed() {
		return houseTypeIsUsed;
	}

	public void setHouseTypeIsUsed(String houseTypeIsUsed) {
		this.houseTypeIsUsed = houseTypeIsUsed;
	}
}
