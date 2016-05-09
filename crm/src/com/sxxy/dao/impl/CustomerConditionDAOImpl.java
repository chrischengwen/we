package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.CustomerConditionDAO;
import com.sxxy.po.CustomerConditionInfo;
import com.sxxy.util.DBCon;

public class CustomerConditionDAOImpl implements CustomerConditionDAO {

	public boolean add(CustomerConditionInfo customerConditionInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_condition (condition_name,condition_explain)  values(?,?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, customerConditionInfo.getConditionName());
			pre.setString(2, customerConditionInfo.getConditionExplain());
		

			// 执行s q l:增加，修改，删除都是用executeUpdate
			int i = pre.executeUpdate();

			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 关闭
				DBCon.closeCon(con);
				DBCon.closePre(pre);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean delete(int conditionId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update customer_condition set  is_used = '0' where condition_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, conditionId);

			// 执行s q l:增加，修改，删除都是用executeUpdate
			int i = pre.executeUpdate();

			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			DBCon.closeCon(con);
			DBCon.closePre(pre);

		}
		return false;
	}

	public List<CustomerConditionInfo> query(String conditionName) {
		// 查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {

			String sql = "select *  from customer_condition  where is_used=1  ";
			
			if (conditionName != null && !"".equals(conditionName.trim())) {
				sql += " and  condition_name  like ? ";
			}	
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				if (conditionName != null && !"".equals(conditionName.trim())) {
					pre.setString(1, "%" + conditionName + "%");
				}
				
			res = pre.executeQuery();

			List<CustomerConditionInfo> list = new ArrayList<CustomerConditionInfo>();
			while (res.next()) {

				CustomerConditionInfo customerCondition = new CustomerConditionInfo();

				customerCondition.setConditionId(res.getInt("condition_id"));
				customerCondition.setConditionName(res.getString("condition_name"));
				customerCondition.setConditionExplain(res.getString("condition_explain"));
				customerCondition.setConditionIsUsed(res.getString("is_used"));
			
				list.add(customerCondition);
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

	public boolean update(CustomerConditionInfo conditionInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update customer_condition set  condition_name=?,condition_explain=?  where condition_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setString(1, conditionInfo.getConditionName());
			pre.setString(2, conditionInfo.getConditionExplain());
			pre.setInt(3, conditionInfo.getConditionId());

			// 执行s q l:增加，修改，删除都是用executeUpdate
			int i = pre.executeUpdate();

			if (i > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

			try {
				// 关闭
				DBCon.closeCon(con);
				DBCon.closePre(pre);

			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}

}
