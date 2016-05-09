package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.NoticeDAO;
import com.sxxy.po.NoticeInfo;
import com.sxxy.util.DBCon;

public class NoticeDaoImpl  implements NoticeDAO{

	public boolean add(NoticeInfo noticeInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into notice_info (user_id,notice_item,notice_content,notice_time,notice_endtime)  values(?,?,?,?,?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, noticeInfo.getUserId());
			pre.setString(2, noticeInfo.getNoticeItem());
			pre.setString(3, noticeInfo.getNoticeContent());
			pre.setString(4, noticeInfo.getNoticeTime());
			pre.setString(5, noticeInfo.getNoticeEndTime());

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

	public boolean delete(int noticeId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update notice_info set  is_used = '0' where notice_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, noticeId);

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

	public List<NoticeInfo> query(String noticeInput, String queryType) {
		//查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {

			String sql = "select a.* ,b.user_name  from notice_info a ,user_info b   where    a.user_id = b.user_id and  a.is_used=1  ";
			
			if (noticeInput != null && !"".equals(noticeInput.trim())&& "1".equals(queryType)) {
				sql+="  and  notice_item  like '%"+noticeInput+"%'";
			}	else if (noticeInput != null && !"".equals(noticeInput.trim())&& "2".equals(queryType)) {
				sql+="  and  notice_content  like '%"+noticeInput+"%'";
			}

				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				
			res = pre.executeQuery();

			List<NoticeInfo> list = new ArrayList<NoticeInfo>();
			while (res.next()) {

				NoticeInfo noticeInfo = new NoticeInfo();

				noticeInfo.setNoticeId(res.getInt("notice_id"));
				noticeInfo.setNoticeItem(res.getString("notice_item"));
				noticeInfo.setUserId(res.getInt("user_id"));
				noticeInfo.setUserName(res.getString("user_name"));
				noticeInfo.setNoticeContent(res.getString("notice_content"));
				noticeInfo.setNoticeTime(res.getString("notice_time"));
				noticeInfo.setNoticeEndTime(res.getString("notice_endtime"));
				noticeInfo.setNoticeIsUsed(res.getString("is_used"));
			
				list.add(noticeInfo);
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

	public boolean update(NoticeInfo noticeInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update notice_info set  user_id=?,notice_item=? ,notice_content=?,notice_time=?,notice_endtime=? where notice_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setInt(1, noticeInfo.getUserId());
			pre.setString(2, noticeInfo.getNoticeItem());
			pre.setString(3, noticeInfo.getNoticeContent());
			pre.setString(4, noticeInfo.getNoticeTime());
			pre.setString(5, noticeInfo.getNoticeEndTime());
			pre.setInt(6, noticeInfo.getNoticeId());

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
