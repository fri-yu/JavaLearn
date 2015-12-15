package com.demo.viewModel;

import java.util.List;

import com.demo.domain.*;
/**
 * 简答题视图模型
 * @author Administrator
 *
 */
public class ShortAnswerQuestionModel {
	private QuestionShortanswer Content;
	private List<Question> questions;

	public QuestionShortanswer getContent() {
		return Content;
	}

	public void setContent(QuestionShortanswer content) {
		Content = content;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	public ShortAnswerQuestionModel(QuestionShortanswer content,
			List<Question> questions) {
		super();
		Content = content;
		this.questions = questions;
	}

	public ShortAnswerQuestionModel() {
		super();
	}
	
}
