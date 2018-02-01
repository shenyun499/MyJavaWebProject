<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>

<body>
<center>
	<h3>注册页面</h3>
	<form action="register2.do" method="post">
		<table>
			<tr>
			<td>用户名</td>
			<td><input type="text" name="username" /></td>
			</tr>
			<tr>
				<td>班级</td>
				<td><input type="text" name="grade" /></td>
			</tr>
			<tr>
				<td>学号</td>
				<td><input type="text" name="number" /></td>
			</tr>
			<tr>
				<td>电话</td>
				<td><input type="text" name="phone" /></td>
			</tr>
			<tr>
				<td>密码</td>
				<td><input type="text" name="password" /></td>
			</tr>
		</table>
		<input type="submit" value="确认注册"/>
	</form>
</center>	
</body>
</html>