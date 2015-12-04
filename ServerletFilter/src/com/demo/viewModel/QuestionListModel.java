package com.demo.viewModel;

import java.util.List;

import javax.swing.ListModel;

import com.demo.domain.Paper;
import com.demo.domain.QuestionChoice;
import com.demo.domain.QuestionCompletion;
import com.demo.domain.QuestionTrueorfalse;

public class QuestionListModel extends VModelBase {

	private String selectQuestionType;
	private String selectDiffcultyPoint;

	private List<QuestionChoice> qCList;
	private List<QuestionCompletion> qComList;
	private List<QuestionTrueorfalse> qTList;
	private List<ShortAnswerQuestionModel> sAQList;

	public String getSelectQuestionType() {
		return selectQuestionType;
	}

	public void setSelectQuestionType(String selectQuestionType) {
		this.selectQuestionType = selectQuestionType;
	}

	public String getSelectDiffcultyPoint() {
		return selectDiffcultyPoint;
	}

	public void setSelectDiffcultyPoint(String selectDiffcultyPoint) {
		this.selectDiffcultyPoint = selectDiffcultyPoint;
	}

	public List<QuestionChoice> getqCList() {
		return qCList;
	}

	public void setqCList(List<QuestionChoice> qCList) {
		this.qCList = qCList;
	}

	public List<QuestionCompletion> getqComList() {
		return qComList;
	}

	public void setqComList(List<QuestionCompletion> qComList) {
		this.qComList = qComList;
	}

	public List<QuestionTrueorfalse> getqTList() {
		return qTList;
	}

	public void setqTList(List<QuestionTrueorfalse> qTList) {
		this.qTList = qTList;
	}

	public List<ShortAnswerQuestionModel> getsAQList() {
		return sAQList;
	}

	public void setsAQList(List<ShortAnswerQuestionModel> sAQList) {
		this.sAQList = sAQList;
	}
}
