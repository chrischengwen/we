package com.sxxy.servlet.work;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerCareInfo;
import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.po.NoticeInfo;
import com.sxxy.service.CustomerCareService;
import com.sxxy.service.LinkRecordService;
import com.sxxy.service.WorkService;
import com.sxxy.service.impl.CustomerCareServiceImpl;
import com.sxxy.service.impl.LinkRecordServiceImpl;
import com.sxxy.service.impl.WorkServiceImpl;

public class WorkQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public WorkQueryServlet() {
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

			//得到7天内的联系信息
			WorkService service1 = new WorkServiceImpl();
			 List<LinkRecordInfo>   linkrecorsList = service1.getLinkMan(0);
			 request.setAttribute("linkrecorsList", linkrecorsList);
		
			 //得到7天内的关怀信息
			WorkService service2 = new WorkServiceImpl();
			List<CustomerCareInfo> careList = service2.getCustomerCare(0);
			request.setAttribute("careList", careList);
			
			 //得到当天内过生日的人
			WorkService service3 = new WorkServiceImpl();
			List<CustomerInfo> customerList = service3.getAllList(0);
			request.setAttribute("customerList", customerList);
			
			 //得到有效公告
			WorkService service4 = new WorkServiceImpl();
			List<NoticeInfo> noticeList = service4.getNotice();
			request.setAttribute("noticeList", noticeList);
			 
			 request.getRequestDispatcher("/view/frame/center.jsp").forward(request, response);
			 
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
				String  addTime=request.getParameter("addTime");
				
				String  addTime1=request.getParameter("addTime1");
				
				String  addTime2=request.getParameter("addTime2");
				
				try {
					
					WorkService service = new WorkServiceImpl();
					List<CustomerCareInfo> careList = service.getCustomerCare(Integer.parseInt(addTime));
					List<LinkRecordInfo> linkrecorsList = service.getLinkMan(Integer.parseInt(addTime1));
					List<CustomerInfo> customerList = service.getAllList(Integer.parseInt(addTime2));
					List<NoticeInfo> noticeList = service.getNotice();
					
					request.setAttribute("careList", careList);
					request.setAttribute("linkrecorsList", linkrecorsList);
					request.setAttribute("customerList", customerList);
					request.setAttribute("noticeList", noticeList);
					
					 request.getRequestDispatcher("/view/frame/center.jsp").forward(request, response);
					
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
