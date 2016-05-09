package com.sxxy.servlet.linkrecord;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.service.CustomerService;
import com.sxxy.service.LinkRecordService;
import com.sxxy.service.impl.CustomerServiceImpl;
import com.sxxy.service.impl.LinkRecordServiceImpl;

public class LinkRecordAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LinkRecordAddServlet() {
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
		
		//部门的业务逻辑
		CustomerService service  = new CustomerServiceImpl();
		
		List<CustomerInfo> list = service.query(null, null,0);
		 System.out.print(list.size());
		//放到request
		request.setAttribute("List", list);
		
		request.getRequestDispatcher("/view/linkrecord/linkrecord_add.jsp").forward(request, response);
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
		
		//获取值
		//String recordId = request.getParameter("recordId");
		String linkTime = request.getParameter("linkTime");
		String linkNexttime = request.getParameter("linkNexttime");
		String whoLink = request.getParameter("whoLink");
		String linkType = request.getParameter("linkType");
		String linkTheme = request.getParameter("linkTheme");
		String linkRemark = request.getParameter("linkRemark");
		String customerId = request.getParameter("customerId");
		
		
		
		//创建联系记录对象
		LinkRecordInfo linkRecord = new LinkRecordInfo();
		linkRecord.setLinkTime(linkTime);
		linkRecord.setLinkNexttime(linkNexttime);
		linkRecord.setWhoLink(whoLink);
		linkRecord.setLinkType(linkType);
		linkRecord.setLinkTheme(linkTheme);
		linkRecord.setLinkRemark(linkRemark);
		
		try {
			//linkRecord.setRecordId(Integer.parseInt(recordId));
			linkRecord.setCustomerId(Integer.parseInt(customerId));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//业务逻辑
		LinkRecordService service = new LinkRecordServiceImpl();
		
		
		boolean mark = service.add(linkRecord);
		if(mark ){
			request.setAttribute("info", "联系记录添加成功");
		}else{
			request.setAttribute("info", "联系记录添加失败");
		}
		
		//转发
		request.getRequestDispatcher("/view/linkrecord/linkrecord_save.jsp").forward(request, response);
		
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
