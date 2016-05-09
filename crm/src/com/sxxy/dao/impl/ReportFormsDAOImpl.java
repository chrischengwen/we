package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.ReportFormsDAO;
import com.sxxy.po.CustomerInfo;
import com.sxxy.util.DBCon;

public class ReportFormsDAOImpl  implements ReportFormsDAO {

	public List<CustomerInfo> count() {
		// 客户分配状况统计
Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select count(*)  num  from customer_info where user_id is   NULL   " ;
	
				
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
				
				customerInfo.setNum(res.getInt("num"));
				
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

	public List<CustomerInfo> countCondition() {
		// 客户状态统计
		//数据库连接
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select   a.condition_id   ,a.condition_name , b.num   from  customer_condition  a  ,  ( select condition_id,count(condition_id)  num   from  customer_info  where  is_used =1  group by  condition_id   )  b  where a.condition_id  =b.condition_id   " ;
	
				
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
				
				customerInfo.setConditionId(res.getInt("condition_id"));
				customerInfo.setCustomerCondition(res.getString("condition_name"));
				customerInfo.setNum(res.getInt("num"));
				
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

	public List<CustomerInfo> countSource() {
		// 客户来源统计
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select   a.source_id   ,a.source_name , b.num   from  customer_source   a  ,  ( select source_id,count(source_id)  num   from  customer_info  where  is_used =1  group by  source_id   )  b  where a.source_id  =b.source_id   " ;
	
				
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
				
				customerInfo.setSourceId(res.getInt("source_id"));
				customerInfo.setCustomerSource(res.getString("source_name"));
				customerInfo.setNum(res.getInt("num"));
				
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

	public List<CustomerInfo> countType() {
		// 客户类型统计
		Connection con = null;
		
		//创建一个实例：预编译
		PreparedStatement pre = null;
		
		//结果集
		ResultSet res = null;
		try {
			
			String sql = "select   a.type_id   ,a.type_name , b.num   from  customer_type   a  ,  ( select type_id,count(type_id)  num   from  customer_info  where  is_used =1  group by  type_id   )  b  where a.type_id  =b.type_id   " ;
	
				
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
				
				customerInfo.setTypeId(res.getInt("type_id"));
				customerInfo.setCustomerType(res.getString("type_name"));
				customerInfo.setNum(res.getInt("num"));
				
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

	public List<CustomerInfo> queryCondition(int conditionId) {
		// 状态查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name   from customer_info a,customer_condition b, customer_source c,customer_type d " 
				+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id    and a.is_used=1  ";

			if (conditionId != 0) {
				sql+="  and  b.condition_id  = '"+conditionId+"'";
			}	
			
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				
			res = pre.executeQuery();

			List<CustomerInfo> list = new ArrayList<CustomerInfo>();
			while (res.next()) {

				CustomerInfo customerInfo = new CustomerInfo();

				customerInfo.setCustomerId(res.getInt("customer_id"));
				customerInfo.setCustomerName(res.getString("customer_name"));
				customerInfo.setConditionId(res.getInt("condition_id"));
				customerInfo.setCustomerCondition(res.getString("condition_name"));
				customerInfo.setSourceId(res.getInt("source_id"));
				customerInfo.setCustomerSource(res.getString("source_name"));
				customerInfo.setTypeId(res.getInt("type_id"));
				customerInfo.setCustomerType(res.getString("type_name"));
				customerInfo.setUserId(res.getInt("user_id"));
				customerInfo.setCustomerSex(res.getString("customer_sex"));
				customerInfo.setCustomerMobile(res.getString("customer_mobile"));
				customerInfo.setCustomerQq(res.getString("customer_qq"));
				customerInfo.setCustomerAddress(res.getString("customer_address"));
				customerInfo.setCustomerEmail(res.getString("customer_email"));
				customerInfo.setCustomerRemark(res.getString("customer_remark"));
				customerInfo.setCustomerJob(res.getString("customer_job"));
				customerInfo.setCustomerBlog(res.getString("customer_blog"));
				customerInfo.setCustomerTel(res.getString("customer_tel"));
				customerInfo.setCustomerMsn(res.getString("customer_msn"));
				customerInfo.setCustomerBirthday(res.getString("birth_day"));
				customerInfo.setCustomerAddTime(res.getString("customer_addtime"));
				customerInfo.setCustomerAddMan(res.getString("customer_addman"));
				customerInfo.setCustomerChangeTime(res.getString("customer_changtime"));
				customerInfo.setCustomerChangeMan(res.getString("change_man"));
				customerInfo.setCustomerCompany(res.getString("customer_company"));
				customerInfo.setIsUsed(res.getString("is_used"));
				
				list.add(customerInfo);
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

	public List<CustomerInfo> querySource(int sourceId) {
		// 来源查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name   from customer_info a,customer_condition b, customer_source c,customer_type d " 
				+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id   and a.is_used=1  ";

			if (sourceId !=0) {
				sql+="  and  c.source_Id   =  '"+sourceId+"'";
			}	
			
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				
			res = pre.executeQuery();

			List<CustomerInfo> list = new ArrayList<CustomerInfo>();
			while (res.next()) {

				CustomerInfo customerInfo = new CustomerInfo();

				customerInfo.setCustomerId(res.getInt("customer_id"));
				customerInfo.setCustomerName(res.getString("customer_name"));
				customerInfo.setConditionId(res.getInt("condition_id"));
				customerInfo.setCustomerCondition(res.getString("condition_name"));
				customerInfo.setSourceId(res.getInt("source_id"));
				customerInfo.setCustomerSource(res.getString("source_name"));
				customerInfo.setTypeId(res.getInt("type_id"));
				customerInfo.setCustomerType(res.getString("type_name"));
				customerInfo.setCustomerSex(res.getString("customer_sex"));
				customerInfo.setCustomerMobile(res.getString("customer_mobile"));
				customerInfo.setCustomerQq(res.getString("customer_qq"));
				customerInfo.setCustomerAddress(res.getString("customer_address"));
				customerInfo.setCustomerEmail(res.getString("customer_email"));
				customerInfo.setCustomerRemark(res.getString("customer_remark"));
				customerInfo.setCustomerJob(res.getString("customer_job"));
				customerInfo.setCustomerBlog(res.getString("customer_blog"));
				customerInfo.setCustomerTel(res.getString("customer_tel"));
				customerInfo.setCustomerMsn(res.getString("customer_msn"));
				customerInfo.setCustomerBirthday(res.getString("birth_day"));
				customerInfo.setCustomerAddTime(res.getString("customer_addtime"));
				customerInfo.setCustomerAddMan(res.getString("customer_addman"));
				customerInfo.setCustomerChangeTime(res.getString("customer_changtime"));
				customerInfo.setCustomerChangeMan(res.getString("change_man"));
				customerInfo.setCustomerCompany(res.getString("customer_company"));
				customerInfo.setIsUsed(res.getString("is_used"));
				
				list.add(customerInfo);
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

	public List<CustomerInfo> queryType(int typeId) {
		// 类型查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name   from customer_info a,customer_condition b, customer_source c,customer_type d " 
				+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id      and a.is_used=1  ";

			if (typeId != 0) {
				sql+="  and  d.type_id  = '"+typeId+"'";
			}	
			
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				
			res = pre.executeQuery();

			List<CustomerInfo> list = new ArrayList<CustomerInfo>();
			while (res.next()) {

				CustomerInfo customerInfo = new CustomerInfo();

				customerInfo.setCustomerId(res.getInt("customer_id"));
				customerInfo.setCustomerName(res.getString("customer_name"));
				customerInfo.setConditionId(res.getInt("condition_id"));
				customerInfo.setCustomerCondition(res.getString("condition_name"));
				customerInfo.setSourceId(res.getInt("source_id"));
				customerInfo.setCustomerSource(res.getString("source_name"));
				customerInfo.setTypeId(res.getInt("type_id"));
				customerInfo.setCustomerType(res.getString("type_name"));
				customerInfo.setCustomerSex(res.getString("customer_sex"));
				customerInfo.setCustomerMobile(res.getString("customer_mobile"));
				customerInfo.setCustomerQq(res.getString("customer_qq"));
				customerInfo.setCustomerAddress(res.getString("customer_address"));
				customerInfo.setCustomerEmail(res.getString("customer_email"));
				customerInfo.setCustomerRemark(res.getString("customer_remark"));
				customerInfo.setCustomerJob(res.getString("customer_job"));
				customerInfo.setCustomerBlog(res.getString("customer_blog"));
				customerInfo.setCustomerTel(res.getString("customer_tel"));
				customerInfo.setCustomerMsn(res.getString("customer_msn"));
				customerInfo.setCustomerBirthday(res.getString("birth_day"));
				customerInfo.setCustomerAddTime(res.getString("customer_addtime"));
				customerInfo.setCustomerAddMan(res.getString("customer_addman"));
				customerInfo.setCustomerChangeTime(res.getString("customer_changtime"));
				customerInfo.setCustomerChangeMan(res.getString("change_man"));
				customerInfo.setCustomerCompany(res.getString("customer_company"));
				customerInfo.setIsUsed(res.getString("is_used"));
				
				list.add(customerInfo);
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
