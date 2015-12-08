<%@page import="com.demo.domain.Paper"%>
<%@ page language="java"
	import="java.util.*,com.demo.viewModel.PaperListModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	PaperListModel model = (PaperListModel) request.getAttribute("model");
%>
<form class="form-inline" id="queryForm">
	<div class="row">
		<div class="col-md-4 text-center">
			<div class="form-group">
				<label for="inputName">查询1：</label> <input type="text"
					class="form-control" id="inputName" placeholder="请输入姓名"
					name="queryName">
			</div>
		</div>
		<div class="col-md-4 text-center">
			<div class="form-group">

				<label for="inputAge">查询2：</label> <input type="text"
					class="form-control" id="inputAge" placeholder="请输入年龄"
					name="queryAge">
			</div>
		</div>
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="">查询</button>
		</div>
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="">添加</button>
		</div>
	</div>
</form>
<div class="table-responsive">
	<table class="table table-striped table-bordered">
		<tr>
			<td>选择题数</td>
			<td>填空题数</td>
			<td>判断题数</td>
			<td>简答题数</td>
			<td>操作</td>
		</tr>
		<%
			if (model != null) {
				for (Paper p : model.getpList()) {
		%>
		<tr>
			<td><%=p.getChoiceCount()%></td>
			<td><%=p.getCompletionCount()%></td>
			<td><%=p.getTrueOrFalseCount()%></td>
			<td><%=p.getShortAnswerCount()%></td>
			<td><a href='#' onclick="">编辑</a>|
				<a href='#' onclick="">删除</a>
			</td>
		</tr>
		<%
			}}
		%>
	</table>
	<%
		/*--------------分页------------*/
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
			<li><a href="#" onclick="myPage('paperList?<%=key%>')"><%=model.getPageLinkDic().get(key)%></a>
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
		} /*--------------分页------------*/
	%>
</div>
<script type="text/javascript">
	
	$("a").click(function(e) {
		e.preventDefault();
	});
	
	function myPage(url){
	
		loadDataByGet("<%=basePath%>" + url, "paperList");
	}
	
</script>