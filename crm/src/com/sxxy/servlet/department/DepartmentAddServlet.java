package com.sxxy.servlet.department;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.DepartmentInfo;
import com.sxxy.service.DepartmentService;
import com.sxxy.service.impl.DepartmentServiceImpl;

public class DepartmentAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public DepartmentAddServlet() {
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
		doPost(request, response);
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
		
		//获取页面文本框的值
		String departmentName = request.getParameter("departmentName");
		String departmentDesc = request.getParameter("departmentDesc");
		
		System.out.println("DeAddServlet:"+departmentName);
		System.out.println("DeAddServlet:"+departmentDesc);
		
		//业务逻辑处理
		DepartmentService service = new DepartmentServiceImpl();
		
		//创建部门对象
		DepartmentInfo de = new DepartmentInfo();
		de.setDepartmentName(departmentName);
		de.setDepartmentDesc(departmentDesc);
		
		boolean mark = service.add(de);
		if(mark){
			request.setAttribute("info", "部门添加成功");
		}else{
			request.setAttribute("info", "部门添加失败");
		}
		//转发
		request.getRequestDispatcher("/view/department/department_save.jsp").forward(request, response);

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
