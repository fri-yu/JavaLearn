<%@ page language="java" import="java.util.*,com.demo.util.*,com.demo.viewModel.QuestionListModel" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
	+ request.getServerName() + ":" + request.getServerPort()
	+ path + "/";
%>
<%
	QuestionListModel model = (QuestionListModel) request
	.getAttribute("model");
	String questionType=model.getSelectQuestionType();
	String selectDiffcultyPoint=model.getSelectDiffcultyPoint();
	//out.print("questionType is "+questionType);
	//out.print(selectDiffcultyPoint);
%>
<form class="form-inline" id="queryFormQuestion">
	<div class="row">
		<div class="col-md-3 text-center">
			<label for="questionTypeSel">题型：</label> <select class="form-control" style="width:60%;" id="questionTypeSel"
				onchange="questionTypeChange(this.value)">
				<%
					for (EQuestionType st : EQuestionType.values()) {
				%>
				<option value="<%=st.getKey()%>" <%if(questionType.equals(st.getKey())) out.print("selected='selected'");%>><%=st.getValue()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value='<%=model.getSelectQuestionType()%>' id="questionType" name="questionType" />
		</div>
		<div class="col-md-3 text-center">
			<label for="difficultPointySel">难度：</label> <select class="form-control" style="width:60%;" id="difficultyPointSel"
				onchange="difficultyPointChange(this.value)">
				<option value="12345">请选择</option>
				<%
					for (EDifficultyPoint et : EDifficultyPoint.values()) {
				%>
				<option value="<%=et.getValue()%>"
					<%if(selectDiffcultyPoint.equals(et.getValue()))  out.print("selected='selected'");%>><%=et.getValue()%></option>
				<%
					}
				%>
			</select> <input type="hidden" value='<%=selectDiffcultyPoint%>' id="difficultyPoint" name="difficultyPoint" />
			<input type="hidden" value='<%=request.getAttribute("backUrl")%>' id="backUrl" name="backUrl" />
		</div>

		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="query('questionList','queryFormQuestion','questionList')">查询</button>
		</div>
		<div class="col-md-1 text-center">
			<button type="button" class="btn btn-default" onclick="addQuestion()">添加</button>
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
$("a").click(function(e) {
		e.preventDefault();
	});
//题型选择被更新时，更新隐藏域数据（用于查询提交）
	function questionTypeChange(str) {
		$("#questionType").val(str);
		$("#difficultyPoint").val('');//清空选择的难度
		$("#difficultyPointSel option:first").attr("selected",true);//难度下拉框选中选项改为“请选择”
		
	}
	//
	function difficultyPointChange(str){
		$("#difficultyPoint").val(str);
	}
	function addQuestion(){
		var params = serializeForm('queryFormQuestion');
		var urlPart="questionEdit?" + params+"&hiloId=-1";
		if($('#questionType').val()=='<%=EQuestionType.QSAQ.getKey()%>'){
			//alert(12345);
			loadDataByGet("<%=basePath%>" + urlPart, "questionList");
		}
		else{
			paperLoadData(urlPart);
			$("#myModal").modal();
		}
	}
	function paperLoadData(urlPart){
		var url="<%=basePath%>" + urlPart;
		loadDataByGet(url, "myModal");
	}
	function editQuestion(url) {
		paperLoadData(url);
		$("#myModal").modal();
	}
	function pageSave(questionType) {
		$('#questionEditForm').bootstrapValidator('validate');
		if (true == $('#questionEditForm').data('bootstrapValidator').isValid()) {
			//alert('aaa');
			$('#myModal').modal('hide');
			myPost('questionEdit?questionType=' + questionType, 'questionEditForm', 'questionList')
		}
	}
	function difficultyPointChange(str) {
		alert(str);
		$("#difficultyPoint").val(str);
	}
</script>
