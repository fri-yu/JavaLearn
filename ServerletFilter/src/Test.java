import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		Session session = HibernateUtil.getCurrentSession();
		System.out.println(session);
	}
}
