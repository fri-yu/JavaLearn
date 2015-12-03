package com.demo.domain;

/**
 * QuestionId entity. @author MyEclipse Persistence Tools
 */

public class QuestionId implements java.io.Serializable {

	// Fields

	private Integer id;
	private String content;
	private String answer;

	// Constructors

	/** default constructor */
	public QuestionId() {
	}

	/** full constructor */
	public QuestionId(Integer id, String content, String answer) {
		this.id = id;
		this.content = content;
		this.answer = answer;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof QuestionId))
			return false;
		QuestionId castOther = (QuestionId) other;

		return ((this.getId() == castOther.getId()) || (this.getId() != null
				&& castOther.getId() != null && this.getId().equals(
				castOther.getId())))
				&& ((this.getContent() == castOther.getContent()) || (this
						.getContent() != null && castOther.getContent() != null && this
						.getContent().equals(castOther.getContent())))
				&& ((this.getAnswer() == castOther.getAnswer()) || (this
						.getAnswer() != null && castOther.getAnswer() != null && this
						.getAnswer().equals(castOther.getAnswer())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getId() == null ? 0 : this.getId().hashCode());
		result = 37 * result
				+ (getContent() == null ? 0 : this.getContent().hashCode());
		result = 37 * result
				+ (getAnswer() == null ? 0 : this.getAnswer().hashCode());
		return result;
	}

}