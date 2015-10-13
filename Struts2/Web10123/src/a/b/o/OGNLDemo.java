package a.b.o;

import java.util.*;

import a.b.m.Cat;
import a.b.m.CopyOfUser;
import a.b.m.User;

import com.opensymphony.xwork2.ActionSupport;

public class OGNLDemo extends ActionSupport {
	private String name;
	private String psd;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPsd() {
		return psd;
	}

	public void setPsd(String psd) {
		this.psd = psd;
	}

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

	public Cat getCat() {
		return cat;
	}

	public void setCat(Cat cat) {
		this.cat = cat;
	}

	private Cat cat;

	public String met() {
		return "这是action的普通方法";

	}

	private List<User> users = new ArrayList<User>();

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public OGNLDemo() {
		super();
		users.add(new User("zhangsan", "12"));
		users.add(new User("lisi", "13"));
		users.add(new User("wangwu", "14"));
		seU.put("s1", users.get(0));
		seU.put("s2", users.get(1));
		seU.put("s3", users.get(2));
	}

	public Map<String, User> getSeU() {
		return seU;
	}

	public void setSeU(Map<String, User> seU) {
		this.seU = seU;
	}

	public Map<String, User> seU = new TreeMap<String, User>();
}
