package com.sxxy.servlet.fetion;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.Fetion;
import com.sxxy.service.CustomerService;
import com.sxxy.service.impl.CustomerServiceImpl;

public class FetionSendServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public FetionSendServlet() {
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
			
				
				String   Mobile  =request.getParameter("Mobile");
				String   FetionContent  =request.getParameter("FetionContent");		
				String PHONE = "13896297243";  
			    String PWD = "SHAOlin5772";  	
			    boolean  mark  =true;
			    try {
			    	Fetion.sendMsg(PHONE, PWD, Mobile, FetionContent);
			    	
				} catch (Exception e) {
					mark=false;
					e.printStackTrace();
				}
				if (mark) {
					request.setAttribute("info", "飞信发送成功");
				}else{
					request.setAttribute("info", "飞信发送失败");
				}

				request.getRequestDispatcher("/view/fetion/fetion_save.jsp").forward(
						request, response);
			   
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
