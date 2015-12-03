package com.demo.util;

public enum EQuestionType {

	QChoice("Choice","选择题"),QCompletion("Completion","填空题"),QTrueOrFalse("TrueOrFalse","判断题"),QSAQ("SAQ","简答题");
	private String value;
	private String key;
	public String getKey() {
		return key;
	}
	public String getValue() {
		return value;
	}
	private EQuestionType(String key,String value)
	{
		this.key=key;
		this.value=value;
	}
}
