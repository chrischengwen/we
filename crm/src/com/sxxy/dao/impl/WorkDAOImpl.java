package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.WorkDAO;
import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.po.NoticeInfo;
import com.sxxy.util.DBCon;

public class WorkDAOImpl  implements WorkDAO {

	public List<CustomerInfo> getAllList(  int addTime ) {
		//生日提醒
		//数据库连接
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select a.*  , b.condition_name  from  customer_info a ,customer_condition  b  where    a.condition_id  =b.condition_id   and   a.is_used='1'  ";
			
			if(addTime == 0 ){
				
				sql += " and  TO_DAYS(birth_day) - TO_DAYS(now())=0 " ;
			} else	if(addTime != 0 ){
				
				sql += "  and   TO_DAYS(birth_day) - TO_DAYS(now()) >=0  and  TO_DAYS(birth_day) - TO_DAYS(now())<='"+addTime+"' " ;
			}
			
			// 获取连接
			con = DBCon.getConnection();
			
			// 创建实例
			pre = con.prepareStatement(sql);
			
			// 执行s q l
			res = pre.executeQuery();
			
			// 创建集合
			List<CustomerInfo> list = new ArrayList<CustomerInfo>();
			
			while (res.next()) {
				CustomerInfo customerInfo = new CustomerInfo();
				
				customerInfo.setCustomerId(res.getInt("customer_id"));
				customerInfo.setCustomerName(res.getString("customer_name"));
				customerInfo.setCustomerBirthday(res.getString("birth_day"));
				customerInfo.setCustomerMobile(res.getString("customer_mobile"));
				customerInfo.setConditionId(res.getInt("condition_id"));
				customerInfo.setCustomerCondition(res.getString("condition_name"));
				customerInfo.setIsUsed(res.getString("is_used"));
				
	
				list.add(customerInfo);
			}
			return list ;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	public List<LinkRecordInfo> getLinkMan( int addTime) {
		// 应联系的客户
		//数据库连接
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select a.*,b.customer_name from customer_linkreord  a,customer_info b where a.customer_id=b.customer_id and  a.is_used='1' ";
			if (addTime==0) {
				
				sql += " and  TO_DAYS(a.link_nexttime) - TO_DAYS(now())=0 " ;
				
			}else if(addTime!=0 ){
				
				sql += "     and TO_DAYS(a.link_nexttime) - TO_DAYS(now())>0     and  TO_DAYS(a.link_nexttime) - TO_DAYS(now())<='"+addTime+"' " ;
			}
			System.out.println(sql);
			
			// 获取连接
			con = DBCon.getConnection();
			
			// 创建实例
			pre = con.prepareStatement(sql);
			
			// 执行s q l
			res = pre.executeQuery();
			
			// 创建集合
			List<LinkRecordInfo> list = new ArrayList<LinkRecordInfo>();
			
			while (res.next()) {
				
				LinkRecordInfo linkRecordInfo = new LinkRecordInfo();
				
				linkRecordInfo.setCustomerId(res.getInt("customer_id"));
				linkRecordInfo.setCustomerName(res.getString("customer_name"));
				linkRecordInfo.setRecordId(res.getInt("record_id"));
				linkRecordInfo.setLinkType(res.getString("link_type"));
				linkRecordInfo.setWhoLink(res.getString("who_link"));
				linkRecordInfo.setLinkTheme(res.getString("link_theme"));
				linkRecordInfo.setLinkNexttime(res.getString("link_nexttime"));
				linkRecordInfo.setIsUsed(res.getString("is_used"));
				
	
				list.add(linkRecordInfo);
			}
			return list ;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	public List<NoticeInfo > getNotice() {
		//有效公告
		//数据库连接
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select a.*,b.user_name from notice_info  a,user_info  b where a.user_id=b.user_id and  a.is_used='1'  and  TO_DAYS(a.notice_endtime) - TO_DAYS(now())>0 " ;
	
			System.out.println(sql);
			
			// 获取连接
			con = DBCon.getConnection();
			
			// 创建实例
			pre = con.prepareStatement(sql);
			
			// 执行sql
			res = pre.executeQuery();
			
			// 创建集合
			List<NoticeInfo> list = new ArrayList<NoticeInfo>();
			
			while (res.next()) {
				NoticeInfo noticeInfo = new NoticeInfo();
				
				noticeInfo.setUserId(res.getInt("user_id"));
				noticeInfo.setUserName(res.getString("user_name"));
				noticeInfo.setNoticeId(res.getInt("notice_id"));
				noticeInfo.setNoticeItem(res.getString("notice_item"));
				noticeInfo.setNoticeContent(res.getString("notice_content"));
				noticeInfo.setNoticeEndTime(res.getString("notice_endtime"));
				noticeInfo.setNoticeIsUsed(res.getString("is_used"));
				
	
				list.add(noticeInfo);
			}
			return list ;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	public List<CustomerCareInfo > getCustomerCare( int addTime) {
		// 应关怀的客户
		
		//数据库连接
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select a.*,b.customer_name from customer_care  a,customer_info b where a.customer_id=b.customer_id and  a.is_used='1' ";
				
			if (addTime==0) {
				
				sql += " and  TO_DAYS(a.care_nexttime) - TO_DAYS(now())=0 " ;
				
			}else  if(addTime  !=0 ){
				
				sql += "   and TO_DAYS(a.care_nexttime) - TO_DAYS(now())>0  and  TO_DAYS(a.care_nexttime) - TO_DAYS(now())<='"+addTime+"' " ;
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
				CustomerCareInfo careInfo = new CustomerCareInfo();
				careInfo.setCustomerId(res.getInt("customer_id"));
				careInfo.setCustomerName(res.getString("customer_name"));
				careInfo.setCareId(res.getInt("care_id"));
				careInfo.setCareTheme(res.getString("care_theme"));
				careInfo.setCareWay(res.getString("care_way"));
				careInfo.setCareTime(res.getString("care_time"));
				careInfo.setCareRemark(res.getString("care_remark"));
				careInfo.setCareNexttime(res.getString("care_nexttime"));
				careInfo.setCarePeople(res.getString("care_people"));
				careInfo.setIsUsed(res.getString("is_used"));
				
	
				list.add(careInfo);
			}
			return list ;
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}finally{
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}



}
