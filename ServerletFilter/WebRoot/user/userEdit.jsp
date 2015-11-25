<%@ page language="java" import="java.util.*,com.demo.domain.User"
	pageEncoding="UTF-8"%>
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

<title>My JSP 'userEdit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

</head>

<body>
	<%
		User user = (User) request.getAttribute("user");
		if (user != null) {
	%>
	<form action="userEdit" method="post">
		<p>
			用户名：<input type="text" name="uName" value='<%=user.getName()%>' />
		</p>
		<p>
			密 码：<input type="text" name="uPsd"value='<%=user.getPassword()%>' />
		</p>

		<p>
			<input type='submit' value='修改'>
		</p>
		<input type="hidden" name="cid"value="<%=user.getCid()%>" />
	</form>
	<%
		}
	%>
</body>
</html>
