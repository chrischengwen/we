package com.sxxy.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 获取时间的公告类
 * @author 刘少林
 *
 */
public class GetDate {

	public static String getDate(int amount){
		//操作时间的类
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());//设置当前时间
		calendar.add(Calendar.DATE, amount);//取前或后的某一天 日期
		
		//格式化时间和日期
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		
		String date = sf.format(calendar.getTime());
		
		return date;
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println(getDate(-7));
	}
	
}
