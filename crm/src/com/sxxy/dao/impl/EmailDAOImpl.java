package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.EmailDAO;
import com.sxxy.po.EmailInfo;
import com.sxxy.util.DBCon;

public class EmailDAOImpl implements EmailDAO{

	public boolean add(EmailInfo email) {
		System.out.println("DAO"+email.getAddressee());
		
		//连接
		Connection con=null;
		//预编译
		PreparedStatement pre=null;
		
		try{
			String sql="insert into email_info(customer_id,user_id,email_content,email_time,email_state,email_theme,is_used)   value(?,?,?,?,?,?,1)";
		
			System.out.println(sql);
			//获取连接
			con=DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			pre.setInt(1, email.getCustomerId());
			pre.setInt(2, email.getUserId());
			pre.setString(3,email.getEmailContent());
			pre.setString(4,email.getEmailTime());
			pre.setInt(5,email.getEmailState());
			pre.setString(6,email.getEmailTheme());
			
			
			
			//执行
			int i=pre.executeUpdate();
			if(i>0){
				return true;
			}
	}catch(Exception e){
		e.printStackTrace();
		}finally{
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		
		}
	return false;
	}
		

	public boolean delete(int emailId) {
		
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		
		try{
			String sql="update email_info set  is_used = '0' where email_id =?";
		
			System.out.println(sql);
			//获取连接
			con=DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			
			pre.setInt(1,emailId);
						
			//执行
			int i=pre.executeUpdate();
			if(i>0){
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
			}finally{
				DBCon.closePre(pre);
				DBCon.closeCon(con);		
			}		
			
			return false;
		}

	
	public EmailInfo getEmail(int emailId) {

		//连接
		Connection con = null;
		//预编译
		PreparedStatement pre = null;
		//结果集
		ResultSet res = null;
		try{
			String sql = "select a.*,b.customer_name,c.user_name from email_info a,customer_info b ,user_info c   "
				+"  where a.user_id=c.user_id  and a.customer_id=b.customer_id and email_id=? and a.is_used=1";
			
			//获取连接
			con = DBCon.getConnection();
			//创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, emailId);
			
			//执行
			res = pre.executeQuery();
			 if(res.next()){
				 
				 EmailInfo email = new EmailInfo();
				 
				 email.setAddressee(res.getString("customer_name"));
				 email.setCustomerId(res.getInt("customer_id"));
				 email.setAddresser(res.getString("user_name"));
				 email.setUserId(res.getInt("user_id"));
				 email.setEmailContent(res.getString("email_content"));
				 email.setEmailId(res.getInt("email_id"));
				 email.setEmailState(res.getInt("email_state"));
				 email.setEmailTheme(res.getString("email_theme"));
				 email.setEmailTime(res.getString("email_time"));
				 email.setIsUsed(res.getString("is_used"));
				 
				 return email;
			 }
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}


	public List<EmailInfo> getAllEmail(String emailIput,String queryType) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		//结果集
		ResultSet res=null;
		
		try{
			String sql="select a.*,b.customer_name,c.user_name from email_info a,customer_info b ,user_info c   "
				+"  where a.user_id=c.user_id  and a.customer_id=b.customer_id and a.is_used=1   and  email_state =1    ";
			if(emailIput != null && !"".equals(emailIput) && "1".equals(queryType)){
				sql += " and   b.customer_name  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "2".equals(queryType)){
				sql += " and   c.user_name  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "3".equals(queryType)){
				sql += " and  a.email_content  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "4".equals(queryType)){
				sql += " and  a.email_theme  like '%"+emailIput+"%'  ";
			}
			System.out.println(sql);
			//获取连接
			con=DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			
			//执行sql
			res=pre.executeQuery();
			//创建集合
			List<EmailInfo>list=new ArrayList<EmailInfo>();
			
			while(res.next()){
				
				EmailInfo email=new EmailInfo();
				
				email.setAddressee(res.getString("customer_name"));
				 email.setCustomerId(res.getInt("customer_id"));
				 email.setAddresser(res.getString("user_name"));
				 email.setUserId(res.getInt("user_id"));
				 email.setEmailContent(res.getString("email_content"));
				 email.setEmailId(res.getInt("email_id"));
				 email.setEmailState(res.getInt("email_state"));
				 email.setEmailTheme(res.getString("email_theme"));
				 email.setEmailTime(res.getString("email_time"));
				 email.setIsUsed(res.getString("is_used"));
				 
				 list.add(email);
			}
			return list;
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBCon.closeRes(res);
		DBCon.closePre(pre);
		DBCon.closeCon(con);
			}
		return null;
	}


	public List<EmailInfo> getNoSendAllEmail(String emailIput,String queryType) {

		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		//结果集
		ResultSet res=null;
		List<EmailInfo> list=null;
		try{
			String sql="select a.*,b.customer_name,c.user_name from email_info a,customer_info b ,user_info c   "
				+"  where a.user_id=c.user_id  and a.customer_id=b.customer_id and a.is_used=1   and  email_state =0";
			if(emailIput != null && !"".equals(emailIput) && "1".equals(queryType)){
				sql += " and  b.customer_name  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "2".equals(queryType)){
				sql += " and   c.user_name  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "3".equals(queryType)){
				sql += " and  a.email_content  like '%"+emailIput+"%'  ";
			}else  if(emailIput != null && !"".equals(emailIput) && "4".equals(queryType)){
				sql += " and  a.email_theme  like '%"+emailIput+"%'  ";
			}
			System.out.println(sql);
			//获取连接
			con=DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			
			//执行sql
			res=pre.executeQuery();
			//创建集合
			list=new ArrayList<EmailInfo>();
			
			while(res.next()){
				
				EmailInfo email=new EmailInfo();
				
				email.setAddressee(res.getString("customer_name"));
				 email.setCustomerId(res.getInt("customer_id"));
				 email.setAddresser(res.getString("user_name"));
				 email.setUserId(res.getInt("user_id"));
				 email.setEmailContent(res.getString("email_content"));
				 email.setEmailId(res.getInt("email_id"));
				 email.setEmailState(res.getInt("email_state"));
				 email.setEmailTheme(res.getString("email_theme"));
				 email.setEmailTime(res.getString("email_time"));
				 email.setIsUsed(res.getString("is_used"));
				 
				 list.add(email);
			}
			
	}catch(Exception e){
		e.printStackTrace();
	}finally{
		DBCon.closeRes(res);
		DBCon.closePre(pre);
		DBCon.closeCon(con);
			}
		return list;
	}


	public boolean upadate(EmailInfo eamInfo) {
		// 修改
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update email_info set customer_id =?,user_id=?, email_content =?,email_time=?   ,email_state=?,email_theme=? , is_used=1 where email_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			
			pre.setInt(1, eamInfo.getCustomerId());
			pre.setInt(2, eamInfo.getUserId());
			pre.setString(3, eamInfo.getEmailContent());
			pre.setString(4, eamInfo.getEmailTime());
			pre.setInt(5, eamInfo.getEmailState());
			pre.setString(6, eamInfo.getEmailTheme());
			pre.setInt(7, eamInfo.getEmailId());
			
		

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
