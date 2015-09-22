package IO;

import java.io.File;
import java.util.Scanner;

public class ScannerDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// getInt();
		// getFloat();
		readFile();
	}

	static void readFile() {
		File f = new File("D:" + File.separator + "JavaFile" + File.separator
				+ "printStreamFile.txt");
		StringBuilder sb = new StringBuilder();
		try {
			Scanner sc = new Scanner(f);//从文件中读取数据
			while (sc.hasNext()) {
				sb.append(sc.next()).append("-\r\n");//scanner 以空格、回车作为next的分隔符
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println(sb.toString());

	}

	static int getInt() {
		int a = 0;
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入一个整数");
			if (sc.hasNextInt()) {
				a = sc.nextInt();
				flag = false;
				System.out.printf("您输入的是:%d\r\n", a);
			} else {
				System.out.println("您输入的不是一个整数");
			}
		}
		return a;
	}

	static float getFloat() {
		float f = 0;
		boolean flag = true;
		while (flag) {
			Scanner sc = new Scanner(System.in);
			System.out.println("请输入一个小数");
			if (sc.hasNextFloat()) {
				f = sc.nextFloat();
				flag = false;
				System.out.printf("您输入的是:%f\r\n", f);
			} else {
				System.out.println("您输入的不是一个小数");
			}
		}
		return f;
	}

}
