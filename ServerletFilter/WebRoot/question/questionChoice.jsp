<%@page import="com.demo.viewModel.QuestionListModel"%>
<%@page import="com.demo.domain.QuestionChoice"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	QuestionListModel model = (QuestionListModel) request
			.getAttribute("model");
	List<QuestionChoice> cList = model.getqCList();
%>

<div class="table-responsive">
	<table class="table table-striped table-bordered">
		<tr>
			<td>题干</td>
			<td>难度系数</td>
			<td>操作</td>
		</tr>
		<%
			if (model != null) {
				for (QuestionChoice q :cList) {
		%>
		<tr>
			<td><%=q.getContent()%></td>
			<td><%=q.getDifficultyPonit()%></td>
			<td><a href='#' onclick="myLoad('userEdit?cid=<%=q.getHiloId()%>')">编辑</a>|
				<a href='#' onclick="del('userDel?cid=<%=q.getHiloId()%>');">删除</a>
			</td>
		</tr>
		<%
			}
			}
		%>
	</table>
</div>