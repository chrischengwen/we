package com.sxxy.servlet.notice;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerConditionInfo;
import com.sxxy.po.NoticeInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.NoticeService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.NoticeServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class NoticeAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NoticeAddServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//获取客户所属员工名
		UserService  userService = new UserServiceImpl();
		List<UserInfo>  userInfo  = userService.getList(null, null);
		request.setAttribute("userInfo", userInfo);
	
		request.getRequestDispatcher("/view/notice/notice_add.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");//处理乱码
		
		//获取页面文本框的值
		String userName = request.getParameter("customerForUser");
		String noticeTime = request.getParameter("noticeTime");
		String noticeEndTime = request.getParameter("noticeEndTime");
		String noticeItem = request.getParameter("noticeItem");
		String noticeContent = request.getParameter("noticeContent");
		
		//业务逻辑处理
		NoticeService service = new NoticeServiceImpl();
		
		//创建公告对象
		NoticeInfo noticeInfo = new NoticeInfo();
		
		try {	
			noticeInfo.setUserId(Integer.parseInt(userName));
		} catch (Exception e) {
			e.printStackTrace();
		}
		noticeInfo.setNoticeContent(noticeContent);
		noticeInfo.setNoticeItem(noticeItem);
		noticeInfo.setNoticeTime(noticeTime);
		noticeInfo.setNoticeEndTime(noticeEndTime);
		
		boolean mark = service.add(noticeInfo);
		if(mark){
			request.setAttribute("info", "公告添加成功");
		}else{
			request.setAttribute("info", "公告添加失败");
		}
		//转发
		request.getRequestDispatcher("/view/notice/notice_save.jsp").forward(request, response);
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
