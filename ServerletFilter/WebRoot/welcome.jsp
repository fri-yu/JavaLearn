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
	<!-- <a href='userList'>用户列表</a>
	<a>添加用户</a> -->
	<div class="row"
		style="width:98%;padding-top:120px;margin-right:auto;margin-left:auto;">
		<div class="col-md-1"></div>
		<div class="col-md-3">
			<ul id="myTab" class="nav nav-tabs  nav-stacked">
				<li class="active"><a href="#userList" name="userList"
					onclick="loadDiv(this)">用户列表</a></li>
				<li><a href="#paperList" name="paperList"
					onclick="loadDiv(this)">试卷列表</a></li>
				<li><a href="#questionList" name="questionList"
					onclick="loadDiv(this,'questionType=Choice')">试题列表</a></li>
			</ul>
		</div>
		<div class="col-md-7">
			<div id="myTabContent" class="tab-content">
				<div class="tab-pane fade in active" id="userList">
					<p>用户列表页面</p>
				</div>
				<div class="tab-pane fade" id="paperList">
					<p>试卷列表页</p>
				</div>
				<div class="tab-pane fade" id="questionList">
					<p>试题列表页</p>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
	</div>
	<script>
		$(function() {
			$('#myTab a:first').tab('show');
			$('#myTab a').click(function(e) {
				e.preventDefault();//阻止a链接的跳转行为
				//
				//loadDataByGet(url, this.name);
				//$(this).tab('show');//显示当前选中的链接及关联的content 
			})
		})
		function loadDiv(ele,paras) {
			var url ="<%=basePath%>" + ele.name;
			if (paras != undefined)
				url += "?" + paras;
			//alert(ele.name);
			//alert(url);
			loadDataByGet(url, ele.name);
			$(ele).tab('show');//显示当前选中的链接及关联的content 
		}
	</script>
</body>
</html>
