<%@ page language="java"
	import="java.util.*,com.demo.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<form class="form-inline" id="queryForm">
	<div class="row">
		<div class="col-md-2 text-center">
				<label for="questionType">题型：</label> 
				<select class="form-control" style="width:60%;" id="questionType">
					<%
						for (EQuestionType st : EQuestionType.values()) {
					%>
					<option href="#"><%=st.getValue()%></option>
					<%
						}
					%>
				</select>
		</div>
		<div class="col-md-2 text-center">
				<label for="difficultPoint">难度：</label> 
				<select class="form-control" style="width:60%;" id="difficultPoint">
					<%
						for (EDifficultyPoint et : EDifficultyPoint.values()) {
					%>
					<option value="<%=et.getValue()%>"><%=et.getValue()%></option>
					<%
						}
					%>
				</select>
		</div>
		<div class="col-md-3 text-center">
			<div class="form-group">

				<label for="inputAge">年龄：</label> <input type="text"
					class="form-control" id="inputAge" placeholder="请输入年龄"
					name="queryAge">
			</div>
		</div>
	
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="query()">查询</button>
		</div>
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="addUser()">添加</button>
		</div>
	</div>
</form>