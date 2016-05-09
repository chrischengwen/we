package com.sxxy.servlet.customerType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.po.CustomerTypeInfo;
import com.sxxy.service.CustomerSourceService;
import com.sxxy.service.CustomerTypeService;
import com.sxxy.service.impl.CustomerSourceServiceImpl;
import com.sxxy.service.impl.CustomerTypeServiceImpl;

public class CustomerTypeAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerTypeAddServlet() {
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

		request.setCharacterEncoding("utf-8");//处理乱码
		
		//获取页面文本框的值
		String typeName = request.getParameter("typeName");
		
		//业务逻辑处理
		CustomerTypeService service = new CustomerTypeServiceImpl();
		
		//创建客户类型对象
		CustomerTypeInfo typeInfo = new CustomerTypeInfo();
		typeInfo.setCustomerTypeName(typeName);
		
		boolean mark = service.add(typeInfo);
		if(mark){
			request.setAttribute("info", "客户类型添加成功");
		}else{
			request.setAttribute("info", "客户类型添加失败");
		}
		//转发
		request.getRequestDispatcher("/view/customerType/customerType_save.jsp").forward(request, response);
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
