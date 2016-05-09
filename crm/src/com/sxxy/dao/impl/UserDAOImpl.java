package com.sxxy.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sxxy.dao.UserDAO;
import com.sxxy.po.UserInfo;
import com.sxxy.util.DBCon;

/**
 * 员工信息的实现类
 * @author 程文
 *
 */
public class UserDAOImpl implements UserDAO{

	/**
	 * 添加员工
	 */
	public boolean add(UserInfo usInfo) {
		
		//数据库连接
		Connection con=null;
		//预编译
		PreparedStatement pre=null;
		try{
			String sql = "insert into user_info (department_id,role_id,user_name,user_sex,user_mobile,user_age," +
					"user_address,user_num,user_pw,user_tel,user_idnum,user_email,user_addtime,user_changetime," +
					"user_intest,user_diploma,user_bankcard,user_nation,is_married,user_addman,user_changeman,is_used) " +
					"values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,1)";

		// 获取连接
		con = DBCon.getConnection();
		// 创建实例
		pre = con.prepareStatement(sql);
		pre.setInt(1,usInfo.getDepartmentId());
		pre.setInt(2, usInfo.getRoleId());
		pre.setString(3, usInfo.getUserName());
		pre.setString(4, usInfo.getUserSex());
		pre.setString(5, usInfo.getUserMobile());
		pre.setInt(6, usInfo.getUserAge());
		pre.setString(7, usInfo.getUserAddress());
		pre.setString(8, usInfo.getUserNum());
		pre.setString(9, usInfo.getUserPw());
		pre.setString(10, usInfo.getUserTel());
		pre.setString(11, usInfo.getUserIdnum());
		pre.setString(12, usInfo.getUserEmail());
		pre.setString(13, usInfo.getUserAddtime());
		pre.setString(14, usInfo.getUserChangetime());
		pre.setString(15, usInfo.getUserIntest());
		pre.setString(16, usInfo.getUserDiploma());
		pre.setString(17, usInfo.getUserBankcard());
		pre.setString(18, usInfo.getUserNation());
		pre.setString(19, usInfo.getIsMarried());
		pre.setString(20, usInfo.getUserAddman());
		pre.setString(21, "未修改");
		
		
		// 执行sql:增加，修改，删除都是用executeUpdate
		int i = pre.executeUpdate();

		if (i > 0) {
			return true;
		}
			
		}catch(Exception e){
			e.printStackTrace();
			
		}finally{
			try{
				// 关闭
				DBCon.closeCon(con);
				DBCon.closePre(pre);
				
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		return false;
	}

	/**
	 * 删除员工
	 */
	public boolean delete(int usId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update user_info set is_used=0 where user_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, usId);
			
			int i = pre.executeUpdate();
			if(i>0){
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return false;
	}

	/**
	 * 查询员工信息
	 */
	public List<UserInfo> getList(String userInput, String queryType) {
		//连接
		Connection con =null;
		//预编译
		PreparedStatement pre =null;
		//结果集
		List<UserInfo> list=null;
		ResultSet res=null;
		try {
			String sql = "select  a.*,b.department_name,c.role_name from user_info  a, department_info b,user_role c where  a.department_id = b.department_id and a.role_id=c.role_id and a.is_used=1";
			if (userInput != null && !"".equals(userInput.trim())&& "1".equals(queryType)) {
				sql+="  and  user_name  like '%"+userInput+"%'";
			}	else if (userInput != null && !"".equals(userInput.trim())&& "2".equals(queryType)) {
				sql+="  and  b.department_name  like '%"+userInput+"%'";
			}else if (userInput != null && !"".equals(userInput.trim())&& "3".equals(queryType)) {
				sql+="  and  c.role_name  like '%"+userInput+"%'";
			}else if (userInput != null && !"".equals(userInput.trim())&& "4".equals(queryType)) {
				sql+="  and  a.user_diploma   like  '%"+userInput+"%'";
			}
				//获取连接
				con= DBCon.getConnection();
				//创建实例
				pre=con.prepareStatement(sql);
				System.out.println("开始查询");
				//执行sql
				System.out.println(sql);
				res=pre.executeQuery();
				//创建集合
				list= new ArrayList<UserInfo>();
				UserInfo us=null;
				while(res.next()){
					 us=new UserInfo();
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
					us.setUserIntest(res.getString("user_intest"));
					us.setUserDiploma(res.getString("user_diploma"));
					us.setUserBankcard(res.getString("user_bankcard"));
					us.setIsMarried(res.getString("is_married"));
					us.setUserAddman(res.getString("user_addman"));
					us.setUserChangeman(res.getString("user_changeman"));
					us.setDepartmentName(res.getString("department_name"));
					us.setRoleName(res.getString("role_name"));
					list.add(us);
				}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBCon.closeCon(con);
			DBCon.closePre(pre);
			DBCon.closeRes(res);
		}	
		return list;
	}
	/**
	 * 根据id查询员工信息
	 */
	public UserInfo getUser(int usId) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;
		// 结果集
		ResultSet res = null;
		
		try {
			String sql = "select  a.*,b.department_name,c.role_name from user_info  a, department_info b,user_role c where  a.department_id = b.department_id and a.role_id=c.role_id and a.user_id=? and a.is_used=1";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			pre.setInt(1, usId);
			// 执行sql
			res = pre.executeQuery();
			
			
			if (res.next()) {
				UserInfo us = new UserInfo();
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
				us.setUserAddman(res.getString("user_addman"));
				us.setUserChangeman(res.getString("user_changeman"));
				us.setIsMarried(res.getString("is_married"));
				us.setDepartmentName(res.getString("department_name"));
				us.setRoleName(res.getString("role_name"));
					return us;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closeRes(res);
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return null;
	}

	/**
	 * 修改员工信息
	 */
	public boolean update(UserInfo usInfo) {
		// 声明
		// 数据库连接对象
		Connection con = null;
		// 实例
		PreparedStatement pre = null;

		try {
			String sql = "update user_info  set department_id=?,role_id=?,user_name=?,user_sex=?,user_mobile=?,user_age=?,user_address=?,user_num=?,user_pw=?,user_tel=?,user_idnum=?,user_email=?,user_addtime=?,user_changetime=?,user_intest=?,user_diploma=?,user_bankcard=?,user_nation=?,is_married=? ,user_addman=?,user_changeman=? ,is_used=1 where user_id=?";
			// 获取连接
			con = DBCon.getConnection();
			// 创建实例：预编译
			pre = con.prepareStatement(sql);
			
			pre.setInt(1, usInfo.getDepartmentId());
			pre.setInt(2, usInfo.getRoleId());
			pre.setString(3, usInfo.getUserName());			
			pre.setString(4, usInfo.getUserSex());
			pre.setString(5, usInfo.getUserMobile());
			pre.setInt(6, usInfo.getUserAge());
			pre.setString(7, usInfo.getUserAddress());
			pre.setString(8, usInfo.getUserNum());
			pre.setString(9, usInfo.getUserPw());
			pre.setString(10, usInfo.getUserTel());
			pre.setString(11, usInfo.getUserIdnum());
			pre.setString(12, usInfo.getUserEmail());
			pre.setString(13, usInfo.getUserAddtime());
			pre.setString(14, usInfo.getUserChangetime());
			pre.setString(15, usInfo.getUserIntest());
			pre.setString(16, usInfo.getUserDiploma());
			pre.setString(17, usInfo.getUserBankcard());
			pre.setString(18, usInfo.getUserNation());
			pre.setString(19, usInfo.getIsMarried());
			pre.setString(20, usInfo.getUserAddman());
			pre.setString(21,usInfo.getUserChangeman());
			pre.setInt(22, usInfo.getUserId());
			
			int i = pre.executeUpdate();
			if(i>0){
				return true;
			}

		} catch (Exception e) {
			e.printStackTrace();// 打印异常信息
		} finally {
			// 关闭
			DBCon.closePre(pre);
			DBCon.closeCon(con);
		}
		return false;
	}

	
}
