<%@ page pageEncoding="GB18030"%>
<%@ page import="com.base.demo.mysql.*,java.sql.*" %>
<%
	request.setCharacterEncoding("GBK");
	int pid = Integer.parseInt(request.getParameter("pid"));
	int rootid = Integer.parseInt(request.getParameter("rootid"));
	String title = request.getParameter("title");
	String cont = request.getParameter("editor");
	Connection con = Mysql.getConnection();
	
	boolean autocommit = con.getAutoCommit();
	con.setAutoCommit(false);
	
	String sql = "insert into article values(null,?,?,?,?,now(),?)";
	PreparedStatement stmt = null;
	stmt = con.prepareStatement(sql);
	stmt.setInt(1, pid);
	stmt.setInt(2,rootid);
	stmt.setString(3, title);
	stmt.setString(4,cont);
	stmt.setInt(5, 0);
	stmt.executeUpdate();
	
	stmt = con.prepareStatement("update article set isleaf = 1 where id="+pid);
	stmt.executeUpdate();
	
	con.commit();
	con.setAutoCommit(autocommit);
	stmt.close();
	con.close();
	
%>
<span id="time" style="background:red">3</span>����Զ���ת,�������ת����
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
	//ÿ��һ���ӵ���һ��
	setTimeout("delayURL('" + url + "')",1000);

}
</script>

<a href="article.jsp">�����б�</a>

<script type="text/javascript">
delayURL("article.jsp");
</script> 


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<html>
<head>
<body>
<p>�ظ��ɹ�!</p><br>
<a href="article.jsp">�����������̳</a>
</body>
</html>
