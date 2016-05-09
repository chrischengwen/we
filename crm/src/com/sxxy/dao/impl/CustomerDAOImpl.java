package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.CustomerDAO;
import com.sxxy.po.CustomerInfo;
import com.sxxy.util.DBCon;

public class CustomerDAOImpl implements CustomerDAO {

	public boolean add(CustomerInfo customerInfo) {
		// 添加
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "insert into customer_info (condition_id,source_id,user_id, "
					+ "type_id,customer_name,customer_sex,customer_mobile,customer_qq, "
					+ "customer_address,customer_email,customer_remark,customer_job,"
					+ "customer_blog,customer_tel,customer_msn,birth_day,customer_addtime, "
					+ "customer_addman,customer_changtime,change_man,customer_company) "
					+ "  values(?,?,null,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, customerInfo.getConditionId());
			pre.setInt(2, customerInfo.getSourceId());
			//pre.setInt(3, customerInfo.getUserId());
			pre.setInt(3, customerInfo.getTypeId());
			pre.setString(4, customerInfo.getCustomerName());
			pre.setString(5, customerInfo.getCustomerSex());
			pre.setString(6, customerInfo.getCustomerMobile());
			pre.setString(7, customerInfo.getCustomerQq());
			pre.setString(8, customerInfo.getCustomerAddress());
			pre.setString(9, customerInfo.getCustomerEmail());
			pre.setString(10, customerInfo.getCustomerRemark());
			pre.setString(11, customerInfo.getCustomerJob());
			pre.setString(12, customerInfo.getCustomerBlog());
			pre.setString(13, customerInfo.getCustomerTel());
			pre.setString(14, customerInfo.getCustomerMsn());
			pre.setString(15, customerInfo.getCustomerBirthday());
			pre.setString(16, customerInfo.getCustomerAddTime());
			pre.setString(17, customerInfo.getCustomerAddMan());
			pre.setString(18, customerInfo.getCustomerChangeTime());
			pre.setString(19, customerInfo.getCustomerChangeMan());
			pre.setString(20, customerInfo.getCustomerCompany());
			

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

	public boolean delete(int customerId) {
		// 删除
		Connection con = null;
		PreparedStatement pre = null;
		try {
			String sql = "update customer_info set  is_used = '0' where customer_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setInt(1, customerId);

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

	public  CustomerInfo getAllList(int customerId) {
		// 查询一条记录
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name ,e.user_name  from customer_info a,customer_condition b, customer_source c,customer_type d,user_info e " 
				+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id and a.user_id = e.user_id and a.is_used=1  and customer_id =? ";

			
			//获取连接
			con= DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			
			pre.setInt(1, customerId);
			res = pre.executeQuery();

			if (res.next()) {

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
				customerInfo.setCustomerForUser(res.getString("user_name"));
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
				
				return customerInfo;
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
	
	public  List<CustomerInfo> getNoAdmeasure(  ) {
		// 查询未分配的记录
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name  from customer_info a,customer_condition b, customer_source c,customer_type d   where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id  and a.is_used=1  and a.user_id is null ";

			
			//获取连接
			con= DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			

			res = pre.executeQuery();

			List< CustomerInfo>  list  =  new ArrayList<CustomerInfo>();
				
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
	
	public List<CustomerInfo> query(String customerInput  , String queryType   ,int  userId  ) {
		// 查询
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			if (userId==0  ) {
				String sql = "select a.* ,b.condition_name, c.source_name,d.type_name ,e.user_name  from customer_info a,customer_condition b, customer_source c,customer_type d,user_info e " 
					+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id and a.user_id = e.user_id   and   a.user_id  is  not   null  and a.is_used=1  ";

				if (customerInput != null && !"".equals(customerInput.trim()) && "1".equals(queryType)) {
					sql+="  and  customer_name  like '%"+customerInput+"%'";
				}	else if (customerInput != null && !"".equals(customerInput.trim())&& "2".equals(queryType)) {
					sql+="  and  b.condition_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "3".equals(queryType)) {
					sql+="  and  c.source_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "4".equals(queryType)) {
					sql+="  and  d.type_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "5".equals(queryType)) {
					sql+="  and  e.user_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "6".equals(queryType)) {
					sql+="  and  a.customer_company  like '%"+customerInput+"%'";
				}
				
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
			}else  if (userId!=1){		
				
				String sql1 = "select a.* ,b.condition_name, c.source_name,d.type_name ,e.user_name  from customer_info a,customer_condition b, customer_source c,customer_type d,user_info e " 
					+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id and a.user_id = e.user_id   and   a.user_id  is  not   null  and a.user_id =  '"+userId+"' and a.is_used=1  ";
				
				if (customerInput != null && !"".equals(customerInput.trim()) && "1".equals(queryType)) {
					sql1+="  and  customer_name  like '%"+customerInput+"%'";
				}	else if (customerInput != null && !"".equals(customerInput.trim())&& "2".equals(queryType)) {
					sql1+="  and  b.condition_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "3".equals(queryType)) {
					sql1+="  and  c.source_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "4".equals(queryType)) {
					sql1+="  and  d.type_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "5".equals(queryType)) {
					sql1+="  and  e.user_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "6".equals(queryType)) {
					sql1+="  and  a.customer_company  like '%"+customerInput+"%'";
				}		
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql1);
			}else {
				
				String sql = "select a.* ,b.condition_name, c.source_name,d.type_name ,e.user_name  from customer_info a,customer_condition b, customer_source c,customer_type d,user_info e " 
					+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id and a.user_id = e.user_id   and   a.user_id  is  not   null  and a.is_used=1  ";

				if (customerInput != null && !"".equals(customerInput.trim()) && "1".equals(queryType)) {
					sql+="  and  customer_name  like '%"+customerInput+"%'";
				}	else if (customerInput != null && !"".equals(customerInput.trim())&& "2".equals(queryType)) {
					sql+="  and  b.condition_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "3".equals(queryType)) {
					sql+="  and  c.source_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "4".equals(queryType)) {
					sql+="  and  d.type_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "5".equals(queryType)) {
					sql+="  and  e.user_name  like '%"+customerInput+"%'";
				}else if (customerInput != null && !"".equals(customerInput.trim())&& "6".equals(queryType)) {
					sql+="  and  a.customer_company  like '%"+customerInput+"%'";
				}
				
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				
			}
			
			
				
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
				customerInfo.setCustomerForUser(res.getString("user_name"));
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

	public boolean update(CustomerInfo customerInfo) {
		// 修改
		
		System.out.println(customerInfo.getCustomerBirthday());
		Connection con = null;
		PreparedStatement pre = null;

		try {
			String sql = "update customer_info set  condition_id=?,source_id=? , "
				+" user_id=?,type_id=?,customer_name=?,customer_sex=?,customer_mobile=?, "
				+" customer_qq=?,customer_address=?,customer_email=?,customer_remark=?," 
				+" customer_job=?,customer_blog=?,customer_tel=?,customer_msn=?,birth_day=?, "
				+" customer_addtime=?,customer_addman=?,customer_changtime=?,change_man=?, "
				+" customer_company=? where customer_id =?";

			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
		
			pre.setInt(1, customerInfo.getConditionId());
			pre.setInt(2, customerInfo.getSourceId());
			pre.setInt(3, customerInfo.getUserId());
			pre.setInt(4, customerInfo.getTypeId());
			pre.setString(5, customerInfo.getCustomerName());
			pre.setString(6, customerInfo.getCustomerSex());
			pre.setString(7, customerInfo.getCustomerMobile());
			pre.setString(8, customerInfo.getCustomerQq());
			pre.setString(9, customerInfo.getCustomerAddress());
			pre.setString(10, customerInfo.getCustomerEmail());
			pre.setString(11, customerInfo.getCustomerRemark());
			pre.setString(12, customerInfo.getCustomerJob());
			pre.setString(13, customerInfo.getCustomerBlog());
			pre.setString(14, customerInfo.getCustomerTel());
			pre.setString(15, customerInfo.getCustomerMsn());
			pre.setString(16, customerInfo.getCustomerBirthday());
			pre.setString(17, customerInfo.getCustomerAddTime());
			pre.setString(18, customerInfo.getCustomerAddMan());
			pre.setString(19, customerInfo.getCustomerChangeTime());
			pre.setString(20, customerInfo.getCustomerChangeMan());
			pre.setString(21, customerInfo.getCustomerCompany());
			pre.setInt(22, customerInfo.getCustomerId());

			// 执行s q l:增加，修改，删除都是用executeUpdate
			int i = pre.executeUpdate();
			System.out.println(customerInfo.getCustomerBirthday());
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

	public CustomerInfo getAdmeasure(int customerId) {
		// 查询一条未分配记录
		Connection con = null;
		PreparedStatement pre = null;
		ResultSet res = null;
		try {
			//多表查询
			String sql = "select a.* ,b.condition_name, c.source_name,d.type_name   from customer_info a,customer_condition b, customer_source c,customer_type d   " 
				+"  where a.condition_id=b.condition_id and a.source_id=c.source_id and a.type_id =d.type_id  and a.is_used=1 and  a.user_id  is null and    customer_id =? ";

			
			//获取连接
			con= DBCon.getConnection();
			//创建实例
			pre=con.prepareStatement(sql);
			
			pre.setInt(1, customerId);
			res = pre.executeQuery();

			if (res.next()) {

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
				
				return customerInfo;
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


}
