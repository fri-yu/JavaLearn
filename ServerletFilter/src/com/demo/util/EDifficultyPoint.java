package com.demo.util;
/**
 * 
 * @author Administrator
 *�Ѷ�ϵ��
 */
public enum EDifficultyPoint {
	Point9("0.9"),Point8("0.8"),Point7("0.7"),Point6("0.6"),Point5("0.5"),Point4("0.4"),Point3("0.3"),Point2("0.2"),Point1("0.1");
	private String value;

	private EDifficultyPoint(String value) {
		this.value = value;
	}

	public String getValue() {
		return this.value;

	}
}
