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
				<a href='userDel?cid=<%=u.getCid()%>' onclick="return del();">删除</a>
			</td>
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
	<nav>
  <ul class="pagination">
    <li>
      <a href="#" aria-label="Previous">
        <span aria-hidden="true">&laquo;</span>
      </a>
    </li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li class='active'><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li>
      <a href="#" aria-label="Next">
        <span aria-hidden="true">&raquo;</span>
      </a>
    </li>
  </ul>
</nav>
</div>
<script type="text/javascript">
	function del() {
		if (confirm("确定要删除数据吗？")) {
			alert("确定");
			return true;
		}
		return false;
	}
	$("a").click(function(e) {
		e.preventDefault();
	});
	function myLoad(url) {
		loadDataByGet("<%=basePath%>"+url,"userList");
	}
</script>
