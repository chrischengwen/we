package com.sxxy.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

public class CustomerUpdateAllNoAdmeasureServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerUpdateAllNoAdmeasureServlet() {
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
				
				String[] str  = request.getParameterValues("checkbox");			
				
				if (str==null||str.length<=0) {
						
					request.setAttribute("info", "请选择要分配的客户！");
					request.getRequestDispatcher("/view/customer/customer_admeasure_save.jsp").forward(request, response);
					
				}else{
				
				CustomerService service = new CustomerServiceImpl();
				List<CustomerInfo> list =new ArrayList<CustomerInfo>();
				
				try {
					
					
					for (int i = 0; i < str.length; i++) {
						
						CustomerInfo customerInfo = service.getAdmeasure(Integer.parseInt(str[i]));
						list.add(customerInfo);			
					}
					request.setAttribute("customerInfo", list);
					
					//获取客户所属员工名
					UserService  userService = new UserServiceImpl();
					List<UserInfo>  userInfo  = userService.getList(null, null);
					request.setAttribute("userInfo", userInfo);

					request.getRequestDispatcher("/view/customer/customer_allAdmeasure_update.jsp").forward(
							request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
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
