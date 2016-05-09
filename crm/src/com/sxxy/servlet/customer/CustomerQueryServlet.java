package com.sxxy.servlet.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.impl.CustomerServiceImpl;

public class CustomerQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerQueryServlet() {
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
		
		try {
			
			request.setCharacterEncoding("utf-8");
			String customerInput = request.getParameter("customerInput");
			String queryType = request.getParameter("queryType");
			String  UserId  =  request.getParameter("userId");
			if (UserId != null) {
				
				int  userId  =  Integer.parseInt(request.getParameter("userId"));
				System.out.println(userId);
				
				CustomerService service =new CustomerServiceImpl();
				
				List<CustomerInfo>  list=  service.query(customerInput,queryType ,userId) ;
				
				request.setAttribute("list", list);
			}else {
				
				CustomerService service =new CustomerServiceImpl();
				
				List<CustomerInfo>  list=  service.query(customerInput,queryType ,0) ;
				
				request.setAttribute("list", list);
				
			}
			
			
			request.getRequestDispatcher("/view/customer/customer_list.jsp").forward(request, response);
			
			
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
