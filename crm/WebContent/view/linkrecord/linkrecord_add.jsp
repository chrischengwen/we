<%@ page language="java" import="java.util.*,com.sxxy.po.*"
	pageEncoding="utf-8"%>
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
		<title>增加客户联系记录</title>
		<title>My JSP 'linkrecord_add.jsp' starting page</title>

		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
		<meta http-equiv="description" content="This is my page">
		<LINK href="<%=basePath%>resource/css/admin.css" type=text/css
			rel=stylesheet>
			
	<script type="text/javascript" src="<%=basePath%>resource/js/CheckForm.js"></script>
	<script type="text/javascript" src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
	</head>

	<body>
		<form action="servlet/LinkRecordAddServlet" method="post"  name="form1" onsubmit="return checkForm('form1');">
			<table class=editTable cellSpacing=1 cellPadding=0 width="100%"
				align=center border=0>
				<tr class=editHeaderTr>
					<td class=editHeaderTd colSpan=7>
						请输入客户联系记录
					</td>
				</tr>
				<tr>
					<td width="11%" bgcolor="#FFFDF0">
						<div align="center">
							客户名称：
						</div>
				  </td>
					<td colspan="3" bgcolor="#FFFFFF">
						<select name="customerId"  style=" width: 145px">
							<%
								List<CustomerInfo> list = (List<CustomerInfo>) request
										.getAttribute("List");
								if (list != null && list.size() > 0) {
									for (CustomerInfo customer : list) {
							%>
							<option value="<%=customer.getCustomerId()%>"><%=customer.getCustomerName()%></option>
							<%
								}
								}
							%>
						</select>
						&nbsp;
					</td>
					<td width="12%" bgcolor="#FFFDF0">
						<div align="center">
							联系类型:
						</div>
				  </td>
					<td width="32%" colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px"  maxlength="20"  name="linkType">
						<input type="hidden"    value="<%=new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date())%>"  name="linkTime" >
				  </td>
				</tr>


				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							下次联系时间：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" name="linkNexttime" check_str="下次联系时间"   readonly="readonly" id="linkNexttime"  onclick="WdatePicker({el:linkNexttime,dateFmt:'yyyy-MM-dd HH:mm:ss '})">
						&nbsp;</td>
					<td bgcolor="#FFFDF0">
						<div align="center">
							是谁联系的：
						</div>
					</td>
					<td colspan="3" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" maxlength="20"  name="whoLink">
					</td>
				</tr>

				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							联系主题：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<input type="text" style="width: 145px" maxlength="20"  name="linkTheme"  check_str="联系主题" >
					</td>
				</tr>
				<tr>
					<td bgcolor="#FFFDF0">
						<div align="center">
							联系备注：
						</div>
					</td>
					<td colspan="5" bgcolor="#FFFFFF">
						<textarea rows="10" name="linkRemark"   style="width:100%; resize:none; " ></textarea>
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
