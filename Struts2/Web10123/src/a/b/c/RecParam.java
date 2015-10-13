package a.b.c;

import com.opensymphony.xwork2.ActionSupport;

public class RecParam extends ActionSupport {
	@Override
	public String execute() {
		return SUCCESS;
	}

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

	public String add() {
		System.out.println("name:" + this.name);
		System.out.println("age:" + this.age);
		return "a";
	}
}
