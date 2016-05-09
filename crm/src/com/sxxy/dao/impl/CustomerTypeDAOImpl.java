package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.CustomerTypeDAO;
import com.sxxy.po.CustomerTypeInfo;
import com.sxxy.util.DBCon;

public class CustomerTypeDAOImpl  implements CustomerTypeDAO{

	public boolean add(CustomerTypeInfo typeInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_type (type_name)  values(?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, typeInfo.getCustomerTypeName());

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
				e.printStackTrace();
			}

		}
		return false;
	}

	public boolean delete(int typeId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update customer_type set  is_used = '0' where type_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, typeId);

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

	public List<CustomerTypeInfo> query(String typeName) {
		// 查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {

			String sql = "select *  from customer_type  where is_used=1  ";
			
			if (typeName != null && !"".equals(typeName.trim())) {
				sql += " and  type_name  like ? ";
			}	
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				if (typeName != null && !"".equals(typeName.trim())) {
					pre.setString(1, "%" + typeName + "%");
				}
				
			res = pre.executeQuery();

			List<CustomerTypeInfo> list = new ArrayList<CustomerTypeInfo>();
			while (res.next()) {

				CustomerTypeInfo typeInfo = new CustomerTypeInfo();

				typeInfo.setCustomerTypeId(res.getInt("type_id"));
				typeInfo.setCustomerTypeName(res.getString("type_name"));
				typeInfo.setCustomerTypeIsUsed(res.getString("is_used"));
			
				list.add(typeInfo);
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

	public boolean update(CustomerTypeInfo typeInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update customer_type set  type_name=?  where type_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setString(1, typeInfo.getCustomerTypeName());
			pre.setInt(2, typeInfo.getCustomerTypeId());

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
				e.printStackTrace();
			}
		}
		return false;
	}

}
