<%@ page language="java"
	import="java.util.*,com.demo.domain.User,com.demo.viewModel.WelComeModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>My JSP 'userList.jsp' starting page</title>

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
		WelComeModel model = (WelComeModel) request.getAttribute("model");
	%>
	<div
		style='margin-top:120px;margin-left:auto;margin-right:auto;min-height:50px;max-width:300px;border:1px solid red;padding-left:12px;'>
		<ul>
			<li>
				<%
					if (model != null) {
				%> <%=model.getuList().size()%></li>
			<%
				for (User u : model.getuList()) {
			%>
			<li><%=u.getName()%> __ <%=u.getAge()%> <a
				href='userEdit?cid=<%=u.getCid()%>'>编辑</a>| <a
				href='userDel?cid=<%=u.getCid()%>' onclick="return del();">删除</a>
			</li>
			<%
				}
											}
			%>
		</ul>
		<%
			if (model != null) {
				for(String key :model.getPageLinkDic().keySet())
				{
				if(model.getPageLinkDic().get(key)!="..."){
				if(!model.getPageLinkDic().get(key).equals(model.getCurrentPage()+""))
				{
		%>
		<a href="userList?<%=key%>"><%=model.getPageLinkDic().get(key)%></a>
		<%
			}
				else
				out.print( model.getCurrentPage());
			}
				else
				{
				out.print( model.getPageLinkDic().get(key));
			}
				}}
		%>
	</div>
	<script type="text/javascript">
		function del() {
			if (confirm("确定要删除数据吗？")) {
				alert("确定");
				return true;
			}

			return false;
		}
	</script>
</body>
</html>
