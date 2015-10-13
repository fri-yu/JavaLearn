<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'tags.jsp' starting page</title>

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
	This is my JSP page.
	<br />
	<br />
	<span>property 取值：</span>
	<p>
		name:
		<s:property value="name" />
	</p>
	<p>
		字符串变量:
		<s:property value="'str'" />
	</p>
	<p>
		取值，取不到则取默认值:
		<s:property value="str" default="String" />
	</p>
	<p>
		写Html代码:
		<s:property value="'<hr/>'" />
	</p>
	<p>
		写Html代码:
		<s:property value="'<hr/>'" escape="false" />
	</p>
	<span>set tag：</span>
	<p>
		设定值
		<s:set var="adminName" value="123" />
		<!-- 数字直接写 -->
		<s:set var="adminName2" value="'管理员'" />
		<!-- 字符串加引号-->
		&nbsp;
		<s:set var="adminName3" value="name" />
		<!-- 也可以使用对象 -->
	</p>
	<p>
		取出值 request:
		<s:property value="#request.adminName" />
		&nbsp;
		<s:property value="#request.adminName2" />
		&nbsp;
		<s:property value="#request.adminName3" />

	</p>
	<p>
		取出值 action(Stack)Context:
		<s:property value="#adminName" />
		&nbsp;
		<s:property value="#adminName2" />
		&nbsp;
		<s:property value="#adminName3" />

	</p>
	<p>
		设定值加作用范围(page)
		<s:set var="agee" value="123" scope="page" />
		<!-- 数字直接写 -->
		<s:set var="agee2" value="'管理员'" scope="page" />
		<!-- 字符串加引号-->
		&nbsp;
		<s:set var="agee3" value="age" scope="page" />
		<!-- 也可以使用对象 -->
	</p>
	<p>
		取出值 action(Stack)Context 取不到值:
		<s:property value="#agee" />
		&nbsp;
		<s:property value="#agee2" />
		&nbsp;
		<s:property value="#agee3" />
	</p>
	<p>
		取出值 pageContext:
		<%=pageContext.getAttribute("agee")%>
		&nbsp;
		<%=pageContext.getAttribute("agee2")%>
		&nbsp;
		<%=pageContext.getAttribute("agee3")%>
		<s:debug></s:debug>
	</p>
</body>
</html>
