package com.sxxy.servlet.email;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.mail.SimpleEmail;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.EmailInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.EmailService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.EmailServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class EmailAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmailAddServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");// 处理乱码

		String addressee = request.getParameter("addressee");
		String addresser = request.getParameter("addresser");
		String emailContent = request.getParameter("emailContent");
		String emailTime = request.getParameter("emailTime");
		String emailTheme = request.getParameter("emailTheme");

		CustomerService customerService = new CustomerServiceImpl();
		UserService userService = new UserServiceImpl();
		boolean mark1 = true;

		EmailInfo emailInfo = new EmailInfo();

		// 业务逻辑
		EmailService service = new EmailServiceImpl();
		
		CustomerInfo customerInfo = customerService.getAllList(Integer
				.parseInt(addressee));
		UserInfo userInfo = userService
				.getUser(Integer.parseInt(addresser));

		emailInfo.setCustomerId(Integer.parseInt(addressee));
		emailInfo.setUserId(Integer.parseInt(addresser));
		emailInfo.setEmailContent(emailContent);
		emailInfo.setEmailState(1);
		emailInfo.setEmailTheme(emailTheme);
		emailInfo.setEmailTime(emailTime);

		try {
			// 邮件发送

			// 无附件邮件发送
			SimpleEmail email = new SimpleEmail();
			// 设置发送主机的服务器地址
			email.setHostName("smtp.163.com");
			// 设置收件人邮箱
			email.addTo(customerInfo.getCustomerEmail(), customerInfo
					.getCustomerName());
			// 发件人邮箱
			email.setFrom("shaolin5772@163.com", userInfo.getUserName());
			// 如果要求身份验证，设置用户名、密码，分别为发件人在邮件服务器上注册的用户名和密码
			email.setAuthentication("shaolin5772@163.com", "SHAOlin5772");
			email.setCharset("utf-8");
			// 设置邮件的主题
			email.setSubject(emailTheme);
			// 邮件正文消息
			email.setMsg(emailContent);
			email.send();

		} catch (Exception e) {
			mark1 = false;
			e.printStackTrace();
		}

			if (mark1 == true) {
				service.add(emailInfo);
				request.setAttribute("info", "邮件发送成功");
				request.getRequestDispatcher("/view/email/email_save.jsp").forward(
						request, response);
			} else {
				emailInfo.setEmailState(0);
				service.add(emailInfo);
				request.setAttribute("info", "邮件发送失败");
				request.getRequestDispatcher("/view/email/email_save_no_send.jsp").forward(
						request, response);
			}


	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
