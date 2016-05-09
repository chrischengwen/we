package com.sxxy.servlet.customerCare;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerCareService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerCareServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class CustomerCareQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerCareQueryServlet() {
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
		//获取页面文本框的值
		String customerInput = request.getParameter("customerInput");
		String queryType = request.getParameter("queryType");
		//业务逻辑
		CustomerCareService service =new CustomerCareServiceImpl();
		
		//根据条件查询员工信息
		List<CustomerCareInfo> list = service.getList(customerInput,queryType);
		//存放到request
		request.setAttribute("list", list);
		//转发
		request.getRequestDispatcher("/view/customerCare/customerCare_list.jsp").forward(request, response);
	
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
