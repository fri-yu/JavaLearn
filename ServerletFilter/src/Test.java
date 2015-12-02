import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;

import com.demo.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		// Session session = HibernateUtil.getCurrentSession();
		// System.out.println(session);
		// List<String> arr=new ArrayList<String>();
		// method(arr);
		// System.out.println(arr.hashCode());
		MyRegex_3("");
	}

	static void method(List<String> arr) {

		System.out.println(arr.hashCode());
	}

	static void MyRegex_3(String regexRule) {

		Pattern pattern = Pattern.compile("pageSize=[0-9]&?");
		Matcher matcher = pattern
				.matcher("myPage('userList?&pageSize=5&currentPage= 4");
		// 替换第一个符合正则的数据
		String string = matcher.replaceAll("");
		 pattern = Pattern.compile("&currentPage=[/s]?[0-9]?");
		 matcher = pattern
				.matcher(string);
		// 替换第一个符合正则的数据
		string = matcher.replaceAll("");
		System.out.println(string);
	}
}
