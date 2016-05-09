package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.DepartmentDAO;
import com.sxxy.po.DepartmentInfo;
import com.sxxy.util.DBCon;


/**
 * 部门信息的实现类
 * @author 蒋元征
 *
 */

public class DepartmentDAOImpl implements DepartmentDAO{
	
	/**
	 * 添加部门信息
	 */
	public boolean add(DepartmentInfo deInfo) {
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into department_info (department_name,department_desc,is_used)"
					+ "  values(?,?,1)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, deInfo.getDepartmentName());
			pre.setString(2, deInfo.getDepartmentDesc());

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
	 * 删除部门信息
	 */
	public boolean delete(int deId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update department_info set is_used=0 where department_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, deId);
			
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
	 * 根据id查询部门信息
	 */
	public DepartmentInfo getDepartment(int deId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		try {
			String sql = "select * from department_info where department_id=? and is_used=1";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, deId);
			// 执行sql
			res = pre.executeQuery();
			
			
			if (res.next()) {
				DepartmentInfo de = new DepartmentInfo();
				de.setDepartmentName(res.getString("department_name"));
				de.setDepartmentId(res.getInt("department_id"));
				de.setDepartmentDesc(res.getString("department_desc"));
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
	 * 查询所有部门信息
	 */
	public List<DepartmentInfo> getList(String deName) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select * from department_info where is_used=1  ";
			if (deName != null && !"".equals(deName.trim())) {
				sql += " and  department_name  like '%" + deName + "%'";
			}
			//System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			// 创建集合
			List<DepartmentInfo> list = new ArrayList<DepartmentInfo>();

			while (res.next()) {
				DepartmentInfo de = new DepartmentInfo();
				de.setDepartmentId(res.getInt("department_id"));
				de.setDepartmentName(res.getString("department_name"));
				de.setDepartmentDesc(res.getString("department_desc"));
				de.setIsUsed(res.getString("is_used"));

				list.add(de);
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
	 * 更改部门信息
	 */
	public boolean update(DepartmentInfo deInfo) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update department_info  set department_name=?,department_desc=? where department_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			
			pre.setString(1, deInfo.getDepartmentName());
			pre.setString(2, deInfo.getDepartmentDesc());
			pre.setInt(3, deInfo.getDepartmentId());			
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
