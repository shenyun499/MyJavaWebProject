<%@ page pageEncoding="GB18030"%>
<%@ page import="com.base.demo.article.*,com.base.demo.mysql.*,java.util.*,java.sql.*,java.text.*,com.base.demo.pagebean.*" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%!
public void delete(Connection con, int id, boolean isLeaf) {

	if (!isLeaf) {
		String sql = "select *from article where pid='"+id+"'";
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			stmt = con.prepareStatement(sql);
			rs = stmt.executeQuery();
			while (rs.next()) {
				delete(con, rs.getInt("id"), rs.getInt("isLeaf") == 0);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	String sql2 = "delete from article where id="+id;
	PreparedStatement stmt = null;
	ResultSet rs = null;
	try {
		stmt = con.prepareStatement(sql2);
		stmt.executeUpdate();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
}
%>

<%
int id = 0;
boolean isLeaf = false;
if (request.getParameter("id") == null && request.getParameter("isLeaf") == null && request.getParameter("pid") == null) {
	response.sendRedirect("article.jsp");
} else {
	id = Integer.parseInt(request.getParameter("id"));
	isLeaf = Boolean.parseBoolean(request.getParameter("isLeaf"));
	List<Article> article = new ArrayList<Article>();
	Connection con = Mysql.getConnection();
	delete(con, id,isLeaf);
	int pid = Integer.parseInt(request.getParameter("pid"));
	
	PreparedStatement stmt = null;
	ResultSet rs = null;
	stmt = con.prepareStatement("select count(*) from article where pid="+pid);
	
	rs = stmt.executeQuery();
	rs.next();
	int count = rs.getInt(1);
	System.out.println(count);
	System.out.println(id);
	System.out.println(pid);
	if (count <= 0) {
		stmt = con.prepareStatement("update article set isleaf=0 where id="+pid);
		stmt.executeUpdate();
	}
	con.close();
	stmt.close();
}
%>
<html>
	<head>
	</head>
	<body>
		<span>删除成功</span>
		<span id="time" style="background:red">3</span>秒后自动跳转,如果不跳转请点击
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

<a href="articleFlat.jsp">主题列表</a>

<script type="text/javascript">
delayURL("articleFlat.jsp");
</script> 
	</body>
</html>
