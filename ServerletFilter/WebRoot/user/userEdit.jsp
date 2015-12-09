<%@ page language="java" import="java.util.*,com.demo.domain.User" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<base href="<%=basePath%>">
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<%
	User user = (User) request.getAttribute("user");
	if (user != null) {
%>
<form class="form-horizontal" id="userEditForm">
	<div class="form-group">
		<label class="col-sm-2 control-label">账号</label>
		<div class="col-sm-10">
			<input class="form-control" id="inputEmail3" placeholder="账号" name="uName" value='<%=user.getName()%>' />
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="inputPassword3" placeholder="Password" name="uPsd"
				value='<%=user.getPassword()%>' /> <input type="hidden" name="cid" value="<%=user.getCid()%>" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default" onclick="myPost('<%=basePath%>'+'userEdit','userList','userEditForm')">保存</button>
		</div>
	</div>
</form>
<%
	}
%>
<script type="text/javascript">
	$("a").click(function(e) {
		e.preventDefault();
	});
</script>

