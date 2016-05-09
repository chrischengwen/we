<%@ page language="java" import="java.util.*,com.sxxy.po.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>发送飞信</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<LINK href="<%=basePath%>resource/css/admin.css" type=text/css rel=stylesheet>
	<script type="text/javascript"
			src="<%=basePath%>resource/js/CheckForm.js"></script>
		<script type="text/javascript"
			src="<%=basePath%>resource/js/My97DatePicker/WdatePicker.js"></script>
<script language="JavaScript" type="text/javascript" src="<%=basePath%>resource/js/FormValid.js"></script>
  </head>
  
  <body  onload=startclock()>
<form action="<%=basePath%>servlet/FetionSendServlet"   name="form3" onsubmit="return checkForm('form3');"  method="post"  >

<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
<tr class=editHeaderTr>
<td class=editHeaderTd colSpan=7>  飞信发送
</td>
</tr>  
	 
	 
	 <tr>
		<td bgcolor="#FFFDF0"><div align="center">收信人手机号码：</div></td>
		<td colspan="3" bgcolor="#FFFFFF"><input type="text"  check_str="收信人手机号码"  style="width:578px;"  name="Mobile"  /></td>
	</tr>

  	<tr>
  		  	<td bgcolor="#FFFDF0"><div align="center">发送内容：</div></td>
    		<td colspan="3" bgcolor="#FFFFFF"><textarea   check_str="发送内容"    rows="20" name="FetionContent" style="width:578px; resize:none; height:300px;"></textarea></td>
    </tr>
</table>
<table class=editTable cellSpacing=1 cellPadding=0 width="100%" align=center border=0>
  <tr bgcolor="#ECF3FD">
    <td width="20%">&nbsp;</td>
    <td width="12%"><input type="submit" name="Submit" value="发送"  ></td>
    <td width="40%"><input type="reset" name="reset" value="重写"></td>
  </tr>
</table>

</form>
</body>
</html>
