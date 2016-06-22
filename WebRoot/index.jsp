<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function validateInput(){
			document.getElementById("tips").innerHTML="";
			var username = document.familylogin.username.value;
			var password = document.familylogin.password.value;
			if(username == ""){
				document.getElementById("tips").innerHTML="<font color='red'>please input the username</font>";
				return false;
			}
			if(password == ""){
				document.getElementById("tips").innerHTML="<font color='red'>please input the password</font>";
				return false;
			}
		}
	</script>
  </head>
  
  <body>
    <div align="center">
        	<h2>Login</h2><label id="tips"></label><br>
    	<form name="familylogin" action="LoginServlet" method="post">
    	<label>User:</label><input name="username" type="text" onfocus="document.getElementById('tips').innerHTML=''"><br>
    	<label>Pass:</label><input name="password" type="password" onfocus="document.getElementById('tips').innerHTML=''"><br><br>
    	<input type="submit" value="Sumbit" onclick="return validateInput()"><input type="button" value="Register">
    </form>
    </div>
  </body>
</html>
