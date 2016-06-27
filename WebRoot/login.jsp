<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
<form  method=post action="loginServlet">
<center>
<br><br><br><br><br><br>
<table border=1>
<center>
<tr>
<td>username:</td>
<td><input type=text name="username"></td>
</tr>
<tr>
<td>psd:</td>
<td><input type=text name="pass"></td>
</tr>
<tr>
<td colspan=2><center><input type=submit value=login></center></td>
</tr>
</table>
</center>
</form>
</body>
</html>
