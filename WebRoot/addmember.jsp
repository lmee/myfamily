<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page language="java" import="com.jieer.myfamily.utils.TokenProcessor" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% response.setHeader("Cache-Control","no-store");%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addmember.jsp' starting page</title>
    
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
  <%
  	String token = TokenProcessor.getInstance().generateToken();
  	request.getSession().setAttribute("token", token);
   %>
        <div align="center">
        	<h2>Add Member</h2><label id="tips"></label><br>
    	<form name="addmember" action="AddServlet" method="post">
    	<label>Appellation:</label><input name="Appellation" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<label>Name:</label><input name="Name" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<label>Age:</label><input name="Age" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<label>Favorite:</label><input name="Favorite" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<label>Job:</label><input name="Job" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<input type="hidden" name="token" value=<%=request.getSession().getAttribute("token")%>>
    	<input type="submit" value="Add" onclick=""><input type="button" value="Reset">
    </form>
    </div>
  </body>
</html>
