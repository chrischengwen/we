package com.sxxy.po;
/**
 * 房屋信息
 * @author k02
 *
 */

public class HouseInfo {
	
	/**
	 * 房屋编号
	 */
	private int houseId;
	
	/**
	 *户型编号
	 */
	private int typeId;
	
	/**
	 *户型名称
	 */
	private String typeName;
	
	/**
	 *员工编号
	 */
	private int userId;
	
	/**
	 *员工名称
	 */
	private String userName;
	
	/**
	 * 房屋地址
	 */
	private String  houseAddress;
	
	/**
	 * 房屋价格
	 */
	private double housePrice;
	
	/**
	 * 房屋环境
	 */
	private String  houseAmbient;
	
	/**
	 * 是否有效
	 */
	private String isUsed;

	public int getHouseId() {
		return houseId;
	}

	public void setHouseId(int houseId) {
		this.houseId = houseId;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getHouseAddress() {
		return houseAddress;
	}

	public void setHouseAddress(String houseAddress) {
		this.houseAddress = houseAddress;
	}

	public double getHousePrice() {
		return housePrice;
	}

	public void setHousePrice(double housePrice) {
		this.housePrice = housePrice;
	}

	public String getHouseAmbient() {
		return houseAmbient;
	}

	public void setHouseAmbient(String houseAmbient) {
		this.houseAmbient = houseAmbient;
	}

	public String getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(String isUsed) {
		this.isUsed = isUsed;
	}
	

	

}
