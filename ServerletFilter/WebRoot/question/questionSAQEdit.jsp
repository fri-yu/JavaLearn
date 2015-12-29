<%@page import="com.demo.domain.Question"%>
<%@page import="com.demo.util.EQuestionType"%>
<%@page import="com.demo.util.EDifficultyPoint"%>
<%@page import="com.demo.viewModel.ShortAnswerQuestionModel"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<base href="<%=basePath%>">
<% 
Cookie cookies[]=request.getCookies(); 
Cookie sCookie=null; 
String backUrl=request.getAttribute("backUrl").toString();
%>
<%
	ShortAnswerQuestionModel model = (ShortAnswerQuestionModel) request
	.getAttribute("model");
	if (model != null) {
%><div class="modal-dialog" role="document">
	<div class="modal-content">
		<form class="form-horizontal" id="questionEditForm">
			<div class="modal-header">
				
				<h4 class="modal-title" id="myModalLabel">添加简答题</h4>
			</div>
			<div class="modal-body" id="modelContent">
				<div class="form-group">
					<label class="col-sm-2 control-label">题干</label>
					<div class="col-sm-10">
						<input class="form-control" id="" placeholder="题干" name="qContent" value='<%=model.getContent().getContent()%>' />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-2 control-label"></label>
					<div class="col-sm-10">
						<button type="button" class="btn btn-info">添加问题</button>
					</div>
				</div>
				<div class="clear"></div>
				<%
					List<Question> qList = model.getQuestions();
							if(null!=qList&&qList.size()>0){
							for(Question q:qList){
				%>
				<div class="table-responsive">
					<table class="table table-striped table-bordered">
						<tr>
							<td>题干</td>
							<td>答案</td>
							<td>操作</td>
						</tr>
						<tr>
							<td><%=q.getContent()%></td>
							<td><%=q.getAnswer()%></td>
							<td><a href='#' onclick="myLoad('userEdit?cid=<%=q.getId()%>')">编辑</a>| <a href='#'
								onclick="del('userDel?cid=<%=q.getId()%>');">删除</a>
							</td>
						</tr>

					</table>
				</div>
				<%
					} 
						}
				%>
				<div class="form-group">
					<label class="col-sm-2 control-label">难度</label>
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

			</div>
			<div class="modal-footer">
				<input type="hidden" name="hiloId" value="<%=request.getAttribute("hiloId")%>" /> <input type="hidden"
					name="questionType" value="<%=request.getAttribute("questionType")%>" />
				<button type="button" class="btn btn-default" onclick="myRet()">返回</button>
				<button type="button" class="btn btn-primary" onclick="pageSave('<%=EQuestionType.QSAQ.getKey()%>')">保存</button>
			</div>
		</form>
	</div>
	<%
		}
	%>
</div>
<script type="text/javascript">
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
	function myRet(){
		loadDataByGet('<%=backUrl%>', "questionList");
	}
</script>

