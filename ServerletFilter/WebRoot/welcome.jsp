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

<title></title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="Content/Css/myCss.css" type="text/css"></link>
<script type="text/javascript" src="Content/JS/myJs.js"></script>
</head>

<body style='background-color:#CCCCFF'>
	<div
		style='margin-top:120px;margin-left:auto;margin-right:auto;min-height:50px;max-width:300px;border:1px solid red;padding-left:12px;'>
		<ul>
			<li>
				<%
					List<User> ulList = (List<User>) request.getAttribute("uList");
					if (ulList != null) {
				%> <%=ulList.size()%></li>
			<%
				for (User u : ulList) {
			%>
			<li><%=u.getName()%> __ <%=u.getAge()%> <a
				href='userEdit?cid=<%=u.getCid()%>'>编辑</a>| <a
				href='userDel?cid=<%=u.getCid()%>' onclick="return del();">删除</a></li>
			<%
				}
				}
			%>
		</ul>
	</div>
	<script type="text/javascript">
	function del(){
	if(confirm("确定要清空数据吗？"))
	{
	alert("确定");
	return true;
	}
	
	return false;
	}
	</script>
</body>
</html>
