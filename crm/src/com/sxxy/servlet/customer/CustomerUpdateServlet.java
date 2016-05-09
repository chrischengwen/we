package com.sxxy.servlet.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerConditionInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.CustomerSourceInfo;
import com.sxxy.po.CustomerTypeInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.CustomerConditionService;
import com.sxxy.service.CustomerService;
import com.sxxy.service.CustomerSourceService;
import com.sxxy.service.CustomerTypeService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.CustomerConditionServiceImpl;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.CustomerSourceServiceImpl;
import com.sxxy.service.impl.CustomerTypeServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class CustomerUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public CustomerUpdateServlet() {
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
		CustomerInfo customerInfo = service.getAllList(customerId);
		request.setAttribute("customerInfo", customerInfo);
		
		 //获取客户状态名
		CustomerConditionService  conditionService = new CustomerConditionServiceImpl();
		List<CustomerConditionInfo> conditionInfo = conditionService.query(null);
		request.setAttribute("conditionInfo", conditionInfo);
		
		//获取客户来源名
		CustomerSourceService  sourceService = new CustomerSourceServiceImpl();
		List<CustomerSourceInfo>  sourceInfo  = sourceService.query(null);
		request.setAttribute("sourceInfo", sourceInfo);
		
		//获取客户来源名
		CustomerTypeService  typeService = new CustomerTypeServiceImpl();
		List<CustomerTypeInfo>  typeInfo  = typeService.query(null);
		request.setAttribute("typeInfo", typeInfo);
		
		//获取客户所属员工名
		UserService  userService = new UserServiceImpl();
		List<UserInfo>  userInfo  = userService.getList(null, null);
		request.setAttribute("userInfo", userInfo);

		request.getRequestDispatcher("/view/customer/customer_update.jsp").forward(
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
		
		String customerId = request.getParameter("customerId");
		String customerForUser = request.getParameter("customerForUser");
		String customerName = request.getParameter("customerName");
		String customerSex = request.getParameter("customerSex");
		String customerSource = request.getParameter("customerSource");
		String customerCondition = request.getParameter("customerCondition");
		String customerType = request.getParameter("customerType");
		//String customerBirthday = request.getParameter("customerBirthday");
		String customerMobile = request.getParameter("customerMobile");
		String customerQq = request.getParameter("customerQq");
		String customerAddress = request.getParameter("customerAddress");
		String customerEmail = request.getParameter("customerEmail");
		String customerJob = request.getParameter("customerJob");
		String customerBlog = request.getParameter("customerBlog");
		String customerTel = request.getParameter("customerTel");
		String customerMsn = request.getParameter("customerMsn");
		String customerCompany = request.getParameter("customerCompany");
		String customerAddTime = request.getParameter("customerAddTime");
		String customerAddMan = request.getParameter("customerAddMan");
		String customerChangeTime = request.getParameter("customerChangeTime");
		String customerChangeMan = request.getParameter("customerChangeMan");
		String customerRemark = request.getParameter("customerRemark");
		
		CustomerInfo customerInfo = new CustomerInfo();
		try {
			customerInfo.setCustomerId(Integer.parseInt(customerId));	
			customerInfo.setUserId(Integer.parseInt(customerForUser));	
			customerInfo.setSourceId(Integer.parseInt(customerSource));
			customerInfo.setConditionId(Integer.parseInt(customerCondition));
			customerInfo.setTypeId(Integer.parseInt(customerType));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		customerInfo.setCustomerName(customerName);
		customerInfo.setCustomerSex(customerSex);
		customerInfo.setCustomerMobile(customerMobile);
		customerInfo.setCustomerQq(customerQq);
		customerInfo.setCustomerAddress(customerAddress);
		customerInfo.setCustomerEmail(customerEmail);
		customerInfo.setCustomerRemark(customerRemark);
		customerInfo.setCustomerJob(customerJob);
		customerInfo.setCustomerBlog(customerBlog);
		customerInfo.setCustomerTel(customerTel);
		customerInfo.setCustomerMsn(customerMsn);
		customerInfo.setCustomerChangeTime(customerChangeTime);
		customerInfo.setCustomerChangeMan(customerChangeMan);
		customerInfo.setCustomerAddTime(customerAddTime);
		customerInfo.setCustomerAddMan(customerAddMan);
		customerInfo.setCustomerCompany(customerCompany);
		//customerInfo.setCustomerBirthday(customerBirthday);

		CustomerService service = new CustomerServiceImpl();
		boolean mark = service.update(customerInfo);
		if (mark) {
			request.setAttribute("info", "客户修改成功");
		}else{
			request.setAttribute("info", "客户修改失败");
		}

		request.getRequestDispatcher("/view/customer/customer_save.jsp").forward(request, response);
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
