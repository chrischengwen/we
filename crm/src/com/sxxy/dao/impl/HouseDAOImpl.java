package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.HouseDAO;
import com.sxxy.po.HouseInfo;
import com.sxxy.util.DBCon;

public class HouseDAOImpl  implements HouseDAO{

	public boolean add(HouseInfo house) {
		//添加
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into house_info (type_id,user_id, house_address,house_price,house_ambient)"
					+ "  values(?,?,?,?,?)";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
	        
			pre.setInt(1,house.getTypeId());;
			pre.setInt(2,house.getUserId());;
			pre.setString(3, house.getHouseAddress());
			pre.setDouble(4, house.getHousePrice());
			pre.setString(5, house.getHouseAmbient());
			
			// 执行s q l
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

	public boolean delete(int houseId) {
		//删除
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update   house_info set is_used=0  where house_id=?   ";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			pre.setInt(1, houseId);
			
			// 执行 s q l
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
	

	
	public HouseInfo getHouse(int houseId) {
		//根据Id查询
		// 连接
		Connection con = null;
		// 预编译                                                                                                                                                                                                                                                                                                         
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select a.*,b.type_name,c.user_name from house_info a ,house_type b , user_info c  where  a.type_id = b.type_id  and  a.user_id = c.user_id and a.is_used =1 and house_id = ?";
			
			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			
			pre = con.prepareStatement(sql);
			pre.setInt( 1,  houseId);
			// 执行s q l
			res = pre.executeQuery();
			// 创建集合

			if(res.next()) {
				HouseInfo houseInfo = new HouseInfo();
				
				houseInfo.setTypeId(res.getInt("type_id"));
				houseInfo.setTypeName(res.getString("type_name"));
				houseInfo.setUserId(res.getInt("user_id"));
				houseInfo.setUserName(res.getString("user_name"));
				houseInfo.setHouseId(res.getInt("house_id"));
				houseInfo.setHouseAmbient(res.getString("house_ambient"));
				houseInfo.setHousePrice(res.getDouble("house_price"));
				houseInfo.setHouseAddress(res.getString("house_address"));
				houseInfo.setIsUsed(res.getString("is_used"));
				
				return houseInfo;
			}

			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	public boolean update(HouseInfo house) {
	

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		//HouseInfo house = new HouseInfo();
		try {
			String sql = "update  house_info  set type_id=?,user_id=?,house_address=?,house_price=?,house_ambient=? ,is_used=1 where house_id=? ";
		
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, house.getTypeId());
			pre.setInt(2, house.getUserId());
			pre.setString(3, house.getHouseAddress());
			pre.setDouble(4, house.getHousePrice());
			pre.setString(5, house.getHouseAmbient());
			pre.setInt(6, house.getHouseId());

			// 执行s q l
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
	

	

	public List<HouseInfo> getAllHouse(String houseInput , String queryType  ,  int  userId) {
		//查询所有信息
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			
			if (userId ==0) {
				
				String sql = "select a.*,b.type_name,c.user_name from house_info a ,house_type b , user_info c  where  a.type_id = b.type_id  and  a.user_id = c.user_id and a.is_used =1 ";
				if (houseInput!= null && !"".equals(houseInput.trim()) && "1".equals(queryType)) {
					sql+="  and  b.type_name  like '%"+houseInput+"%'";
				}else  	if (houseInput!= null && !"".equals(houseInput.trim()) && "2".equals(queryType)) {
						sql+="  and  a.house_address  like '%"+houseInput+"%'";
				}
				// 获取连接
				con = DBCon.getConnection();
				// 创建实例
				pre = con.prepareStatement(sql);
				
			}else  if (userId !=1) {
				
				String sql1 = "select a.*,b.type_name,c.user_name from house_info a ,house_type b , user_info c  where  a.type_id = b.type_id  and  a.user_id = c.user_id   and  a.user_id =  '"+userId+"'  and a.is_used =1 ";
				
				if (houseInput!= null && !"".equals(houseInput.trim()) && "1".equals(queryType)) {
					sql1+="  and  b.type_name  like '%"+houseInput+"%'";
				}else  	if (houseInput!= null && !"".equals(houseInput.trim()) && "2".equals(queryType)) {
						sql1+="  and  a.house_address  like '%"+houseInput+"%'";
				}
				// 获取连接
				con = DBCon.getConnection();
				// 创建实例
				pre = con.prepareStatement(sql1);
			
			}else {
				
				String sql = "select a.*,b.type_name,c.user_name from house_info a ,house_type b , user_info c  where  a.type_id = b.type_id  and  a.user_id = c.user_id and a.is_used =1 ";
				if (houseInput!= null && !"".equals(houseInput.trim()) && "1".equals(queryType)) {
					sql+="  and  b.type_name  like '%"+houseInput+"%'";
				}else  	if (houseInput!= null && !"".equals(houseInput.trim()) && "2".equals(queryType)) {
						sql+="  and  a.house_address  like '%"+houseInput+"%'";
				}
				// 获取连接
				con = DBCon.getConnection();
				// 创建实例
				pre = con.prepareStatement(sql);
			}
			

			// 执行s q l
			res = pre.executeQuery();
			// 创建集合
			List<HouseInfo> list = new ArrayList<HouseInfo>();

			while (res.next()) {
				HouseInfo house = new HouseInfo();
				
				house.setHouseId(res.getInt("house_id"));
				house.setTypeId(res.getInt("type_id"));
				house.setTypeName(res.getString("type_name"));
				house.setUserId(res.getInt("user_id"));
				house.setUserName(res.getString("user_name"));
				house.setHouseAddress(res.getString("house_address"));
				house.setHouseAmbient(res.getString("house_ambient"));
			    house.setHousePrice(res.getDouble("house_price"));
				house.setIsUsed(res.getString("is_used"));
				list.add(house);
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

}
