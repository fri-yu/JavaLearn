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

<link rel="stylesheet"
	href="Content/bootstrap-3.3.5-dist/css/bootstrap.css" type="text/css"></link>
<script type="text/javascript" src="Content/JS/jquery-2.1.3.min.js"></script>
<script type="text/javascript"
	src="Content/bootstrap-3.3.5-dist/js/bootstrap.min.js"></script>
</head>

<body style='background-color:#E6E2EB;'>
	<a href='userList'>用户列表</a>
	<a>添加用户</a>
	<div class="row" style="width:98%;padding-top:120px;margin-right:auto;margin-left:auto;">
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<ul id="myTab" class="nav nav-tabs  nav-stacked">
				<li class="active"><a href="#userList" name="userList">用户列表</a>
				</li>
				<li><a href="#addUser" name="addUser">添加用户</a></li>
			</ul>
		</div>
		<div class="col-md-7">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="userList">
					<p>用户列表页面</p>
				</div>
				<div class="tab-pane fade" id="addUser">
					<p>iOS 是一个由苹果公司开发和发布的手机操作系统。最初是于 2007 年首次发布 iPhone、iPod Touch 和
						Apple TV。iOS 派生自 OS X，它们共享 Darwin 基础。OS X 操作系统是用在苹果电脑上，iOS
						是苹果的移动版本。</p>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<script>
		$(function() {
			$('#myTab a:last').tab('show');
			$('#myTab a').click(function(e) {
				e.preventDefault();//阻止a链接的跳转行为
				var url ="<%=basePath%>"
		 + this.name;
				loadDataByGet(url, this.name);
				$(this).tab('show');//显示当前选中的链接及关联的content 
			})
		})
	</script>
</body>
</html>
