package com.demo.bussiness;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ListModel;

import com.demo.domain.QuestionChoice;
import com.demo.domain.QuestionCompletion;
import com.demo.domain.QuestionShortanswer;
import com.demo.domain.QuestionTrueorfalse;
import com.demo.service.BaseService;
import com.demo.util.EQuestionType;
import com.demo.util.PagerUtil;
import com.demo.viewModel.QuestionListModel;
import com.demo.viewModel.ShortAnswerQuestionModel;

public class QuestionList extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		req.setAttribute("model", initModel(req));
		RequestDispatcher dispatcher = req
				.getRequestDispatcher("/question/questionList.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}

	private Object initModel(HttpServletRequest req) {
		// TODO Auto-generated method stub
		QuestionListModel model = new QuestionListModel();
		String queryString = "";
		String questionType = req.getParameter("questionType").trim();
		model.setSelectQuestionType(questionType);
		// 查询参数
		queryString = "&questionType=" + questionType;
		String selectDiffcultyPoint = "";
		String sqlWhere = "";
		List<String> params = new ArrayList<String>();
		if (null != req.getParameter("difficultyPoint")
				&& !"".equals(req.getParameter("difficultyPoint").trim())) {
			selectDiffcultyPoint = req.getParameter("difficultyPoint").trim();
			sqlWhere = " and difficultyPoint=? ";
			queryString += " &difficultyPoint=" + selectDiffcultyPoint;
			params.add(selectDiffcultyPoint);

		}
		sqlWhere += " Order by hiloid desc";
		// 分页参数
		int pageCount = 0;
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(req.getParameter("pageSize").trim());// 默认每页10条
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage").trim());// 默认第一页
		if (questionType != null) {
			// 选择题
			if (questionType.equals(EQuestionType.QChoice.getKey())) {
				List<QuestionChoice> cList = new ArrayList<QuestionChoice>();
				pageCount = BaseService.getPagerList(pageSize, currentPage, cList,
						" QuestionChoice ", sqlWhere, params);
				model.setqCList(cList);

			}
			// 填空题
			else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
				List<QuestionCompletion> cList = new ArrayList<QuestionCompletion>();
				pageCount = BaseService.getPagerList(pageSize, currentPage, cList,
						" QuestionCompletion ", sqlWhere, params);
				model.setqComList(cList);
			}
			// 判断题
			else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
				List<QuestionTrueorfalse> cList = new ArrayList<QuestionTrueorfalse>();
				pageCount = BaseService.getPagerList(pageSize, currentPage, cList,
						" QuestionTrueorfalse ", sqlWhere, params);
				model.setqTList(cList);
			}
			// 简答题
			else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
				List<QuestionShortanswer> cList = new ArrayList<QuestionShortanswer>();
				pageCount = BaseService.getPagerList(pageSize, currentPage, cList,
						" QuestionShortanswer ", sqlWhere, params);
				sqlWhere = "";
				if (cList.size() > 0) {
					StringBuilder sBuilder = new StringBuilder();
					sBuilder.append(" (");
					for (QuestionShortanswer saq : cList) {

						sBuilder.append(saq.getHiloId() + ", ");
					}
					sBuilder.setLength(sBuilder.length());
					sBuilder.append(" ) ");
					System.out
							.println("SAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQSAQ");
					System.out.println(sBuilder.toString());
				}
				List<ShortAnswerQuestionModel> mList=new 
						ArrayList<ShortAnswerQuestionModel>();
				 model.setsAQList(mList);
			}
		} else {
			model.setSelectQuestionType("Choice");
			queryString = "questionType=Choice";
		}
		model.setSelectDiffcultyPoint(selectDiffcultyPoint);
		model.setCurrentPage(currentPage);
		model.setPageCount(pageCount);
		model.setPageLinkDic(PagerUtil.getPagerMap(pageCount, currentPage,
				pageSize, queryString));
		return model;
	}

}
