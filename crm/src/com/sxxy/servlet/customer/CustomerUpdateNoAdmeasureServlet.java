package com.sxxy.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class CustomerUpdateNoAdmeasureServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerUpdateNoAdmeasureServlet() {
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

		//获取客户信息
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		CustomerService service = new CustomerServiceImpl();
		CustomerInfo customerInfo = service.getAdmeasure(customerId);
		request.setAttribute("customerInfo", customerInfo);
		
		
		//获取客户所属员工名
		UserService  userService = new UserServiceImpl();
		List<UserInfo>  userInfo  = userService.getList(null, null);
		request.setAttribute("userInfo", userInfo);

		request.getRequestDispatcher("/view/customer/customer_admeasure_update.jsp").forward(
				request, response);
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
			try {
				
				int   customerId	=	 Integer.parseInt(request.getParameter("customerId"));
				int   customerForUser  =  Integer.parseInt(request.getParameter("customerForUser")) ;
				
				CustomerService  service = new  CustomerServiceImpl();
				CustomerInfo  customerInfo  = new  CustomerInfo ();
					
				customerInfo.setCustomerId(customerId);	
				customerInfo.setUserId(customerForUser);
				
				  boolean  mark  =  service  .admeasure(customerInfo);
				
				  if (mark) {
						request.setAttribute("info", "客户分配成功");
					}else{
						request.setAttribute("info", "客户分配失败");
					}

					request.getRequestDispatcher("/view/customer/customer_save.jsp").forward(request, response);
				  
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
