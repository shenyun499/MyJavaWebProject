
<%@page import="java.util.*"%>
<%@page import="com.base.demo.*"%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 
	//String username = new String(request.getParameter("username").getBytes("iso-8859-1"), "utf-8");
	String username = (String)session.getAttribute("username");

	System.out.println(username);
	List<User> list = new ArrayList<User>();
	
	if (username == null) { 					//name为空(就是没有输入信息时)或者引用为空
		response.sendRedirect("login_false.jsp");					//跳回登陆页面
	} else {
		String driver = "com.mysql.jdbc.Driver";					//连接数据库
		
		String url = "jdbc:mysql://localhost:3306/test";
		
		String musername = "root";
		
		String mpassword = "1104428690A";
		
		Connection conn = null;										//数据库的一个对象
		try {
			Class.forName(driver);
			conn = (Connection) DriverManager.getConnection(url, musername, mpassword);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String sql2 = "select *from students_information";

		PreparedStatement pstmt = null;
	
		ResultSet rs = null;
	
		try {	
			pstmt = (PreparedStatement) conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				User user = new User();								//创建一个user对象
				//获得这个对象的各种信息
				user.setUsername(rs.getString("username"));
				user.setGrade(rs.getString("grade"));
				user.setNumber(rs.getString("phone"));
				user.setPhone(rs.getString(5));
				user.setPassword(rs.getString(6));
				
				list.add(user);										//将对象添加进入到集合
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站首页</title>
</head>
<body>
	<div>
		<p>欢迎<%=username %>,登陆成功！</p>
	</div>
	<center>
		<div>
			<table border = "1px">
				<tr>
					<td>姓名</td>
					<td>班级</td>
					<td>学号</td>
					<td>电话</td>
					<td>密码</td>
				</tr>
				<%
					for (User user : list) {
				%>
					<tr>
						<td><%=user.getUsername() %></td>
						<td><%=user.getGrade() %></td>
						<td><%=user.getNumber() %></td>
						<td><%=user.getPhone() %></td>
						<td><%=user.getPassword() %></td>
					</tr>	
				<% 
				}
				%>
			</table>
		</div>
	</center>
</body>
</html>