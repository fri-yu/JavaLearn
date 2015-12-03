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
		String questionType = req.getParameter("questionType");
		model.setSelectQuestionType(questionType);
		queryString = "questionType=" + questionType;
		int pageCount = 0;
		int pageSize = req.getParameter("pageSize") == null ? 5 : Integer
				.parseInt(req.getParameter("pageSize").trim());// 默认每页10条
		int currentPage = req.getParameter("currentPage") == null ? 1 : Integer
				.parseInt(req.getParameter("currentPage").trim());// 默认第一页
		if (questionType != null) {
			if (questionType.equals(EQuestionType.QChoice.getKey())) {
				List<QuestionChoice> cList = new ArrayList<QuestionChoice>();
				pageCount = BaseService.getList(pageSize, currentPage, cList,
						" QuestionChoice ", "", null);
				model.setqCList(cList);
			} else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
				List<QuestionCompletion> cList = new ArrayList<QuestionCompletion>();
				pageCount = BaseService.getList(pageSize, currentPage, cList,
						" QuestionCompletion ", "", null);
				model.setqComList(cList);
			} else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
				List<QuestionTrueorfalse> cList = new ArrayList<QuestionTrueorfalse>();
				pageCount = BaseService.getList(pageSize, currentPage, cList,
						" QuestionTrueorfalse ", "", null);
				model.setqTList(cList);
			} else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
				List<QuestionShortanswer> cList = new ArrayList<QuestionShortanswer>();
				pageCount = BaseService.getList(pageSize, currentPage, cList,
						" QuestionShortanswer ", "", null);
				//model.setsAQList(cList);
			}
		} else {
			model.setSelectQuestionType("Choice");
			queryString = "questionType=Choice";
		}
		model.setPageCount(pageCount);
		model.setPageLinkDic(PagerUtil.getPagerMap(pageCount, currentPage,
				pageSize, queryString));
		return model;
	}

}
