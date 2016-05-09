package com.sxxy.servlet.customerCare;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.service.CustomerCareService;
import com.sxxy.service.CustomerService;
import com.sxxy.service.impl.CustomerCareServiceImpl;
import com.sxxy.service.impl.CustomerServiceImpl;

public class CustomerCareAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerCareAddServlet() {
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
		request.getRequestDispatcher("/view/customerCare/customerCare_add.jsp").forward(request, response);

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
		String careTheme=request.getParameter("careTheme");
		String careTime=request.getParameter("careTime");
		String careNexttime=request.getParameter("careNexttime");
		int customerId=Integer.parseInt(request.getParameter("customerId"));
		String carePeople=request.getParameter("carePeople");
		String careWay=request.getParameter("careWay");
		String careRemark=request.getParameter("careRemark");
		
		CustomerCareInfo careInfo=new CustomerCareInfo();
		careInfo.setCareTheme(careTheme);
		careInfo.setCareTime(careTime);
		careInfo.setCareNexttime(careNexttime);
		careInfo.setCarePeople(carePeople);
		careInfo.setCareRemark(careRemark);
		careInfo.setCareWay(careWay);
		careInfo.setCustomerId(customerId);
		
		CustomerCareService dao = new CustomerCareServiceImpl();
		boolean mark=dao.add(careInfo);
		if (mark){		
			request.setAttribute("info", "添加成功");
		}else{
			request.setAttribute("info", "添加失败");
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
