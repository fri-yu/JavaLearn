<%@page import="com.demo.util.EDifficultyPoint"%>
<%@ page language="java" import="java.util.*,com.demo.domain.QuestionChoice" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<base href="<%=basePath%>">
<%
	QuestionChoice question = (QuestionChoice) request
	.getAttribute("model");
	if (question != null) {
%>
<form class="form-horizontal" id="questionEditForm">
	<div class="form-group">
		<label class="col-sm-2 control-label">题干</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="题干" name="qContent" value='<%=question.getContent()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项A</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项A" name="optionA" value='<%=question.getOptionA()%>' />
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">选项B</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项B" name="optionB" value='<%=question.getOptionB()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项C</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项C" name="optionC" value='<%=question.getOptionC()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项D</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项D" name="optionD" value='<%=question.getOptionD()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项E</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="选项E" name="optionE" value='<%=question.getOptionE()%>' />
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">选项E</label>
		<div class="col-sm-10">
			<select class="form-control" style="width:60%;" id="difficultyPointSel" onchange="difficultyPointChange(this.value)">
				<%
					for (EDifficultyPoint et : EDifficultyPoint.values()) {
				%>
				<option value="<%=et.getValue()%>"><%=et.getValue()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value='<%=0%>' id="difficultyPoint" name="difficultyPoint" />
		</div>
	</div>
	<div class="form-group">
		<label for="inputPassword3" class="col-sm-2 control-label">答案</label>
		<div class="col-sm-10">
			<input class="form-control" id="" placeholder="答案" name="qAnswer" value='<%=question.getAnswer()%>' /> <input
				type="hidden" name="hiloId" value="<%=request.getAttribute("hiloId")%>" /> <input type="hidden" name="questionType"
				value="<%=request.getAttribute("questionType")%>" />
		</div>
	</div>
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button type="button" class="btn btn-default"
				onclick="myPost('questionEdit?questionType=<%=request.getAttribute("questionType")%>','questionEditForm','questionList')">保存</button>
		</div>
	</div>
</form>
<%
	}
%>
<script type="text/javascript">
	function difficultyPointChange(str) {
		$("#difficultyPoint").val(str);
	}
</script>

