package com.demo.domain;

/**
 * QuestionrsShortanswer entity. @author MyEclipse Persistence Tools
 */

public class QuestionrsShortanswer implements java.io.Serializable {

	// Fields

	private Integer hiloId;
	private Integer saqid;
	private Integer questionId;

	// Constructors

	/** default constructor */
	public QuestionrsShortanswer() {
	}

	/** full constructor */
	public QuestionrsShortanswer(Integer saqid, Integer questionId) {
		this.saqid = saqid;
		this.questionId = questionId;
	}

	// Property accessors

	public Integer getHiloId() {
		return this.hiloId;
	}

	public void setHiloId(Integer hiloId) {
		this.hiloId = hiloId;
	}

	public Integer getSaqid() {
		return this.saqid;
	}

	public void setSaqid(Integer saqid) {
		this.saqid = saqid;
	}

	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

}