<%@page import="com.demo.util.EQuestionType"%>
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
%><div class="modal-content">
	<form class="form-horizontal" id="questionEditForm">
		<div class="modal-header">
			<button type="button" class="close" data-dismiss="modal" aria-label="Close">
				<span aria-hidden="true">&times;</span>
			</button>
			<h4 class="modal-title" id="myModalLabel">添加选择题</h4>
		</div>
		<div class="modal-body" id="modelContent">
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
					<select class="form-control" style="width:60%;" id="difficultyPointSel"
						onchange="difficultyPointChange(this.value)">
						<%
							for (EDifficultyPoint et : EDifficultyPoint.values()) {
						%>
						<option value="<%=et.getValue()%>"><%=et.getValue()%></option>
						<%
							}
						%>
					</select> <input type="hidden" value='<%=EDifficultyPoint.Point9.getValue()%>' id="difficultyPoint" name="difficultyPoint" />
				</div>
			</div>
			<div class="form-group">
				<label for="inputPassword3" class="col-sm-2 control-label">答案</label>
				<div class="col-sm-10">
					<input class="form-control" id="" placeholder="答案" name="qAnswer" value='<%=question.getAnswer()%>' /> <input
						type="hidden" name="hiloId" value="<%=request.getAttribute("hiloId")%>" /> <input type="hidden"
						name="questionType" value="<%=request.getAttribute("questionType")%>" />
				</div>
			</div>
			
		</div>
		<div class="modal-footer">
			<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
			<button type="button" class="btn btn-primary"onclick="pageSave('<%=EQuestionType.QChoice%>')">保存</button>
		</div>
	</form>
</div>
<%
	}
%>
<script type="text/javascript">
	function difficultyPointChange(str) {
		$("#difficultyPoint").val(str);
	}
	$(document).ready(function() {
		$('#questionEditForm').bootstrapValidator({
			//        live: 'disabled',
			message : 'This value is not valid',
			feedbackIcons : {
				valid : 'glyphicon glyphicon-ok',
				invalid : 'glyphicon glyphicon-remove',
				validating : 'glyphicon glyphicon-refresh'
			},
			fields : {
				qContent : {
					validators : {
						notEmpty : {
							message : '题干不能为空'
						}
					}
				},
				optionA : {
					validators : {
						notEmpty : {
							message : 'A选项不能为空'
						}
					}
				},
				optionB : {
					validators : {
						notEmpty : {
							message : 'B选项不能为空'
						}
					}
				},
				optionC : {
					validators : {
						notEmpty : {
							message : 'C选项不能为空'
						}
					}
				},
				optionD : {
					validators : {
						notEmpty : {
							message : 'D选项不能为空'
						}
					}
				},
				qAnswer : {
					validators : {
						notEmpty : {
							message : '答案不能为空'
						}
					}
				}
			}
		});

		$('#resetBtn').click(function() {
			$('#defaultForm').data('bootstrapValidator').resetForm(true);
		});
	});
</script>

