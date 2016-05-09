package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.LoginDAO;
import com.sxxy.po.UserInfo;
import com.sxxy.util.DBCon;

public class LoginDAOImpl implements LoginDAO {

	public List<UserInfo> query(UserInfo userInfo) {
		// 连接
		Connection con = null;
		// 预编译
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		try {
			String sql = "select * from user_info where user_num=?  and is_used=1  ";
		
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例
			pre = con.prepareStatement(sql);
			pre.setString(1, userInfo.getUserNum());
			// 执行s q l
			res = pre.executeQuery();
			// 创建集合
			List<UserInfo> list = new ArrayList<UserInfo>();

			while (res.next()) {
				UserInfo user= new UserInfo();
				user.setUserNum(res.getString("user_num"));
				user.setUserPw(res.getString("user_pw"));
				user.setIsUsed(res.getString("is_used"));

				list.add(user);
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

	public UserInfo  getAllList(String userNum) {
		// 查询员工的信息
		
		//连接
		Connection con =null;
		//预编译
		PreparedStatement pre =null;
		//结果集
		
		ResultSet res=null;
		try {
			String sql = "select  a.*,b.department_name,c.*  from user_info  a, department_info b,user_role c where  a.department_id = b.department_id and a.role_id=c.role_id and a.is_used=1  and   user_num  = '"+userNum+"'";		
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				//执行sql
				//System.out.println(sql);
				res=pre.executeQuery();
				//创建集合
				
				
				if(res.next()){
					
					UserInfo us=new UserInfo();
					
					us.setDepartmentId(res.getInt("department_id"));
					us.setUserId(res.getInt("user_id"));
					us.setRoleId(res.getInt("role_id"));
					us.setUserName(res.getString("user_name"));
					us.setUserSex(res.getString("user_sex"));
					us.setUserAge(res.getInt("user_age"));
					us.setUserMobile(res.getString("user_mobile"));
					us.setUserAddress(res.getString("user_address"));
					us.setUserNum(res.getString("user_num"));
					us.setUserPw(res.getString("user_pw"));
					us.setUserTel(res.getString("user_tel"));
					us.setUserIdnum(res.getString("user_idnum"));
					us.setUserEmail(res.getString("user_email"));
					us.setUserAddtime(res.getString("user_addtime"));
					us.setUserChangetime(res.getString("user_changetime"));
					us.setUserIntest(res.getString("user_intest"));
					us.setUserDiploma(res.getString("user_diploma"));
					us.setUserBankcard(res.getString("user_bankcard"));
					us.setUserNation(res.getString("user_nation"));
					us.setIsMarried(res.getString("is_married"));
					us.setUserAddman(res.getString("user_addman"));
					us.setUserChangeman(res.getString("user_changeman"));
					us.setDepartmentName(res.getString("department_name"));
					us.setRoleName(res.getString("role_name"));
					us.setRolePower(res.getInt("role_power"));
		
					return   us;
				}
				

		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}
		return null;
	}

}
