<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
		<form action="<%=basePath%>servlet/NoticeAddServlet" method="post"
			name="form1" onsubmit="return checkForm('form1');">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入公告内容
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							公告员工：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF"><select name="customerForUser" style=" width: 145px">
						<%List <UserInfo> userList =(List <UserInfo>) request.getAttribute("userInfo"); %>
							<%for ( int i=0;i<userList.size();i++){
											UserInfo userInfo =userList.get(i);
							%>		
									<option  value="<%=userInfo.getUserId() %>"><%=userInfo.getUserName() %></option>
						<% }%>
			</select>		</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							截止时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  name="noticeEndTime" check_str="截止时间"
							readonly="readonly" id="noticeEndTime"
							onclick="WdatePicker({el:noticeEndTime,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							公告主题:
						</div>

						<input type="hidden"
							value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
							.format(new Date())%>"
							name="noticeTime">
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<input type="text"  style="width: 145px"  maxlength="20"  name="noticeItem" check_str="公告主题">
					</td>
					
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							公告内容：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<textarea rows="10" name="noticeContent"
							style="width: 100%; resize: none;" check_str="公告内容"></textarea>
					</td>
				</tr>


			</table>
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr bgcolor="#ECF3FD">
					<td width="25%"></td>
					<td width="17%"><input type="submit" name="submit"  value="发布"></td>
					<td width="17%"><input type="reset" name="reset"  value="重置"></td>
					<td width="4%"><input type="button" name="button"  onClick="history.back() "  value="返回"></td>
					<td width="43%"></td>
				</tr>
			</table>
		</form>
	</body>
</html>
