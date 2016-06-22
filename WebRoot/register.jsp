<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'register.jsp' starting page</title>
    
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
    <div align="center">
    	<h2>Register</h2>
    	<form action="" name="register">
	    	<label>User:</label><input type="text"><br>
	    	<label>Pass:</label><input type="password"><br>
	    	<label>Re-pass:</label><input type="password"><br>
	    	<label>Phone:</label><input type="text"><br>
	    	<label>E-mail:</label><input type="text"><br>
	    	<input type="submit" value="Submit"><input type="button" value="Reset">
    	</form>
    </div>
  </body>
</html>
