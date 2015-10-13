<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<%@taglib uri="/struts-tags" prefix="s"%>
<title>My JSP 'ognl.jsp' starting page</title>

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
	<br>
	<p>
		s:property 取值 value Stack：
		<s:property value="name" />
	</p>
	<p>
		访问对象的方法
		<s:property value="user.name" />
		或者
		<s:property value="user['name']" />
		或者
		<s:property value="user[\"name\"]" />
	</p>
	<p>
		getName:
		<s:property value="user.getName()" />
		——toString():
		<s:property value="user.toString()" />
	</p>
	<p>
		User.SubUser name:
		<s:property value="cat.friend.name" />
	</p>
	<p>
		访问值栈对象的普通方法 string.length()：
		<s:property value="psd.length()" />
	</p>
	<p>
		访问值栈对象的普通方法 cat.miaomiao()：
		<s:property value="cat.miaomiao()" />
	</p>
	<p>
		访问值栈action的普通方法 ：
		<s:property value="met()" />
	</p>
	<!-- 使用静态方法一定要打开<constant name="struts.ognl.allowStaticMethodAccess" value="true"></constant> -->
	<p>
		访问静态方法：
		<s:property value="@a.b.s.C@MET()" />
	</p>
	<p>
		访问静态字段：
		<s:property value="@a.b.s.C@ST" />
	</p>
	<p>
		访问静态方法：
		<s:property value="@a.b.s.S@s()" />
	</p>
	<p>
		访问静态字段：
		<s:property value="@a.b.s.S@STR" />
	</p>
	<p>
		普通类的构造方法：
		<s:property value="new a.b.m.User(\"zhangsan\",\"123\")" />
	</p>
	<p>
		访问集合：
		<s:property value="users" />
	</p>
	<p>
		访问集合指定元素[0]：
		<s:property value="users[0]" />
	</p>
	<p>
		访问集合指定元素[0]的属性(name)：
		<s:property value="users[0].name" />
		或者
		<s:property value="users.{name}[0]" />
	</p>
	<p>
		访问map：
		<s:property value="seU" />
	</p>
	<p>
		访问map指定元素：
		<s:property value="seU.s1" />
		或者
		<s:property value="seU['s1']" />
		或者
		<s:property value="seU[\"s1\"]" />
	</p>
	<p>
		访问map的keys：
		<s:property value="seU.keys" />
	</p>
	<p>
		访问map的values：
		<s:property value="seU.values" />
	</p>
	<p>
		访问容器的大小：
		<s:property value="seU.size()" />
	</p>
	<p>
		过滤 age=13的：
		<s:property value="users.{?#this.age=='13'}" />
	</p>
	<p>
		过滤 age=13的name：
		<s:property value="users.{?#this.age=='13'}.{name}" />
		__单个
		<s:property value="users.{?#this.age=='13'}.{name}[0]" />
		__单个
		<s:property value="users.{?#this.age=='13'}[0].name" />
	</p>
	<p>
		过滤 age>=13的name：
		<s:property value="users.{?#this.age>='13'}.{name}" />
		__第一个
		<s:property value="users.{^#this.age>='13'}.{name}[0]" />
		__第一个
		<s:property value="users.{^#this.age>='13'}[0].name" />
		__最后一个
		<s:property value="users.{$#this.age>='13'}.{name}[0]" />
	</p>
	<p>
		过滤 age>15的是否为空：
		<s:property value="users.{$#this.age>'15'}.{name}==null" />
		_取值
		<s:property value="users.{?#this.age>='15'}.{name}" />
		_取长度
		<s:property value="users.{?#this.age>='15'}.size()" />
	</p>
	<s:debug />
</body>
</html>
