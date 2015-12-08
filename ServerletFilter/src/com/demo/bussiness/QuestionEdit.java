package com.demo.bussiness;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.domain.QuestionChoice;
import com.demo.domain.QuestionCompletion;
import com.demo.domain.QuestionTrueorfalse;
import com.demo.service.PaperService;
import com.demo.util.EQuestionType;

public class QuestionEdit extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doGet(req, resp);
		String dispatcherJsp = getDispatcherJsp(req);

		Object model = GetModel(req);
		req.setAttribute("model", model);
		RequestDispatcher dispatcher = req.getRequestDispatcher(dispatcherJsp);
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		// super.doPost(req, resp);
		this.doGet(req, resp);
	}

	private String getDispatcherJsp(HttpServletRequest req) {
		String questionType = req.getParameter("questionType") == null ? EQuestionType.QChoice
				.getKey() : req.getParameter("questionType").trim();
		if (questionType.equals(EQuestionType.QChoice.getKey())) {
			return "/question/questionChoiceEdit.jsp";
		}
		// 填空题
		else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
			return "/question/questionCompletionEdit.jsp";
		}
		// 判断题
		else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
			return "/question/questionTrueOrFalseEdit.jsp";
		}
		// 简答题
		else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
			return "/question/questionSAQEdit.jsp";
		}
		return "/question/questionErr.jsp";
	}

	private Object GetModel(HttpServletRequest req) {
		Object object = null;
		String questionType = req.getParameter("questionType") == null ? EQuestionType.QChoice
				.getKey() : req.getParameter("questionType").trim();
		Integer hiloId = req.getParameter("hiloId") == null ? 1 : Integer
				.parseInt(req.getParameter("hiloId").trim());

		if (questionType != null) {
			// 选择题
			if (questionType.equals(EQuestionType.QChoice.getKey())) {
				object = PaperService.getObject(QuestionChoice.class, hiloId);

			}
			// 填空题
			else if (questionType.equals(EQuestionType.QCompletion.getKey())) {
				object = PaperService.getObject(QuestionCompletion.class,
						hiloId);
			}
			// 判断题
			else if (questionType.equals(EQuestionType.QTrueOrFalse.getKey())) {
				object = PaperService.getObject(QuestionTrueorfalse.class,
						hiloId);
			}
			// 简答题
			else if (questionType.equals(EQuestionType.QSAQ.getKey())) {
				// object=PaperService.getObject(QuestionTrueorfalse.class,
				// hiloId);
			}
		} else {
			object = PaperService.getObject(QuestionChoice.class, hiloId);

		}
		return object;
	}
}
