<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<form action="register_finish.jsp" method="post" >
	<!-- 姓名username、班级grade、学号number、电话phone -->
		<label>姓名:</label><input name="username"/><br/>
		<label>班级:</label><input name="grade"/><br/>
		<label>学号:</label><input name="number"/><br/>
		<label>电话:</label><input name="phone"/><br/>
		<label>密码:</label><input name="password" type="password" /><br/>
		<input type="submit" value="注册" />
	</form>
</body>
</html>