package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.RoleDAO;
import com.sxxy.po.RoleInfo;
import com.sxxy.util.DBCon;

/**
 * 权限信息的实现类
 * @author 蒋元征
 *
 */
public class RoleDAOImpl implements RoleDAO	{

	/**
	 * 添加权限信息
	 */
	public boolean add(RoleInfo deInfo) {
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into user_role (role_name,role_power,is_used)"
					+ "  values(?,?,1)";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, deInfo.getRoleName());
			pre.setString(2, deInfo.getRolePower());

			// 执行sql
			int i = pre.executeUpdate();
			if (i > 0) {
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return false;
	}

	/**
	 * 删除权限信息
	 */
	public boolean delete(int roleId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update user_role set is_used=0 where role_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, roleId);
			
			int i = pre.executeUpdate();
			if(i>0){
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return false;
	}

	/**
	 * 根据权限编号获取权限信息
	 */
	public RoleInfo getRole(int roleId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		try {
			String sql = "select * from user_role where role_id=? and is_used=1";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, roleId);
			// 执行sql
			res = pre.executeQuery();
			
			
			if (res.next()) {
				RoleInfo de = new RoleInfo();
				de.setRoleName(res.getString("role_name"));
				de.setRoleId(res.getInt("role_id"));
				de.setRolePower(res.getString("role_power"));
				return de;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	/**
	 * 查询所有权限信息
	 */
	public List<RoleInfo> getList(String roleName) {
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select * from user_role where is_used=1  ";
			if (roleName != null && !"".equals(roleName.trim())) {
				sql += " and  role_name  like '%" + roleName + "%'";
			}
			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			// 创建集合
			List<RoleInfo> list = new ArrayList<RoleInfo>();

			while (res.next()) {
				RoleInfo role = new RoleInfo();
				role.setRoleId(res.getInt("role_id"));
				role.setRoleName(res.getString("role_name"));
				role.setRolePower(res.getString("role_power"));
				role.setIsUsed(res.getInt("is_used"));

				list.add(role);
			}
			return list;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	/**
	 * 修改权限信息
	 */
	public boolean update(RoleInfo roleInfo) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update user_role  set role_name=?,role_power=? where role_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			
			pre.setString(1, roleInfo.getRoleName());
			pre.setString(2, roleInfo.getRolePower());
			pre.setInt(3, roleInfo.getRoleId());			
			int i = pre.executeUpdate();
			if(i>0){
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return false;
	}

}
