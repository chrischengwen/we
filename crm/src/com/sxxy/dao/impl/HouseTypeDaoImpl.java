package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.HouseTypeDao;
import com.sxxy.po.HouseTypeInfo;
import com.sxxy.util.DBCon;

public class HouseTypeDaoImpl implements HouseTypeDao{

	public boolean add(HouseTypeInfo houseTypeInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into house_type (type_name)  values(?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, houseTypeInfo.getHouseTypeName());

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

	public boolean delete(int houseId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update house_type set  is_used = '0' where type_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, houseId);

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

	public List<HouseTypeInfo> query(String houseTypeName) {
		// 查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {

			String sql = "select *  from house_type  where is_used=1  ";
			
			if (houseTypeName != null && !"".equals(houseTypeName.trim())) {
				sql += " and  type_name  like ? ";
			}	
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				if (houseTypeName != null && !"".equals(houseTypeName.trim())) {
					pre.setString(1, "%" + houseTypeName + "%");
				}
				
			res = pre.executeQuery();

			List<HouseTypeInfo> list = new ArrayList<HouseTypeInfo>();
			while (res.next()) {

				HouseTypeInfo houseTypeInfo = new HouseTypeInfo();

				houseTypeInfo.setHouseTypeId(res.getInt("type_id"));
				houseTypeInfo.setHouseTypeName(res.getString("type_name"));
				houseTypeInfo.setHouseTypeIsUsed(res.getString("is_used"));
			
				list.add(houseTypeInfo);
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

	public boolean update(HouseTypeInfo houseTypeInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update house_type set  type_name=?  where type_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setString(1, houseTypeInfo.getHouseTypeName());
			pre.setInt(2, houseTypeInfo.getHouseTypeId());

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
