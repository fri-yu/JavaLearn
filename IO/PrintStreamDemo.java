package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class PrintStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File f = new File("D:" + File.separator + "JavaFile" + File.separator
				+ "printStreamFile.txt");
		PrintStream p = new PrintStream(new FileOutputStream(f,true));
		p.print("我爱你");
		p.println("中国");
		p.printf("我是:%s 我喜欢:%s", "java learner","fishing");// %s String %d 整数 %f 小数 %c char字符
		p.close();
	}

}
