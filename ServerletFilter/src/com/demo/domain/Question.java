package com.demo.domain;

/**
 * Question entity. @author MyEclipse Persistence Tools
 */

public class Question implements java.io.Serializable {

	// Fields

	private QuestionId id;

	// Constructors

	/** default constructor */
	public Question() {
	}

	/** full constructor */
	public Question(QuestionId id) {
		this.id = id;
	}

	// Property accessors

	public QuestionId getId() {
		return this.id;
	}

	public void setId(QuestionId id) {
		this.id = id;
	}

}