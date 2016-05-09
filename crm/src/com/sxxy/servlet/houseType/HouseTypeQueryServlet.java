package com.sxxy.servlet.houseType;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.dao.impl.HouseTypeServiceImpl;
import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.po.HouseTypeInfo;
import com.sxxy.service.CustomerSourceService;
import com.sxxy.service.HouseTypeService;
import com.sxxy.service.impl.CustomerSourceServiceImpl;

public class HouseTypeQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseTypeQueryServlet() {
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
		String houseTypeName = request.getParameter("houseTypeName");
	
		HouseTypeService service = new HouseTypeServiceImpl();
		
		List<HouseTypeInfo>  list=  service.query(houseTypeName);
		request.setAttribute("list", list);
		
		request.getRequestDispatcher("/view/houseType/houseType_list.jsp").forward(request, response);
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
