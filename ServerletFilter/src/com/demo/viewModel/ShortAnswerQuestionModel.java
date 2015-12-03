package com.demo.viewModel;

import java.util.List;

import com.demo.domain.*;

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
}
