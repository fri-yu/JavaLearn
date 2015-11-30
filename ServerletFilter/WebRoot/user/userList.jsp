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
	<table class="table table-striped">
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
			<td><a href='userEdit?cid=<%=u.getCid()%>'>编辑</a>| <a
				href='userDel?cid=<%=u.getCid()%>' onclick="return del();">删除</a></td>
		</tr>
		<%
			}}
		%>

		<%
			if (model != null) {
			for(String key :model.getPageLinkDic().keySet())
			{
			if(model.getPageLinkDic().get(key)!="..."){
			if(!model.getPageLinkDic().get(key).equals(model.getCurrentPage()+""))
			{
		%>
	</table>
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
