<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib  prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.base.demo.pagebean.*"  import="com.base.demo.user.*" import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	PageBean<User> pageBean = (PageBean)request.getAttribute("pageBean");
	List<User> user = pageBean.getResults();
	int totalRecord = pageBean.getTotalRecord();
	int totalPage = pageBean.getTotalPage();
	int currentPage = pageBean.getCurrentPage();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
<h1>访问到了</h1>
	<form>
		<table border="3px">
			<tr>
   				<td>用户名</td>
   				<td>年级</td>
   				<td>学号</td>
   				<td>电话号码</td>
   				<td>密码</td>
   			</tr>
			<%
				for (User use : user) {
			%>
	        	<tr>
       				<td><%=use.getUsername() %></td>
       				<td><%=use.getGrade() %></td>
       				<td><%=use.getNumber() %></td>
       				<td><%=use.getPhone() %></td>
       				<td><%=use.getPassword() %></td>
	        	</tr>
			<%
				}
			%>
		</table>
		<div>
			总计录数:<%=totalRecord%>&nbsp;&nbsp;总页数:<%=totalPage %>&nbsp;&nbsp;第<%=currentPage %>页&nbsp;&nbsp;<a href="firstPage.do?currentPage=1" >首页</a>&nbsp;&nbsp;<a href="nextPage.do?currentPage=<%=currentPage+1%>">下一页</a>&nbsp;&nbsp;<a href="previousPage.do?currentPage=<%=currentPage-1%>">上一页</a>&nbsp;&nbsp;<a href="lastPage.do?currentPage=<%=totalPage %>">尾页</a>
		</div>
	</form>
</center>
</body>
</html>