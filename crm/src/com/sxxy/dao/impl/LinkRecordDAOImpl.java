package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.LinkRecordDAO;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.util.DBCon;

public class LinkRecordDAOImpl implements LinkRecordDAO {


	public boolean add(LinkRecordInfo linkRecordInfo) {
		//添加
		
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_linkreord (record_id,customer_id,link_time,who_link,link_type,link_theme,link_nexttime,link_remark)"
					+ "  values(?,?,?,?,?,?,?,?)";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, linkRecordInfo.getRecordId());
			pre.setInt(2, linkRecordInfo.getCustomerId());
			pre.setString(3, linkRecordInfo.getLinkTime());
			pre.setString(4, linkRecordInfo.getWhoLink());
			pre.setString(5, linkRecordInfo.getLinkType());
			pre.setString(6, linkRecordInfo.getLinkTheme());
			pre.setString(7, linkRecordInfo.getLinkNexttime());
			pre.setString(8, linkRecordInfo.getLinkRemark());
			

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

	public boolean delete(int recordId) {
		//删除
		
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;

		try {
			String sql = "delete from   customer_linkreord  where record_id=? ";

			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);

			pre.setInt(1, recordId);


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

	public List<LinkRecordInfo> getWholink(String whoLinkInput ,String queryType) {

		//查询
		
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select a.*,b.customer_name from customer_linkreord a ,customer_info b where  a.customer_id = b.customer_id ";

			if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "1".equals(queryType)) {
				sql+="  and  b.customer_name  like '%"+whoLinkInput+"%'";
			}	else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "2".equals(queryType)) {
				sql+="  and  link_theme  like '%"+whoLinkInput+"%'";
			}else if (whoLinkInput != null && !"".equals(whoLinkInput.trim())&& "3".equals(queryType)) {
				sql+="  and  link_type  like '%"+whoLinkInput+"%'";
			}
			System.out.println(sql);
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			// 执行sql
			res = pre.executeQuery();
			// 创建集合
			List<LinkRecordInfo> list = new ArrayList<LinkRecordInfo>();

			while (res.next()) {
				LinkRecordInfo LinkRecord = new LinkRecordInfo();
				LinkRecord.setRecordId(res.getInt("record_id"));
				LinkRecord.setCustomerName(res.getString("customer_name"));
				LinkRecord.setCustomerId(res.getInt("customer_id"));
				LinkRecord.setLinkTime(res.getString("link_time"));
				LinkRecord.setWhoLink(res.getString("who_link"));
				LinkRecord.setLinkType(res.getString("link_type"));
				LinkRecord.setLinkTheme(res.getString("link_theme"));
				LinkRecord.setLinkNexttime(res.getString("link_nexttime"));
				LinkRecord.setLinkRemark(res.getString("link_remark"));
				list.add(LinkRecord);
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
