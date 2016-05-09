package com.sxxy.servlet.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sxxy.po.DepartmentInfo;
import com.sxxy.po.RoleInfo;
import com.sxxy.po.UserInfo;
import com.sxxy.service.DepartmentService;
import com.sxxy.service.RoleService;
import com.sxxy.service.UserService;
import com.sxxy.service.impl.DepartmentServiceImpl;
import com.sxxy.service.impl.RoleServiceImpl;
import com.sxxy.service.impl.UserServiceImpl;

public class UserAddServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserAddServlet() {
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


		//初始化页面add.jsp
		
		//部门的业务逻辑
		DepartmentService service  = new DepartmentServiceImpl();
		
		List<DepartmentInfo> list = service.getList(null);
		
		RoleService service2 =new RoleServiceImpl();
		
		List<RoleInfo>	list2=service2.getList(null);

		
		 System.out.print(list.size());
		//放到request
		request.setAttribute("deList", list);
		request.setAttribute("roleList", list2);

		
		
		request.getRequestDispatcher("/view/user/user_add.jsp").forward(request, response);

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
		String username = request.getParameter("userName");
		String password=request.getParameter("userPw");
		int roleid=Integer.parseInt(request.getParameter("roleId"));
		int userage = Integer.parseInt(request.getParameter("userAge"));
		String usernum = request.getParameter("userNum");
		String usersex=request.getParameter("userSex");
		String usernation=request.getParameter("userNation");
		String userdiploma=request.getParameter("userDiploma");
		String ismarried=request.getParameter("isMarried");
		int departmentid=Integer.parseInt(request.getParameter("departmentId"));
		String usermobile=request.getParameter("userMobile");
		String usertel=request.getParameter("userTel");
		String userintest=request.getParameter("userIntest");
		String userbankcard=request.getParameter("userBankcard");
		String useridnum=request.getParameter("userIdnum");
		String useremail=request.getParameter("userEmail");
		String useraddress = request.getParameter("userAddress");
		String useraddtime=request.getParameter("userAddtime");
		String userchangetime=request.getParameter("userChangetime");
		String useraddman=request.getParameter("userAddman");
		//创建员工对象
		UserInfo us=new UserInfo();
		//将值传入
		
		us.setRoleId(roleid);
		us.setDepartmentId(departmentid);
		us.setUserName(username);
		us.setUserSex(usersex);
		us.setUserMobile(usermobile);
		us.setUserAge(userage);
		us.setUserAddress(useraddress);
		us.setUserNum(usernum);
		us.setUserPw(password);
		us.setUserTel(usertel);
		us.setUserIdnum(useridnum);
		us.setUserEmail(useremail);
		us.setUserAddtime(useraddtime);
		us.setUserChangetime(userchangetime);
		us.setUserIntest(userintest);
		us.setUserDiploma(userdiploma);
		us.setUserBankcard(userbankcard);
		us.setUserNation(usernation);
		us.setIsMarried(ismarried);
		us.setUserAddman(useraddman);
		
		UserService dao=new UserServiceImpl();
		boolean mark=dao.add(us);
		if (mark){		
			request.setAttribute("info", "员工添加成功");
		}else{
			request.setAttribute("info", "员工添加失败");
		}
		request.getRequestDispatcher("/view/user/user_save.jsp").forward(request, response);
		
		
		

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
