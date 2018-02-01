<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	String username = (String)session.getAttribute("username");
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>欢迎<%=username %>登陆成功</h1><br/>
	<form action="database_list.do">
	<input type="submit" value="查询数据库信息" />
	</form>
	<a href="delete.do">删除此用户</a>
	
</body>
</html>