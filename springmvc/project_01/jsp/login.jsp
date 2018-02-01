<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<form action="index.do" method="post">
		<table >
			<tr>
				<td><input id="s" name="username" placeholder="用户名" /></td>
			</tr>
			<tr>
				<td><input name="password" type="password" placeholder="密码"/></td>
			</tr>
		</table>
		<input type="submit" value="登陆" />
		</form>
		<a href="register.do">注册</a>
	</div>
	
</body>
</html>