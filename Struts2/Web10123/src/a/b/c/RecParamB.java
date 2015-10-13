package a.b.c;

import a.b.m.User;

import com.opensymphony.xwork2.ActionSupport;

public class RecParamB extends ActionSupport {
	@Override
	public String execute() {
		return SUCCESS;
	}

	private User user;
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String add() {
		System.out.println("name:" + user.getName());
		System.out.println("age:" + user.getAge());
		return "B";
	}
}
