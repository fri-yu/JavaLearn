<%@ page language="java"
	import="java.util.*,com.demo.domain.QuestionChoice"
	pageEncoding="UTF-8"%>
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
	QuestionChoice question = (QuestionChoice) request
			.getAttribute("model");
	if (question != null) {
%>
<form class="form-horizontal" id="questionEditForm">
	<div class="form-group">
		<label class="col-sm-2 control-label">题干</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="题干"
				name="uName" value='<%=question.getContent()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项A</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项A"
				name="uName" value='<%=question.getOptionA()%>' />
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">选项B</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项B"
				name="uName" value='<%=question.getOptionB()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项C</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项C"
				name="uName" value='<%=question.getOptionC()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项D</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项D"
				name="uName" value='<%=question.getOptionD()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项E</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项E"
				name="uName" value='<%=question.getOptionE()%>' />
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">答案</label>
		<div class="col-sm-10">
			<input class="form-control" id=""
				placeholder="答案" name="uPsd" value='<%=question.getAnswer()%>' /> <input
				type="hidden" name="hiloid" value="<%=question.getHiloId()%>" />
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
		loadDataByPost("<%=basePath%>" + "questionEdit", "questionList",
				serializeForm('questionEditForm'));
	}
</script>

