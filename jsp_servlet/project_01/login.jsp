<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登陆首页</title>
</head>
<body>
	<center>
		<form action="login_check.jsp" method="post">
			<table>
				<tr>
				<td>用户名:</td>
				<td ><input name="username"/></td>
				</tr>
				<tr>
				<td>密码:</td>
				<td><input name="password" type="password"/></td>
				</tr>
			</table>
			<input type="submit" value="登陆"/>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="register.jsp">注册</a>&nbsp;&nbsp;&nbsp;&nbsp;
			<a href="http://www.baidu.com">百度</a>
		</form>
	</center>
</body>
</html>