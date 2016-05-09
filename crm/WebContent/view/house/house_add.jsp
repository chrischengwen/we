<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@page import="com.sxxy.po.HouseInfo"%>
<%@page import="org.w3c.dom.TypeInfo"%>
<%@page import="com.sxxy.po.HouseTypeInfo"%>
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

		<title>My JSP 'customerCondition_add.jsp' starting page</title>

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

	</head>

	<body>
		<form action="<%=basePath%>servlet/HouseAddServlet" method="post" name="form2" onsubmit="return checkForm('form2');">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入房屋的详细信息
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋类型：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="houseType"   style="width: 145px">
							<%
								List<HouseTypeInfo> houseTypeList = (List<HouseTypeInfo>) request
										.getAttribute("houseList");
							%>
							<%
								for (int i = 0; i < houseTypeList.size(); i++) {
									HouseTypeInfo houseTypeInfo = houseTypeList.get(i);
							%>
							<option value="<%=houseTypeInfo.getHouseTypeId()%>"><%=houseTypeInfo.getHouseTypeName()%></option>
							<%
								}
							%>
						</select>
						&nbsp;
					</td>
					<td width="19%" bgcolor="#FFFDF0">
						<div align="center">
							房屋地址：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" check_str="房屋地址"   maxlength="50"   style="width: 145px" name="houseAddress">
						&nbsp;</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋管理者：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="userName" style="width: 145px">
							<%
								List<UserInfo> userList = (List<UserInfo>) request
										.getAttribute("userList");
							%>
							<%
								for (int i = 0; i < userList.size(); i++) {
									UserInfo userInfo = userList.get(i);
							%>
							<option value="<%=userInfo.getUserId()%>"><%=userInfo.getUserName()%></option>
							<%
								}
							%>
						</select>
						&nbsp;
					</td>
					<td width="19%" bgcolor="#FFFDF0">
						<div align="center">
							房屋价格(每平米)：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" check_str="房屋价格"  style="width: 145px"  check_type="integer"
						 name="housePrice">
						&nbsp;</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							房屋环境：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<textarea rows="10" name="houseAmbient" style="width:100%; resize:none; " ></textarea>
					</td>
				</tr>
			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
				  		<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="添加"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>

		</form>
	</body>
</html>
