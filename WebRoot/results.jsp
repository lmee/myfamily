<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@ page language="java" import= "com.jieer.myfamily.enity.FamilyMember" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <script src="http://code.jquery.com/jquery-2.1.4.min.js">
    	function doFind(){
				$.ajax({
					cache: false,
					type: "POST",
					url:"ajax.jsp",	//把表单数据发送到ajax.jsp
					data:$('#editmember').serialize(),	//要发送的是ajaxFrm表单中的数据
					async: false,
					error: function(request) {
					alert("发送请求失败！");
					},
					success: function(data) {
						
					}
					});
				}
    </script>
    <title>My JSP 'results.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<style type="text/css">
table.gridtable {
	font-family: verdana,arial,sans-serif;
	font-size:11px;
	color:#333333;
	border-width: 1px;
	border-color: #666666;
	border-collapse: collapse;
}
table.gridtable th {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #dedede;
}
table.gridtable td {
	border-width: 1px;
	padding: 8px;
	border-style: solid;
	border-color: #666666;
	background-color: #ffffff;
}
</style>
  </head>
  
  <body>
  <%    
  response.setHeader("Pragma","No-cache");      
  response.setHeader("Cache-Control","no-cache");      
  response.setDateHeader("Expires",0);    
  %> 
  <div align="center"><a href="addmember.jsp">Add</a> <a href="DeleteServlet?Id=0">DeleteAll</a></div><br>
  <form name="editmember" action="UpdateServlet">
    <table class="gridtable" align="center">
    	<tr>	
    		<th>ID</th>
    		<th>Appellation</th>
    		<th>Name</th>
    		<th>Age</th>
    		<th>Favorite</th>
    		<th>Job</th>
    		<th>Action</th>
    	</tr>

    	<%
/*     		ArrayList<FamilyMember> memberlist = (ArrayList<FamilyMember>)request.getSession().getAttribute("memberlist");
    		if(memberlist==null || memberlist.size()==0){
    			out.println("No Data!");
    			return;
    		}
    		String editId=(String)request.getSession().getAttribute("editid"); */
    		//for(FamilyMember member:memberlist){
    			//if(String.valueOf(member.getId()).equals(editId)){
    			%>
    	<c:forEach var="member" items="${sessionScope.memberlist}">
    	<c:choose>
		<c:when test="${sessionScope.editid == member.id}">
    	 <!--<tr>
    	  		<td><input name="Id" value="<%//= member.getId() %>" readonly="readonly"></td>
    	 		<td><input name="Appellation" value="<%//= member.getAppellation() %>"></td>
    	 		<td><input name="Name" value="<%//= member.getName() %>"></td>
    	 		<td><input name="Age" value="<%//= member.getAge() %>"></td>
    	 		<td><input name="Favorite" value="<%//= member.getFavorite() %>"></td>
    	 		<td><input name="Job" value="<%//= member.getJob() %>"></td>
    	 		<td><input type="Submit" value="Save"></td>
    	 </tr>  --> 
    	 	    <td><input name="Id" value="${member.id}" readonly="readonly"></td>
    	 		<td><input name="Appellation" value="${member.appellation}"></td>
    	 		<td><input name="Name" value="${member.name}"></td>
    	 		<td><input name="Age" value="${member.age}"></td>
    	 		<td><input name="Favorite" value="${member.favorite}"></td>
    	 		<td><input name="Job" value="${member.job}"></td>
    	 		<td><input type="Submit" value="Save"></td>
    			<%//}else{%>
    	</c:when>
    	<c:otherwise>
    	 <!--<tr>
    	 	<td><%//= member.getId() %></td>
    	 	<td><%//= member.getAppellation() %></td>
    	 	<td><%//= member.getName() %></td>
    	 	<td><%//= member.getAge() %></td>
    	 	<td><%//= member.getFavorite() %></td>
    	 	<td><%//= member.getJob() %></td>
    	 	<td><a href="ShowAllResults?editid=<%//= member.getId() %>">Edit</a> <a href="DeleteServlet?Id=<%//= member.getId() %>">Delete</a></td>
    	 </tr>  -->
    	 <tr>
    	 	<td>${member.id}</td>
    	 	<td>${member.appellation}</td>
    	 	<td>${member.name}</td>
    	 	<td>${member.age}</td>
    	 	<td>${member.favorite}</td>
    	 	<td>${member.job}</td>
    	 	<td><a href="ShowAllResults?editid=${member.id}">Edit</a> <a href="DeleteServlet?Id=${member.id}">Delete</a></td>
    	 </tr>
    	 <%//}}%>
    	 </c:otherwise>
    	</c:choose>
    	 </c:forEach>
    </table>
    </form>
  </body>
</html>
