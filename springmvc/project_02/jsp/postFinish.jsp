<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<p>发表主题成功</p>
<span id="time" style="background:red">3</span>
<p>秒后自动跳转,如果没跳转请点击返回</p>
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

<a href="articleList.do">主题列表</a>

<script type="text/javascript">
delayURL("articleList.do");
</script>
</body>
</html>