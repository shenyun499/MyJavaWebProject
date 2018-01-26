<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册成功页面</title>
</head>
<body>
<%
	//获得学生信息
	String username = request.getParameter("username");
	System.out.println(username);
	String grade = request.getParameter("grade");
	String number = request.getParameter("number");
	String phone = request.getParameter("phone");
	String password = request.getParameter("password");
	
	//连接数据库
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/test";
	String musername = "root";
	String mpassword = "1104428690A";
	Connection conn = null;
	try {
		//加载驱动
		Class.forName(driver);
		conn = (Connection) DriverManager.getConnection(url,musername,mpassword);
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	//数据库增添数据
	String sql = "insert into students_information (username,grade,number,phone,password) value(?,?,?,?,?)";
	PreparedStatement pstmt = null;
	try {
		pstmt = (PreparedStatement) conn.prepareStatement(sql);
		pstmt.setString(1,username);
		pstmt.setString(2,grade);
		pstmt.setString(3,number);
		pstmt.setString(4,phone);
		pstmt.setString(5,password);
		pstmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	} finally {
		pstmt.close();
		conn.close();
	}
%>
<p>恭喜注册成功！</p>
<a href="login.jsp" >返回登陆界面</a>
</body>
</html>