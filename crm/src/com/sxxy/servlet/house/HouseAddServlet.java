package com.sxxy.servlet.house;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.dao.impl.HouseTypeServiceImpl;
import com.sxxy.po.HouseInfo;
import com.sxxy.po.HouseTypeInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.HouseService;
import com.sxxy.service.HouseTypeService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.HouseServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class HouseAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseAddServlet() {
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
    
		//查询房屋类型
		HouseTypeService	typeService =new HouseTypeServiceImpl();
		List<HouseTypeInfo>  houseList =	 typeService.query(null);
		request.setAttribute("houseList", houseList);
		//查询房屋管理者
		
		UserService userService = new UserServiceImpl();
		List<UserInfo> userList = userService.getList(null,null);
		request.setAttribute("userList", userList);
		
		request.getRequestDispatcher("/view/house/house_add.jsp").forward(request, response);
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
		
		String houseType = request.getParameter("houseType");
		String userName = request.getParameter("userName");
		String houseAddress = request.getParameter("houseAddress");
		String housePrice = request.getParameter("housePrice");
		String houseAmbient = request.getParameter("houseAmbient");
		
		
		HouseInfo houseInfo= new HouseInfo();
		
		 try{
			 houseInfo.setUserId(Integer.parseInt(userName));
			 houseInfo.setHousePrice(Double.parseDouble(housePrice));
			 houseInfo.setTypeId(Integer.parseInt(houseType));
		  }catch(Exception e){
			  e.printStackTrace();
		  }
		  houseInfo.setHouseAddress(houseAddress);
		  houseInfo.setHouseAmbient(houseAmbient);
	
		HouseService service = new HouseServiceImpl();
		boolean mark = service.add(houseInfo);
		if(mark ){
			request.setAttribute("info", "房屋添加成功");
		}else{
			request.setAttribute("info", "房屋添加失败");
		}
		
		//转发
		request.getRequestDispatcher("/view/house/house_save.jsp").forward(request, response);
		
	
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
