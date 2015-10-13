package a.b.m;

public class CopyOfUser {
	private User u;
	public User getU() {
		return u;
	}
	public void setU(User u) {
		this.u = u;
	}
	@Override
	public String toString() {
		return "userName:" + u.getName() + " age:" + u.getAge();

	}
}
