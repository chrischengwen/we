package com.sxxy.servlet.email;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.EmailInfo;
import com.sxxy.service.EmailService;
import com.sxxy.service.impl.EmailServiceImpl;

public class EmailQueryNoSendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public EmailQueryNoSendServlet() {
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

		EmailService service = new  EmailServiceImpl();
		
		 List<EmailInfo>  emailList = service.getNoSendAllEmail(null, null);
		 
		 request.setAttribute("emailList", emailList);
		 
		 request.getRequestDispatcher("/view/email/email_draftbox.jsp").forward(request, response);
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
		
		//获取查询条件
		String emailInput = request.getParameter("emailInput");
		String queryType = request.getParameter("queryType");
	
		//用户管理的业务逻辑
		EmailService service = new EmailServiceImpl();
		
		//根据条件查询用户信息
		List<EmailInfo> list = service.getNoSendAllEmail(emailInput, queryType);
		
		//返回到页面
		request.setAttribute("emailList", list);
		
		//转发
		request.getRequestDispatcher("/view/email/email_draftbox.jsp").forward(request, response);
		
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
