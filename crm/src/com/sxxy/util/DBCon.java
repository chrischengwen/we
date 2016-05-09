package com.sxxy.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 数据库连接对象
 * 
 * @author 刘少林
 * 
 */
public class DBCon {

	/**
	 * 获取数据库连接
	 * 
	 * @return
	 */
	public static Connection getConnection() {

		try {
			String url = "jdbc:mysql://192.168.31.69:3306/crm?user=root&password=root";
			// 加载驱动
			Class.forName("com.mysql.jdbc.Driver");
			// 获取连接
			Connection con = DriverManager.getConnection(url);
			
			return con;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}
	
	/**
	 * 关闭连接
	 * @param con
	 */
	public static void  closeCon(Connection con){
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭实例
	 * @param pre
	 */
	public static void  closePre(PreparedStatement pre){
		try {
			pre.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 关闭结果集
	 * @param res
	 */
	public static void  closeRes(ResultSet res){
		try {
			res.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
