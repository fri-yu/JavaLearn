package a.b.m;

public class User {
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

	public User(String name, String age) {
		super();
		this.name = name;
		this.age = age;
	}

	public User() {
	}// 空的构造函数，一定不能省，否则无法创建对象

	@Override
	public String toString() {
		return "userName:" + name + " age:" + age;

	}
}
