package com.sxxy.servlet.linkman;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkManInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.LinkManService;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.LinkManServiceImpl;

public class LInkManUpdateServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LInkManUpdateServlet() {
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

	 	int   linkManId =	Integer.parseInt(request.getParameter("linkManId"));
	 	
	 	LinkManService   linkManService = new LinkManServiceImpl();
	 	
	 	LinkManInfo linkmanList  = linkManService.getList(linkManId);
	 	
	 	request.setAttribute("linkmanList", linkmanList);
	 	
	 	CustomerService  customerService = new CustomerServiceImpl();
		
		List<CustomerInfo> customerList = customerService.query(null,null,0);
		
		request.setAttribute("customerList", customerList);
		
		request.getRequestDispatcher("/view/linkman/linkman_update.jsp").forward(request, response);
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

		request.setCharacterEncoding("utf-8");// 处理乱码

		// 获取值
		String userName = request.getParameter("userName");
		String linkManName = request.getParameter("linkManName");
		String LinkManSex = request.getParameter("LinkManSex");
		String linkManAge = request.getParameter("linkManAge");
		String linkManJob = request.getParameter("linkManJob");
		String linkManMobile = request.getParameter("linkManMobile");
		String linkManRelation = request.getParameter("linkManRelation");
		String linkManId = request.getParameter("linkManId");

		System.out.println("dddd"+linkManName);
		try {
			
			LinkManInfo linkman = new LinkManInfo();
			
			linkman.setLinkmanName(linkManName);	
			linkman.setLinkmanSex(LinkManSex);
			linkman.setLinkmanMobile(linkManMobile);
			linkman.setLinkmanJob(linkManJob);
			linkman.setLinkmanRelation(linkManRelation);
			linkman.setLinkmanAge(Integer.parseInt(linkManAge));
			linkman.setLinkmanId(Integer.parseInt(linkManId));
			linkman.setCoustomerId(Integer.parseInt(userName));
			
			// 业务逻辑
			LinkManService service = new LinkManServiceImpl();
			boolean mark = service.update(linkman);
			
			if (mark) {
				request.setAttribute("info", "联系人修改成功");
			} else {
				request.setAttribute("info", "联系人修改失败");
			}

			// 转发
			request.getRequestDispatcher("/view/linkman/linkman_save.jsp").forward(request, response);
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
