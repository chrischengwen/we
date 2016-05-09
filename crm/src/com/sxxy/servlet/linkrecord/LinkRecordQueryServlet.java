package com.sxxy.servlet.linkrecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.sxxy.po.LinkRecordInfo;
import com.sxxy.service.LinkRecordService;
import com.sxxy.service.impl.LinkRecordServiceImpl;

public class LinkRecordQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LinkRecordQueryServlet() {
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
		
		//获取查询条件
		String whoLinkInput = request.getParameter("whoLinkInput");
		String queryType = request.getParameter("queryType");
		System.out.println(whoLinkInput);
		//用户管理的业务逻辑
		LinkRecordService service = new LinkRecordServiceImpl();
		
		//根据条件查询用户信息
		List<LinkRecordInfo> whoLinkList = service.getWholink(whoLinkInput,queryType);
		//List<LinkRecordInfo> list = service.getList(whoLink);
		//返回到页面
		request.setAttribute("list", whoLinkList);
		
		//转发
		request.getRequestDispatcher("/view/linkrecord/linkrecord_list.jsp").forward(request, response);
		
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
