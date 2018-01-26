
<%@page import="java.util.*"%>
<%@page import="com.base.demo.*"%>
<%@ page language="java" import="java.sql.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<% 

	//String username = new String(request.getParameter("username").getBytes("iso8859-1"), "utf-8");
	String username1 = request.getParameter("username");
	String password1 = request.getParameter("password");
	String username = new String(username1.getBytes("iso8859-1"),"utf-8");
	String password = new String(password1.getBytes("iso8859-1"),"utf-8");
	if (username == null || password == null) { 							//name为空或者或者密码为空，不能直接到这个页面
		System.out.print("输入不能为空!");
		response.sendRedirect("login.jsp");									//跳回登陆页面
	} else if (password.equals("") || username.equals("")) {				//就是没有输入信息时		
		System.out.print("输入不能为空!");
		response.sendRedirect("login_false.jsp");							//跳回登陆页面
	} else {	
		User user = new User();												//创建一个用户对象
		
		String driver = "com.mysql.jdbc.Driver";							//获得数据库驱动
		
		String url = "jdbc:mysql://localhost:3306/test";					//获得数据库test的url
		
		String musername = "root";											//获得数据库登陆用户名
		
		String mpassword = "1104428690A";									//获得数据库登陆密码
		
		Connection conn = null;												//获得数据库连接类的引用
		try {
			Class.forName(driver);											//加载驱动
			conn = (Connection) DriverManager.getConnection(url,
					musername, mpassword);									//引用与数据库的连接对象
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
//第一种查询方式
	/*
		String sql = "select *from students_information where 
				username = '"+username+"' and password = '"+password+"'";	//SQL查询语句
		
		PreparedStatement past = null;										//预编译类

		ResultSet rs = null;												//获得结果集的引用
		try {
			past = conn.prepareStatement(sql);								//获得与数据库的信息
			rs = past.executeQuery();										//写入数据，与数据库数据作比较，如果数据相同则则返回该行
			if (rs.next()) {
				user.setUsername(rs.getString("username"));					//设置用户名
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {															//关闭流
			conn.close();
			past.close();
			rs.close();
		}
	*/
	
//第二种查询方式
	/*
		String sql = "select *from students_information where username = ? and password = ?";
	
		PreparedStatement pstmt = null;
	
		ResultSet rs = null;
		try {
			pstmt = (PreparedStatement) conn.prepareStatement(sql);
			pstmt.setString(1, username);
			pstmt.setString(2,password);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			rs.close();
			pstmt.close();
			conn.close();
		}
	*/
	
//第三种单独查询
		String sql1 = "select *from students_information where username = '"+username+"'";
		String sql2 = "select *from students_information where password = '"+password+"'";
		ResultSet rs = null;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql1);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setUsername(rs.getString("username"));
			}
			//重新查询
			pstmt = conn.prepareStatement(sql2);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				user.setPassword(rs.getString("password"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			conn.close();
			pstmt.close();
			rs.close();
		}
		System.out.println(user.getUsername());
		System.out.println(user.getPassword());
		/*
		if (user.getUsername() != null) {
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("login_select.jsp");
		} else {
			request.getRequestDispatcher("login_false.jsp").forward(request, response);
		}
		*/
		if (user.getUsername() == null) {									//用户名错误
			request.getRequestDispatcher("login_false1.jsp").forward(request, response);	//转发，地址栏不会变化
		} else if (user.getPassword() == null) {							//密码错误
			request.getRequestDispatcher("login_false2.jsp").forward(request, response);
		} else {															//信息正确
			session.setAttribute("username", user.getUsername());
			response.sendRedirect("login_select.jsp");
		}
	}
%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>网站首页</title>
</head>
<body>
</body>
</html>