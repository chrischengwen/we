package com.sxxy.servlet.notice;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerConditionInfo;
import com.sxxy.po.NoticeInfo;
import com.sxxy.service.CustomerConditionService;
import com.sxxy.service.NoticeService;
import com.sxxy.service.impl.CustomerConditionServiceImpl;
import com.sxxy.service.impl.NoticeServiceImpl;

public class NoticeQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NoticeQueryServlet() {
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

		doPost(request, response);
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

		request.setCharacterEncoding("utf-8");
		
		String noticeInput = request.getParameter("noticeInput");
		String queryType = request.getParameter("queryType");
		
		NoticeService service =new NoticeServiceImpl();
		
		List<NoticeInfo>  list=  service.query(noticeInput,queryType) ;
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/notice/notice_list.jsp").forward(request, response);
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
