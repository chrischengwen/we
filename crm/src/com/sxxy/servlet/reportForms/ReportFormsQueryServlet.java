package com.sxxy.servlet.reportForms;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.CustomerInfo;
import com.sxxy.po.LinkRecordInfo;
import com.sxxy.service.ReportFormsService;
import com.sxxy.service.WorkService;
import com.sxxy.service.impl.ReportFormsServiceImpl;
import com.sxxy.service.impl.WorkServiceImpl;

public class ReportFormsQueryServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ReportFormsQueryServlet() {
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

		//得到客户状态的统计情况
		ReportFormsService service1 = new ReportFormsServiceImpl();
		 List<CustomerInfo>   conditionList = service1.countCondition();
		 request.setAttribute("conditionList", conditionList);
		 
		//得到客户分配的统计情况
		ReportFormsService service2 = new ReportFormsServiceImpl();
		 List<CustomerInfo>   countList = service2.count();
		 request.setAttribute("countList", countList);
			 
		//得到客户来源的统计情况
		ReportFormsService service3 = new ReportFormsServiceImpl();
		 List<CustomerInfo>   sourceList = service3.countSource();
		 request.setAttribute("sourceList", sourceList);
		 
		//得到客户类型的统计情况
		ReportFormsService service4 = new ReportFormsServiceImpl();
		 List<CustomerInfo>   typeList = service4.countType();
		 request.setAttribute("typeList", typeList);
		 
		 request.getRequestDispatcher("/view/frame/reportForms.jsp").forward(request, response);
 
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

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out
				.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the POST method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
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
