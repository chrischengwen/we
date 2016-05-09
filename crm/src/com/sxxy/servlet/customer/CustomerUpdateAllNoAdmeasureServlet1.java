package com.sxxy.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.impl.CustomerServiceImpl;

public class CustomerUpdateAllNoAdmeasureServlet1 extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerUpdateAllNoAdmeasureServlet1() {
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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

		request.setCharacterEncoding( "utf-8");
		String customerForUser= request.getParameter("customerForUser");
		String[] str  = request.getParameterValues("customerId");		
	
		
		CustomerService service = new CustomerServiceImpl();
		CustomerInfo  customerInfo  = new  CustomerInfo ();
		boolean mark = false;
		
		try {
			
			
			for (int i = 0; i < str.length; i++) {
				
				customerInfo.setUserId(Integer.parseInt(customerForUser));
				customerInfo.setCustomerId(Integer.parseInt(str[i]));
				 
				mark  =  service  .admeasure(customerInfo);			
						
			}
					 
			if (mark) {
					request.setAttribute("info", "客户分配成功");
				}else{
					request.setAttribute("info", "客户分配失败");
				}

				request.getRequestDispatcher("/view/customer/customer_admeasure_save.jsp").forward(request, response);
			
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
