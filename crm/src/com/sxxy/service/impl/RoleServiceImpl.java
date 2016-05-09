package com.sxxy.service.impl;

import java.util.List;

import com.sxxy.dao.RoleDAO;
import com.sxxy.dao.impl.RoleDAOImpl;
import com.sxxy.po.RoleInfo;
import com.sxxy.service.RoleService;

public class RoleServiceImpl implements RoleService {

	private RoleDAO dao=new RoleDAOImpl();
	public boolean add(RoleInfo roleInfo) {
		return dao.add(roleInfo);
		
	}

	public boolean delete(int roleId) {
		return dao.delete(roleId);
	}

	public List<RoleInfo> getList(String roleName) {

		return dao.getList(roleName);
	}

	public RoleInfo getRole(int roleId) {
		
		try {
			if(roleId>0){
				
				System.out.println("执行ID查询操作");
				return dao.getRole(roleId);
				
			}
			else{
				System.out.println("没有执行ID查询");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean update(RoleInfo roleInfo) {
		try {
			if(roleInfo!=null){
				if(roleInfo.getRoleId()!=0){
					//查询数据库中的内容
					RoleInfo role = dao.getRole(roleInfo.getRoleId());
					role.setRoleName(roleInfo.getRoleName());
					role.setRolePower(roleInfo.getRolePower());
					System.out.println("执行修改操作");
					return dao.update(role);
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
