<%@page import="com.demo.domain.QuestionCompletion"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%
	QuestionCompletion question = (QuestionCompletion) request
			.getAttribute("model");
	if (question != null) {
%>
<form class="form-horizontal" id="questionEditForm">
	<div class="form-group">
		<label class="col-sm-2 control-label">题干</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="题干" name="uName"
				value='<%=question.getContent()%>' />
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">答案</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="答案" name="uPsd"
				value='<%=question.getAnswer()%>' /> <input type="hidden"
				name="hiloid" value="<%=request.getAttribute("hiloId")%>" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default" onclick="myPost()">保存</button>
		</div>
	</div>
</form>
<%
	}
%>
<script type="text/javascript">
	function myPost() {
		loadDataByPost("<%=basePath%>"+ "questionEdit", "questionList",
				serializeForm('questionEditForm'));
	}
</script>

