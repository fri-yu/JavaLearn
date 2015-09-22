package IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadTypeIn {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a = ReadCode.getInt("请输入一个数字", "输入的不是一个数字");
		System.out.printf("你输入的数字是：%d \r\n", a);

	}

}

class ReadCode {
	static BufferedReader bf = new BufferedReader(new InputStreamReader(
			System.in));

	static String getString(String tip) {
		System.out.println(tip);
		String str = null;
		try {
			str = bf.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return str;
	}

	static int getInt(String tip, String warnTip) {

		int returnInt = 0;
		boolean flag = true;
		while (flag) {
			String typeStr = getString(tip);
			if (typeStr != null) {
				if (typeStr.matches("^\\d+$")) {
					returnInt = Integer.parseInt(typeStr);
					flag = false;
				} else
					System.out.println(warnTip);
			}

		}
		return returnInt;

	}

}
