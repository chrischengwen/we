package com.sxxy.servlet.houseType;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.dao.impl.HouseTypeServiceImpl;
import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.po.HouseTypeInfo;
import com.sxxy.service.HouseTypeService;

public class HouseTypeAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseTypeAddServlet() {
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
		String houseTypeName = request.getParameter("houseTypeName");
		
		//业务逻辑处理
		HouseTypeService service = new HouseTypeServiceImpl();
		
		//创建房屋类型对象
		HouseTypeInfo houseTypeInfo = new HouseTypeInfo();
		houseTypeInfo.setHouseTypeName(houseTypeName);
		
		boolean mark = service.add(houseTypeInfo);
		if(mark){
			request.setAttribute("info", "房屋类型添加成功");
		}else{
			request.setAttribute("info", "房屋类型添加失败");
		}
		//转发
		request.getRequestDispatcher("/view/houseType/houseType_save.jsp").forward(request, response);
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
