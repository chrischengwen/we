package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.LinkManDAO;
import com.sxxy.po.LinkManInfo;
import com.sxxy.util.DBCon;

public class LinkManDAOImpl implements LinkManDAO  {
	
	public boolean add(LinkManInfo Linkman) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_linkman(customer_id,linkman_name,linkman_age,linkman_sex,linkman_job,linkman_mobile,linkman_relation)"
					+ "  values(?,?,?,?,?,?,?)";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, Linkman.getCoustomerId());
			pre.setString(2, Linkman.getLinkmanName());
			pre.setInt(3, Linkman.getLinkmanAge());
			pre.setString(4, Linkman.getLinkmanSex());
			pre.setString(5, Linkman.getLinkmanJob());
			pre.setString(6, Linkman.getLinkmanMobile());
			pre.setString(7, Linkman.getLinkmanRelation());
		

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
	
	public boolean delete(int LinkmanId) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update customer_linkman set  is_used = '0' where linkman_id =?";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, LinkmanId);
			

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


	public boolean update(LinkManInfo LinkmanInfo) {


		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "update  customer_linkman  set customer_id=?,  linkman_name=?,linkman_sex=?,linkman_job=? ,linkman_mobile=?, linkman_age=?,linkman_relation=?  where linkman_id=? ";

			
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, LinkmanInfo.getCoustomerId());
			pre.setString(2, LinkmanInfo.getLinkmanName());
			pre.setString(3, LinkmanInfo.getLinkmanSex());
			pre.setString(4, LinkmanInfo.getLinkmanJob());
			pre.setString(5, LinkmanInfo.getLinkmanMobile());
			pre.setInt(6, LinkmanInfo.getLinkmanAge());
			pre.setString(7, LinkmanInfo.getLinkmanRelation());
			pre.setInt(8, LinkmanInfo.getLinkmanId());
			
						
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

	public LinkManInfo getList(int LinkmanId) {
		// TODO Auto-generated method stub
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select a.*,b.customer_name from customer_linkman a,customer_info b where a.customer_id = b.customer_id and a.is_used =1 and  a.linkman_id =?";
			
			
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, LinkmanId);
			// 执行sql
			res = pre.executeQuery();
			// 创建集合

			while (res.next()) {
				
				LinkManInfo linkManInfo = new LinkManInfo();
				

				linkManInfo.setCoustomerId(res.getInt("customer_id"));
				linkManInfo.setCoustomerName(res.getString("customer_name"));
				linkManInfo.setLinkmanId(res.getInt("linkman_id"));
				linkManInfo.setLinkmanName(res.getString("linkman_name"));
				linkManInfo.setLinkmanSex(res.getString("linkman_sex"));
				linkManInfo.setLinkmanAge(res.getInt("linkman_age"));
				linkManInfo.setLinkmanMobile(res.getString("linkman_mobile"));
				linkManInfo.setLinkmanJob(res.getString("linkman_job"));
				linkManInfo.setLinkmanRelation(res.getString("linkman_relation"));
				linkManInfo.setIsUsed(res.getString("is_used"));
				
				return linkManInfo;
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

	public List<LinkManInfo> query(String LinkmanInput, String queryType) {
		// TODO Auto-generated method stub
		
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select a.*,b.customer_name from customer_linkman a,customer_info b where a.customer_id = b.customer_id and a.is_used =1";
			
			if (LinkmanInput != null && !"".equals(LinkmanInput.trim()) && "1".equals(queryType)) {
				sql += "  and  linkman_name  like   '%" + LinkmanInput + "%' ";
			}else if (LinkmanInput != null && !"".equals(LinkmanInput.trim()) && "1".equals(queryType))  {
				sql += "  and  b.customer_name  like   '%" + LinkmanInput + "%' ";
			}
			
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			// 执行sql
			res = pre.executeQuery();
			// 创建集合
			List<LinkManInfo> list = new ArrayList<LinkManInfo>();

			while (res.next()) {
				
				LinkManInfo linkman = new LinkManInfo();
				
				linkman.setCoustomerId(res.getInt("customer_id"));
				linkman.setCoustomerName(res.getString("customer_name"));
				linkman.setLinkmanId(res.getInt("linkman_id"));
				linkman.setLinkmanName(res.getString("linkman_name"));
				linkman.setLinkmanSex(res.getString("linkman_sex"));
				linkman.setLinkmanAge(res.getInt("linkman_age"));
				linkman.setLinkmanMobile(res.getString("linkman_mobile"));
				linkman.setLinkmanJob(res.getString("linkman_job"));
				linkman.setLinkmanRelation(res.getString("linkman_relation"));
				linkman.setIsUsed(res.getString("is_used"));
				
				list.add(linkman);
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
