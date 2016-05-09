package com.sxxy.servlet.email;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.EmailInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.EmailService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.EmailServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class EmailUpdateSevlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmailUpdateSevlet() {
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

				
				// 获取发件人
				UserService userService = new UserServiceImpl();
				List<UserInfo> userList = userService.getList(null,null);
				request.setAttribute("userList", userList);
				// 获取收件人
				CustomerService customerService = new CustomerServiceImpl();
				List<CustomerInfo> customerList= customerService.query(null, null ,0);
				request.setAttribute("customerList", customerList);
		
		
				     String   emailId =   	request.getParameter("emailId");
					try {
					EmailService service  =new EmailServiceImpl();	
					
					EmailInfo emailInfo =service.getEmail(Integer.parseInt(emailId));
					
					request.setAttribute("emailInfo", emailInfo);
					
					service.delete(Integer.parseInt(emailId));
					
					request.getRequestDispatcher("/view/email/email_resend.jsp").forward(request, response);
						
					} catch (Exception e) {
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
		
		String addressee = request.getParameter("addressee");
		String addresser = request.getParameter("addresser");
		String emailContent = request.getParameter("emailContent");
		String emailTime = request.getParameter("emailTime");
		String emailTheme = request.getParameter("emailTheme");
		String emailId   =  request.getParameter("emailId");
		
		EmailInfo email = new EmailInfo();
		try {
			
			
			email.setCustomerId(Integer.parseInt(addressee));
			email.setEmailId(Integer.parseInt(emailId));
			email.setUserId(Integer.parseInt(addresser));
			email.setEmailContent(emailContent);
			email.setEmailState(0);
			email.setEmailTheme(emailTheme);
			email.setEmailTime(emailTime);
			
			//业务逻辑
			EmailService service = new EmailServiceImpl();
			boolean mark = service.upadate(email);
			if(mark){
				request.setAttribute("info","存放成功");
			}else{
				request.setAttribute("info", "存放失败");
			}
			
			//转发
			request.getRequestDispatcher("/view/email/email_save_no_send.jsp").forward(request, response);
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
