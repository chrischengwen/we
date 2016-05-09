package com.sxxy.servlet.role;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.DepartmentInfo;
import com.sxxy.po.RoleInfo;
import com.sxxy.service.RoleService;
import com.sxxy.service.impl.RoleServiceImpl;

public class RoleAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public RoleAddServlet() {
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
		String rolename = request.getParameter("roleName");
		String rolepower = request.getParameter("rolePower");
		
		System.out.println("DeAddServlet:"+rolename);
		System.out.println("DeAddServlet:"+rolepower);
		
		//业务逻辑处理
		RoleService service = new RoleServiceImpl();
		
		//创建部门对象
		RoleInfo role = new RoleInfo();
		role.setRoleName(rolename);
		role.setRolePower(rolepower);
		
		boolean mark = service.add(role);
		if(mark){
			request.setAttribute("info", "角色添加成功");
		}else{
			request.setAttribute("info", "角色添加失败");
		}
		//转发
		request.getRequestDispatcher("/view/role/role_save.jsp").forward(request, response);

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
