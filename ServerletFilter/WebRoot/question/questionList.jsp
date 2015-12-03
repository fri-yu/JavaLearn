<%@ page language="java"
	import="java.util.*,com.demo.util.*,com.demo.viewModel.QuestionListModel"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	QuestionListModel model = (QuestionListModel) request
	.getAttribute("model");
	String  questionType=model.getSelectQuestionType();
%>
<form class="form-inline" id="queryFormQuestion">
	<div class="row">
		<div class="col-md-2 text-center">
			<label for="questionTypeSel">题型：</label> <select class="form-control"
				style="width:60%;" id="questionTypeSel"
				onchange="questionTypeChange(this.value)">
				<%
					for (EQuestionType st : EQuestionType.values()) {
				%>
				<option value="<%=st.getKey()%>"
					<%if(questionType.equals(st.getKey())) out.print("selected='selected'");%>><%=st.getValue()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value='<%=model.getSelectQuestionType()%>'
				id="questionType" name="questionType" />
		</div>
		<div class="col-md-2 text-center">
			<label for="difficultPointSel">难度：</label> <select
				class="form-control" style="width:60%;" id="difficultPointSel"
				name="difficultPoint">
				<%
					for (EDifficultyPoint et : EDifficultyPoint.values()) {
				%>
				<option value="<%=et.getValue()%>"><%=et.getValue()%></option>
				<%
					}
				%>
			</select>
		</div>

		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="query()">查询</button>
		</div>
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="addUser()">添加</button>
		</div>
	</div>
</form>
<%
	if (questionType.equals(EQuestionType.QChoice.getKey())) {
%>
<jsp:include page="questionChoice.jsp" />
<%
	} else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
%>
<jsp:include page="questionCompletion.jsp" />
<%
	} else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
%>
<jsp:include page="questionTrueOrFalse.jsp" />
<%
	} else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
%>
<jsp:include page="questionSAQ.jsp" />
<%
	}
%>

<script type="text/javascript">
	function questionTypeChange(str) {
		$("#questionType").val(str);
	}
	function query() {
		var params = serializeForm('queryFormQuestion');
		loadDataByGet("<%=basePath%>
	" + "questionList?" + params,
				"questionList");
	}
</script>
