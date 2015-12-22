import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.hibernate.Session;

import sun.launcher.resources.launcher;

import com.demo.domain.*;
import com.demo.util.EDifficultyPoint;
import com.demo.util.EQuestionType;
import com.demo.util.HibernateUtil;

public class Test {
	public static void main(String[] args) {
		// Session session = HibernateUtil.getCurrentSession();
		// System.out.println(session);
		// List<String> arr=new ArrayList<String>();
		// method(arr);
		// System.out.println(arr.hashCode());
		// MyRegex_3("");
		// AddData();
		// Long x=100L;//Long与Integer都将 -128~127 这些对象缓存了。
		// Long y=100L;//Long与Integer都将 -128~127 这些对象缓存了。
		// System.out.println(x==y);
		// System.out.println(x.equals(y));
		// for(EQuestionType st:EQuestionType.values())
		// {
		// System.out.println(st.getValue());
		//
		// }
	}

	private static void AddData() {
		Session session = HibernateUtil.getCurrentSession();
		QuestionChoice cq = new QuestionChoice();
		// cq.setHiloId(234);
		cq.setContent("哪个不是编译型语言");
		cq.setOptionA("java");
		cq.setOptionB("C#");
		cq.setOptionC("C++");
		cq.setOptionD("JavaScript");
		cq.setAnswer("D");
		cq.setDifficultyPoint(EDifficultyPoint.Point9.getValue());
		session.beginTransaction();
		session.save(cq);
		QuestionCompletion qc = new QuestionCompletion();
		qc.setContent(".NET不用主动释放内存是因为()");
		qc.setAnswer("GC|垃圾回收机制");
		qc.setDifficultyPoint(EDifficultyPoint.Point8.getValue());
		session.save(qc);
		session.getTransaction().commit();
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
		matcher = pattern.matcher(string);
		// 替换第一个符合正则的数据
		string = matcher.replaceAll("");
		System.out.println(string);
	}
}
