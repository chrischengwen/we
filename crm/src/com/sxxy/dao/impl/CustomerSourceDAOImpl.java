package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.CustomerSourceDAO;
import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.util.DBCon;

public class CustomerSourceDAOImpl  implements CustomerSourceDAO{

	public boolean add(CustomerSourceInfo sourceInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_source (source_name)  values(?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, sourceInfo.getSourceName());

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

	public boolean delete(int sourceId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update customer_source set  is_used = '0' where source_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, sourceId);

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

	public List<CustomerSourceInfo> query(String sourceName) {
		//查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {

			String sql = "select *  from customer_source  where is_used=1  ";
			
			if (sourceName != null && !"".equals(sourceName.trim())) {
				sql += " and  source_name  like ? ";
			}	
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				if (sourceName != null && !"".equals(sourceName.trim())) {
					pre.setString(1, "%" + sourceName + "%");
				}
				
			res = pre.executeQuery();

			List<CustomerSourceInfo> list = new ArrayList<CustomerSourceInfo>();
			while (res.next()) {

				CustomerSourceInfo sourceInfo = new CustomerSourceInfo();

				sourceInfo.setSourceId(res.getInt("source_id"));
				sourceInfo.setSourceName(res.getString("source_name"));
				sourceInfo.setSourceIsUsed(res.getString("is_used"));
			
				list.add(sourceInfo);
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

	public boolean update(CustomerSourceInfo sourceInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update customer_source set  source_name=?  where source_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setString(1, sourceInfo.getSourceName());
			pre.setInt(2, sourceInfo.getSourceId());

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
