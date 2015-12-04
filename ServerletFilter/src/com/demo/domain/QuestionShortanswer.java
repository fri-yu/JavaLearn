package com.demo.domain;

/**
 * QuestionShortanswer entity. @author MyEclipse Persistence Tools
 */

public class QuestionShortanswer implements java.io.Serializable {

	// Fields

	private Integer hiloId;
	private String content;
	private String difficultyPoint;

	// Constructors

	/** default constructor */
	public QuestionShortanswer() {
	}

	/** full constructor */
	public QuestionShortanswer(String content, String difficultyPoint) {
		this.content = content;
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

	public String getDifficultyPoint() {
		return this.difficultyPoint;
	}

	public void setDifficultyPoint(String difficultyPoint) {
		this.difficultyPoint = difficultyPoint;
	}

}