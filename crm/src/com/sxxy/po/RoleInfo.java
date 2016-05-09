package com.sxxy.po;

/**
 * 权限是实体类
 * @author 蒋元征
 *
 */
public class RoleInfo {
	
	/**
	 * 权限编号
	 */
	private int roleId;
	
	/**
	 * 权限名称
	 */
	private String roleName;
	
	/**
	 * 权限权利
	 */
	private String rolePower;
	
	/**
	 * 是否有效
	 */
	private int isUsed;

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRolePower() {
		return rolePower;
	}

	public void setRolePower(String rolePower) {
		this.rolePower = rolePower;
	}

	public int getIsUsed() {
		return isUsed;
	}

	public void setIsUsed(int isUsed) {
		this.isUsed = isUsed;
	}
	

}
