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

public class HouseUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public HouseUpdateServlet() {
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
		
		//房屋
		String houseId = request.getParameter("houseId");
		
		//用户管理的业务逻辑
		HouseService houseservice = new HouseServiceImpl();
		//根据编号查询房屋信息
		 try{
				//获取房屋编号
			       int HouseId = Integer.parseInt(houseId); 
				    HouseInfo houseInfo=houseservice.getHouse(HouseId);
				    request.setAttribute("houseinfo",houseInfo);
				    
				    request.getRequestDispatcher("/view/house/house_update.jsp").forward(request, response);
			
		 }catch(Exception e){
				  e.printStackTrace();
			  }
		
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
		//获取值
		int houseType = Integer.parseInt(request.getParameter("houseType"));
		String houseAddress = request.getParameter("houseAddress");
		String userName=request.getParameter("userName");
		String housePrice = request.getParameter("housePrice");
		String houseAmbient = request.getParameter("houseAmbient");
		int houseId= Integer.parseInt(request.getParameter("houseId"));
		System.out.println(houseId);
		
		HouseInfo house= new HouseInfo();
	
		house.setHouseAddress(houseAddress);
		house.setHouseAmbient(houseAmbient);
		house.setHouseId(houseId);
		house.setTypeId(houseType);
		house.setUserId(Integer.parseInt(userName));
		 try{
			   house.setHousePrice(Double.parseDouble(housePrice));

				house.setHouseAmbient(houseAmbient);
				
				HouseService service = new HouseServiceImpl();
				boolean mark = service.update(house);
				if(mark ){
					request.setAttribute("info", "房屋修改成功");
				}else{
					request.setAttribute("info", "房屋修改失败");
				}
				System.out.println("------------");
				
				//转发
				request.getRequestDispatcher("/view/house/house_save.jsp").forward(request, response);
				
		  }catch(Exception e){
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
