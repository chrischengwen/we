<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>

<%@page import="com.sxxy.po.DepartmentInfo"%>
<%@page import="com.sxxy.po.RoleInfo"%>
<%@page import="com.sxxy.po.UserInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

		<title>修改员工信息</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
			<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
			<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>

	</head>

	<body>
		<form action="<%=basePath%>servlet/UserUpdateServlet" method="post" name="form2" onsubmit="return validator(this)" 
>
			<%
				UserInfo userinfo = (UserInfo) request.getAttribute("userinfo");
			%>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请修改用户的详细信息
						<input type="hidden" name="userId" value="${userinfo.userId }"
							readonly="readonly">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							姓名：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" name="userName" disabled="disabled" value="${userinfo.userName }"
							readonly="readonly">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							年龄：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userAge" maxlength="2"  valid="required|isNumber"  errmsg="员工年龄不能为空!|请输入正确的年龄!" value="${userinfo.userAge }">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0" style="height: 21px">
						<div align="center">
							性别：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF" style="height: 21px">
						<input type="radio" name="userSex"
							<% if(userinfo.getUserSex().equals("男")){ %> checked="checked"
							<%} %> value="男" />
						男
						<input type="radio" name="userSex"
							<% if(userinfo.getUserSex().equals("女")){ %> checked="checked"
							<%} %> value="女" />
						女
						<br />
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							民族：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userNation"
							value="${userinfo.userNation }">
						&nbsp;
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							学历：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="userDiploma" style="width: 145px">
							<option <% if(userinfo.getUserDiploma().equals("初中")){ %>
								selected="selected" <%} %>>
								初中
							</option>
							<%
								if (userinfo.getUserDiploma().equals("高中")) {
							%>selected="selected"<%
								}
							%>>
							<option>
								高中
							</option>
							<option <% if(userinfo.getUserDiploma().equals("本科")){ %>
								selected="selected" <%} %>>
								本科
							</option>
							<option <% if(userinfo.getUserDiploma().equals("博士")){ %>
								selected="selected" <%} %>>
								博士
							</option>
							<option <% if(userinfo.getUserDiploma().equals("硕士")){ %>
								selected="selected" <%} %>>
								硕士
							</option>
						</select>
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							婚姻：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="isMarried" style="width: 145px">
							<option <% if(userinfo.getIsMarried().equals("已婚")){ %>
								selected="selected" <%} %>>
								已婚
							</option>
							<option <% if(userinfo.getIsMarried().equals("未婚")){ %>
								selected="selected" <%} %>>
								未婚
							</option>
							<option <% if(userinfo.getIsMarried().equals("离异")){ %>
								selected="selected" <%} %>>
								离异
							</option>
						</select>
						&nbsp;
					</td>
				</tr>


				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							部门：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="departmentId" style="width: 145px">
							<%
								List<DepartmentInfo> list = (List<DepartmentInfo>) request
										.getAttribute("deList");

								UserInfo userinfoInfo = (UserInfo) request.getAttribute("userinfo");
								if (list != null && list.size() > 0 && userinfoInfo != null) {
									for (DepartmentInfo de : list) {
							%>
							<option value="<%=de.getDepartmentId()%>"
								<% if(userinfoInfo.getDepartmentId() == de.getDepartmentId()){ %>
								selected="selected" <%} %>><%=de.getDepartmentName()%></option>
							<%
								}
								}
							%>
						</select>
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							角色：
						</div>
					</td>

					<td colspan="3" bgcolor="#FFFFFF">
						<select name="roleId"  disabled="disabled" style="width: 145px">

							<%
								List<RoleInfo> list1 = (List<RoleInfo>) request
										.getAttribute("roleList");

								UserInfo user1 = (UserInfo) request.getAttribute("userinfo");
								if (list != null && list.size() > 0 && userinfoInfo != null) {
									for (RoleInfo de : list1) {
							%>
							<option value="<%=de.getRoleId()%>"
								<% if(userinfoInfo.getRoleId() == de.getRoleId()){ %>
								selected="selected" <%} %>><%=de.getRoleName()%></option>
							<%
								}
								}
							%>
						</select>
					</td>

	
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							座机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"     valid="isPhone"   errmsg="请输入正确的座机号码!" name="userTel" value="${userinfo.userTel }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							爱好：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="50"  name="userIntest"
							value="${userinfo.userIntest }">
						&nbsp;
					</td>
				</tr>
			
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							工资卡号：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  valid="isNumber"   errmsg="请输入正确的工资卡号!"  maxlength="20"   name="userBankcard"
							value="${userinfo.userBankcard }">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							手机：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" valid="regexp"  regexp="^1[3|4|5|8][0-9]\d{8}$"   errmsg="请输入正确的手机号码!" name="userMobile"
							value="${userinfo.userMobile }">
						&nbsp;
					</td>

				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							身份证：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  valid="isIdCard"   errmsg="请输入正确的身份证号码!" name="userIdnum" value="${userinfo.userIdnum}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px" name="userAddtime"
							disabled="disabled" value="${userinfo.userAddtime}">
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							添加人：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="10" name="userAddman"
							disabled="disabled" value="${userinfo.userAddman}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							修改人：
						</div>
						<input type="hidden"   value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>" name="userChangeTime">
					
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" name="userChangeman"
							style="width: 145px"    maxlength="20"value="${userinfo.userChangeman}">
						&nbsp;
					</td>
				</tr>

				<tr>

					<td bgcolor="#FFFDF0">
						<div align="center">
							E_mail：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50" name="userEmail" value="${userinfo.userEmail}">
						&nbsp;
					</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="50"  name="userAddress"
							value="${userinfo.userAddress}">
						&nbsp;
					</td>
				</tr>

			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="36%"></td>
					<td width="17%"><input type="submit" name="submit"  value="提交"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>

	</body>
</html>
