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
	</p>
	<ul>
		<li>set 设定var，范围为session: <s:set var="adminPassword"
				value="123456" scope="session" />
		</li>
		<li>set 使用#取值: <s:property value="#adminPassword" /></li>
		<li>set 从相应范围取值: <s:property value="#session.adminPassword" /></li>
		<li><%=session.getAttribute("adminPassword")%></li>
	</ul>
	<span>bean</span>
	<ul>
		<s:bean name="a.b.m.Dog" var="mydog">
			<s:param name="name" value="'oudy'"></s:param>
		</s:bean>
		<li><s:property value="#mydog" />
		</li>
		<li><s:property value="#mydog.name" />
		</li>
	</ul>
	<span>if elseif else</span>
	<ul>

		<li>age=<s:property value="#parameters.age" />
		</li>
		<!-- 		<li>age=<s:property value="#parameters.age[1]" /></li> -->
		<li><s:if test="#parameters.age[0]>10"> >10</s:if>
		</li>
		<li><s:if test="#parameters.age[1]<10"> <10</s:if>
		</li>
		<li><s:if test="#parameters.age[1]<10"> <10</s:if>
		</li>
		<li><s:elseif test="#parameters.age[1]<30"> <30</s:elseif>
		</li>
		<li><s:else> ~~~~</s:else>
		</li>
		<li><s:if test="#parameters.ages==null">这个是null</s:if> <!-- 索引超出，并不会为null 也不会前台打出异常 #parameters.age[3] #parameters.ages[0]-->
		</li>
	</ul>
	<span>遍历 iterator</span>
	<ul>
		<li><s:iterator value="#parameters.age" var="X">
				<s:property value="#X" />|
			</s:iterator></li>
	</ul>
	<hr />
	<ul>
		<li><s:iterator value="#{'m1':'map1','m2':'map2','m3':'map3'}"
				var="mpt">
				<s:property value="key" />

			</s:iterator></li>
	</ul>
	<ul>
		<li><s:iterator value="#{'m1':'map1','m2':'map2','m3':'map3'}"
				var="mpt">
				<s:property value="#mpt.key" />|<s:property value="#mpt.value" />
				<br />
			</s:iterator></li>
		<s:debug></s:debug>
	</ul>
	<li><s:iterator value="#{1:'a', 2:'b', 3:'c'}">
			<s:property value="key" /> | <s:property value="value" />
			<br />
		</s:iterator></li>
	<li><s:iterator value="#{1:'a', 2:'b', 3:'c'}" var="mpt">
			<s:property value="#mpt.key" /> | <s:property value="#mpt.value" />
			<br />
		</s:iterator></li>

</body>
</html>
