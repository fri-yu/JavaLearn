package com.demo.domain;

/**
 * QuestionTrueorfalse entity. @author MyEclipse Persistence Tools
 */

public class QuestionTrueorfalse implements java.io.Serializable {

	// Fields

	private Integer hiloId;
	private String content;
	private String answer;
	private String difficultyPoint;

	// Constructors

	/** default constructor */
	public QuestionTrueorfalse() {
	}

	/** full constructor */
	public QuestionTrueorfalse(String content, String answer,
			String difficultyPoint) {
		this.content = content;
		this.answer = answer;
		this.difficultyPoint = difficultyPoint;
	}

	// Property accessors

	public Integer getHiloId() {
		return this.hiloId;
	}

	public void setHiloId(Integer hiloId) {
		this.hiloId = hiloId;
	}

	public String getContent() {
		return this.content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getDifficultyPoint() {
		return this.difficultyPoint;
	}

	public void setDifficultyPoint(String difficultyPoint) {
		this.difficultyPoint = difficultyPoint;
	}

}