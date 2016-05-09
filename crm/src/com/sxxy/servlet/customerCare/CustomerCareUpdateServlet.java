package com.sxxy.servlet.customerCare;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerCareService;
import com.sxxy.service.CustomerService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerCareServiceImpl;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class CustomerCareUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerCareUpdateServlet() {
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

		CustomerService service  = new CustomerServiceImpl();
		
		List<CustomerInfo> list = service.query(null, null ,0);
		request.setAttribute("careList", list);
		
		//关怀
		int Id =Integer.parseInt(request.getParameter("id"));
		CustomerCareService care=new CustomerCareServiceImpl();
		CustomerCareInfo careInfo=care.getCare(Id);
		
		//存放到request
		request.setAttribute("careInfo", careInfo);
		
		request.getRequestDispatcher("/view/customerCare/customerCare_update.jsp").forward(request, response);

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


		// 设置编码:只能用于post提交
		request.setCharacterEncoding("utf-8");
		// 获取页面文本框的值
		int careId= Integer.parseInt(request.getParameter("careId"));
		String careTheme=request.getParameter("careTheme");
		//String careTime=request.getParameter("careTime");
		String careNexttime=request.getParameter("careNexttime");
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		String carePeople=request.getParameter("carePeople");
		String careWay=request.getParameter("careWay");
		String careRemark=request.getParameter("careRemark");
		System.out.println("careId");
		CustomerCareInfo careInfo=new CustomerCareInfo();
		careInfo.setCareId(careId);
		careInfo.setCareTheme(careTheme);
		//careInfo.setCareTime(careTime);
		careInfo.setCareNexttime(careNexttime);
		careInfo.setCarePeople(carePeople);
		careInfo.setCareRemark(careRemark);
		careInfo.setCareWay(careWay);
		careInfo.setCustomerId(customerId);
	
		CustomerCareService dao = new CustomerCareServiceImpl();
		boolean mark=dao.update(careInfo);
		if (mark){		
			request.setAttribute("info", "修改成功");
		}else{
			request.setAttribute("info", "修改失败");
		}
		request.getRequestDispatcher("/view/customerCare/customerCare_save.jsp").forward(request, response);
		
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
