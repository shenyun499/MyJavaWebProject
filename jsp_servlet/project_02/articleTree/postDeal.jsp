<%@ page pageEncoding="GB18030"%>
<%@ page import="com.base.demo.mysql.*,java.sql.*" %>
<%
	int rootid = 0;
	request.setCharacterEncoding("GBK");
	String title = request.getParameter("title");
	String cont = request.getParameter("editor");
	Connection con = Mysql.getConnection();
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
	stmt = con.prepareStatement("select *from article");
	rs = stmt.executeQuery();
	while (rs.next()) {
		if (rootid < rs.getInt("rootid")) {
			rootid = rs.getInt("rootid");
			}
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	try {
		stmt = con.prepareStatement("insert into article values(null,?,?,?,?,now(),?)");
		stmt.setInt(1, 0);
		stmt.setInt(2,rootid+1);
		stmt.setString(3, title);
		stmt.setString(4,cont);
		stmt.setInt(5, 0);
		stmt.executeUpdate();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	stmt.close();
	con.close();
	
%>



<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<body>
<span id="time" style="background:red">3</span>
<p>秒后自动跳转,如果不跳转请点击</p>
<script language="JavaScript1.2" type="text/javascript">

function delayURL(url) {
	var delay = document.getElementById("time").innerHTML;
	//alert(delay);
	if (delay > 0) {
		delay--;
		document.getElementById("time").innerHTML = delay;
	} else {
		window.top.location.href = url;
	}
	//每隔一秒钟调用一次
	setTimeout("delayURL('" + url + "')",1000);

}
</script>

<script type="text/javascript">
delayURL("article.jsp");
</script> 
<p>发表主题成功!</p><br>
<a href="article.jsp">点击返回主论坛</a>
</body>
</html>
