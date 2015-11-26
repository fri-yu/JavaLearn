import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
//		Session session = HibernateUtil.getCurrentSession();
//		System.out.println(session);
		List<String> arr=new ArrayList<String>();
		method(arr);
		System.out.println(arr.hashCode());
	}
	static void method(List<String> arr)
	{
		
		System.out.println(arr.hashCode());
	}
}
