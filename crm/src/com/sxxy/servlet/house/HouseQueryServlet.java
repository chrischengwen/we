package com.sxxy.servlet.house;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.HouseInfo;
import com.sxxy.service.HouseService;
import com.sxxy.service.impl.HouseServiceImpl;

public class HouseQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseQueryServlet() {
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

		doPost(request,response);
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

		try {
			
			
			request.setCharacterEncoding("utf-8");
			
			//获取查询条件
			
			String houseInput = request.getParameter("houseInput");
			String queryType = request.getParameter("queryType");
			String  UserId  =  request.getParameter("userId");
			//用户管理的业务逻辑
			HouseService service = new HouseServiceImpl();
			
			if (UserId != null) {
				
				int  userId  =  Integer.parseInt(request.getParameter("userId"));
				//根据条件查询用户信息
				List<HouseInfo> list = service.getAllHouse(houseInput,queryType,userId  );
				
				//返回到页面
				request.setAttribute("houselist", list);
				
			}else{
			
				List<HouseInfo> list = service.getAllHouse(houseInput,queryType,0  );
				
				//返回到页面
				request.setAttribute("houselist", list);
			}
			//转发
			request.getRequestDispatcher("/view/house/house_list.jsp").forward(request, response);
		
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
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
