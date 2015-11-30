<%@ page language="java"
	import="java.util.*,com.demo.domain.User,com.demo.viewModel.WelComeModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	WelComeModel model = (WelComeModel) request.getAttribute("model");
%>
<div class="table-responsive">
	<table class="table table-striped table-bordered">
		<tr>
			<td>姓名</td>
			<td>年龄</td>
			<td>操作</td>
		</tr>
		<%
			if (model != null) {
				for (User u : model.getuList()) {
		%>
		<tr>
			<td><%=u.getName()%></td>
			<td><%=u.getAge()%></td>
			<td><a href='#' onclick="myLoad('userEdit?cid=<%=u.getCid()%>')">编辑</a>|
				<a href='#' onclick="del('userDel?cid=<%=u.getCid()%>');">删除</a>
			</td>
		</tr>
		<%
			}}
		%>
	</table>
	<%
		if (model != null) {
	%><nav>
		<ul class="pagination">
			<%
				for(String key :model.getPageLinkDic().keySet())
					{
					if(model.getPageLinkDic().get(key)!="..."){
					if(!model.getPageLinkDic().get(key).equals(model.getCurrentPage()+""))
					{
			%>
			<li><a href="#" onclick="myPage('userList?<%=key%>')"><%=model.getPageLinkDic().get(key)%></a>
			</li>
			<%
				}else {
			%>
			<li class='active'><a href="#"><%=model.getCurrentPage()%></a></li>
			<%
				}}
					else
					{
			%>
			<li><a href="#"><%=model.getPageLinkDic().get(key)%></a></li>
			<%
				}
					}
			%>
		</ul>
	</nav>
	<%
		}
	%>
</div>
<script type="text/javascript">
	function del(url) {
		if (confirm("确定要删除数据吗？")) {
			loadDataByGet("<%=basePath%>"+url,"userList");
		}
	}
	$("a").click(function(e) {
		e.preventDefault();
	});
	function myLoad(url) {
		loadDataByGet("<%=basePath%>"+ url, "userList");
	}
	function myPage(url)
	{
	loadDataByGet("<%=basePath%>"+ url, "userList");
	}
</script>
