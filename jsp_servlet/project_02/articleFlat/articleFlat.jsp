<%@ page pageEncoding="GB18030"%>
<%@ page import="com.base.demo.article.*,com.base.demo.mysql.*,java.util.*,java.sql.*,java.text.*,com.base.demo.pagebean.*" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<%
PageBean pageBean = new PageBean();
pageBean.setPageSize(2);
int currentPage = request.getParameter("currentPage") == null ? 1 : Integer.parseInt(request.getParameter("currentPage"));
if (currentPage <= 0) {
	currentPage = 1;
}
List<Article> article = new ArrayList<Article>();
String sql = "select count(*) from article where pid=0";
Connection con = Mysql.getConnection();
PreparedStatement pstmt = null;
ResultSet rs = null;
pstmt = con.prepareStatement(sql);
rs = pstmt.executeQuery();
if(rs.next()) {
	pageBean.setTotalRecord(rs.getInt(1));
	pageBean.setTotalPage(pageBean.getTotalRecord(), pageBean.getPageSize());
}
if (currentPage > pageBean.getTotalPage()) {
	currentPage = pageBean.getTotalPage();
}

String sql2 = "select *from article where pid=0 order by pdate desc limit "+(currentPage-1)*pageBean.getPageSize()+","+pageBean.getPageSize();
pstmt = con.prepareStatement(sql2);
rs = pstmt.executeQuery();
while (rs.next()) {
	Article ar = new Article();
	ar.initFromResultSet(rs);
	article.add(ar);
}
%>
<html>
<head>
<title>Java����*������</title>
<meta http-equiv="content-type" content="text/html; charset=utf8">
<link rel="stylesheet" type="text/css" href="images/style.css" title="Integrated Styles">
<script language="JavaScript" type="text/javascript" src="images/global.js"></script>
<link rel="alternate" type="application/rss+xml" title="RSS" href="http://bbs.chinajavaworld.com/rss/rssmessages.jspa?forumID=20">
<script language="JavaScript" type="text/javascript" src="images/common.js"></script>
</head>
<body>
<table border="0" cellpadding="0" cellspacing="0" width="100%">
  <tbody>
    <tr>
      <td width="40%"><img src="images/header-stretch.gif" alt="" border="0" height="57" width="100%">
     	</td>
      <td width="1%"><img src="images/header-right.gif" alt="" height="57" border="0"></td>
    </tr>
  </tbody>
</table>
<br>
<div id="jive-forumpage">
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="98%"><p class="jive-breadcrumbs">��̳: Java����*������
            (ģ��)</p>
          <p class="jive-description"> ̽��Java���Ի���֪ʶ,�����﷨�� ���һ���� ��ͬ��ߣ�л���κ���ʽ�Ĺ�� </p>
          </td>
      </tr>
    </tbody>
  </table>
  <div class="jive-buttons">
    <table summary="Buttons" border="0" cellpadding="0" cellspacing="0">
      <tbody>
        <tr>
          <td class="jive-icon"><a href="post.jsp"><img src="images/post-16x16.gif" alt="����������" border="0" height="16" width="16"></a></td>
          <td class="jive-icon-label"><a id="jive-post-thread" href="postFlat.jsp">����������</a> <a href="http://bbs.chinajavaworld.com/forum.jspa?forumID=20&amp;isBest=1"></a></td>
        </tr>
      </tbody>
    </table>
  </div>
  <br>
  <table border="0" cellpadding="3" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td><span class="nobreak">
       	     ��<%=currentPage %>ҳ
       	     ��<%=pageBean.getTotalPage() %>ҳ
          <span class="jive-paginator"> [
          <a href="articleFlat.jsp?currentPage=<%=1%>">��ҳ</a>
          <a href="articleFlat.jsp?currentPage=<%=currentPage-1%>">��һҳ</a>
          <a href="articleFlat.jsp?currentPage=<%=currentPage+1%>">��һҳ</a>
           <a href="articleFlat.jsp?currentPage=<%=pageBean.getTotalPage()%>">βҳ</a>
           ] </span> </span> </td>
      </tr>
    </tbody>
  </table>
  <table border="0" cellpadding="0" cellspacing="0" width="100%">
    <tbody>
      <tr valign="top">
        <td width="99%"><div class="jive-thread-list">
            <div class="jive-table">
              <table summary="List of threads" cellpadding="0" cellspacing="0" width="100%">
                <thead>
                  <tr>
                    <th class="jive-first" colspan="3"> ���� </th>
                    <th class="jive-author"> <nobr> ����
                      &nbsp; </nobr> </th>
                    <th class="jive-view-count"> <nobr> ���
                      &nbsp; </nobr> </th>
                    <th class="jive-msg-count" nowrap="nowrap"> �ظ� </th>
                    <th class="jive-last" nowrap="nowrap"> �������� </th>
                  </tr>
                </thead>
                <tbody>
                <!-- ��ʼ -->
                    <%
                    	int i = 0;
                    	for (Article ar : article) {
                    	String classStr = i % 2 == 0 ? "jive-even" : "jive-odd";
                    	i++;
                    %>
                     
                  <tr class="<%=classStr%>">
                    <td class="jive-first" nowrap="nowrap" width="1%"><div class="jive-bullet"> <img src="images/read-16x16.gif" alt="�Ѷ�" border="0" height="16" width="16">
                        <!-- div-->
                      </div></td>
                      
                    <td nowrap="nowrap" width="1%">
                     <!-- ���� -->
                        <a href="modifyFlat.jsp?id=<%=ar.getId()%>">MOD</a>
                    <!-- ɾ�� -->
                    	<a href="deleteFlat.jsp?id=<%=ar.getId()%>&isLeaf=<%=ar.getIsleaf()%>">DEL</a>
                    	
                    </td>
                    
                    <td class="jive-thread-name" width="95%"><a id="jive-thread-1" href="articleDetailFlat.jsp?rootid=<%=ar.getRootid() %>" ><%=ar.getTitle() %></a></td>
                    <td class="jive-author" nowrap="nowrap" width="1%"><span class=""> <a href="http://bbs.chinajavaworld.com/profile.jspa?userID=226030">bjsxt</a> </span></td>
                    <td class="jive-view-count" width="1%"> 10000</td>
                    <td class="jive-msg-count" width="1%"> 0</td>
                    <td class="jive-last" nowrap="nowrap" width="1%"><div class="jive-last-post"><%=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(ar.getPdate()) %> <br>
                        by: <a href="http://bbs.chinajavaworld.com/thread.jspa?messageID=780182#780182" title="jingjiangjun" style="">����ѧ</a> </div></td>
                  </tr>
                  
                  <%
                    	}
                  %>
  
                </tbody>
              </table>
            </div>
          </div>
          <div class="jive-legend"></div></td>
      </tr>
    </tbody>
  </table>
  <br>
  <br>
</div>
</body>
</html>
