package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.CustomerCareDAO;
import com.sxxy.po.CustomerCareInfo;
import com.sxxy.util.DBCon;

public class CustomerCareDAOImpl implements CustomerCareDAO{

	public boolean add(CustomerCareInfo careInfo) {
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
  //  asafalfafk
		try {
			String sql = "insert into customer_care (care_theme,customer_id,care_time,care_nexttime,care_people,care_way,care_remark,is_used)"
					+ "  values(?,?,?,?,?,?,?,1)";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, careInfo.getCareTheme());
			pre.setInt(2, careInfo.getCustomerId());
			pre.setString(3, careInfo.getCareTime());
			pre.setString(4, careInfo.getCareNexttime());
			pre.setString(5, careInfo.getCarePeople());
			pre.setString(6, careInfo.getCareWay());
			pre.setString(7, careInfo.getCareRemark());
			
			

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

	public boolean delete(int careId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update customer_care set is_used=0 where care_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, careId);
		
			
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

	public CustomerCareInfo getCare(int careId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		try {
			String sql = "select a.*,b.customer_name from customer_care a,customer_info b where a.customer_id=b.customer_id and care_id=? and a.is_used=1";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, careId);
			// 执行sql
			res = pre.executeQuery();
			
			
			if (res.next()) {
				CustomerCareInfo care = new CustomerCareInfo();
				care.setCareId(res.getInt("care_id"));
				care.setCareTheme(res.getString("care_theme"));
				care.setCarePeople(res.getString("care_people"));
				care.setCareTime(res.getString("care_time"));
				care.setCareNexttime(res.getString("care_nexttime"));
				care.setCustomerId(res.getInt("customer_id"));
				care.setCustomerName(res.getString("customer_name"));
				care.setCareWay(res.getString("care_way"));
				care.setCareRemark(res.getString("care_remark"));
					return care;
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

	public List<CustomerCareInfo> getList(String customerInput ,String queryType) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select a.*,b.customer_name from customer_care a,customer_info b where  a.customer_id = b.customer_id  and  a.is_used=1  ";
			if (customerInput != null && !"".equals(customerInput.trim())  && "1".equals(queryType)) {
				sql+="  and  b.customer_name  like '%"+customerInput+"%'";
			}else if (customerInput != null && !"".equals(customerInput.trim())&& "2".equals(queryType)) {
				sql+="  and  a.care_theme  like '%"+customerInput+"%'";
			}else if (customerInput != null && !"".equals(customerInput.trim())&& "3".equals(queryType)) {
				sql+="  and  a.care_way  like '%"+customerInput+"%'";
			}
			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			// 创建集合
			List<CustomerCareInfo> list = new ArrayList<CustomerCareInfo>();

			while (res.next()) {
				CustomerCareInfo care = new CustomerCareInfo();
				care.setCareId(res.getInt("care_id"));
				care.setCareTheme(res.getString("care_theme"));
				care.setCarePeople(res.getString("care_people"));
				care.setCareTime(res.getString("care_time"));
				care.setCareNexttime(res.getString("care_nexttime"));
				care.setCustomerId(res.getInt("customer_id"));
				care.setCustomerName(res.getString("customer_name"));
				care.setCareWay(res.getString("care_way"));
				care.setCareRemark(res.getString("care_remark"));
				list.add(care);
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

	public boolean update(CustomerCareInfo careInfo) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update customer_care  set care_theme=?,care_way=?,customer_id=?,care_time=?,care_nexttime=?,care_remark=?, care_people=? where care_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setString(1, careInfo.getCareTheme());
			pre.setString(2, careInfo.getCareWay());
			pre.setInt(3, careInfo.getCustomerId());
			pre.setString(4, careInfo.getCareTime());
			pre.setString(5, careInfo.getCareNexttime());
			pre.setString(6, careInfo.getCareRemark());
			pre.setString(7, careInfo.getCarePeople());
			pre.setInt(8, careInfo.getCareId());
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
