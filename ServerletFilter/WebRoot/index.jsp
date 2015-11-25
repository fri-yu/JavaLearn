<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  contentType="text/html; charset=utf-8" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'index.jsp' starting page</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="Content/Css/myCss.css" type="text/css"></link><script
	type="text/javascript" src="Content/JS/myJs.js"></script>
</head>

<body style='background-color:#CCCCFF'>
	<form action='login' method='post'>
		<br>
		<div
			style='margin-top:120px;margin-left:auto;margin-right:auto;min-height:50px;max-width:300px;border:1px solid red;padding-left:12px;'>
			<p>
				账号：<input type='text' name='loginName' /><%if(request.getParameter("errInfo")!=null) %><%=request.getParameter("errInfo") %>
			</p>
			<p>
				密码：<input type='password' name='loginPsd' />
			</p>
			<p>
				<input type='submit' value='登录'>
			</p>
		</div><a href="hello?name=编码">试试</a>
	</form>
</body>
</html>
