package a.b.t;

import com.opensymphony.xwork2.ActionSupport;

public class Tag extends ActionSupport {
	private String name;
	private String age;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	@Override
	public String execute() {
		return SUCCESS;
	}

	public Tag() {
		super();
		name="testName";
		age="testAge";
	}
}
