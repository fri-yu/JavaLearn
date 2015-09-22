package IO;

import java.io.File;

public class ChargeDir {
	public static void main(String[] ar) {
		File file = new File("D:\\JavaFile\\Test.txt");
		System.out.println(file.isDirectory());
	}
}
