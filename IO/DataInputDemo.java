package IO;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;

public class DataInputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "DataOutputStreamFile.txt");
		DataInputStream in = new DataInputStream(new FileInputStream(file));
		int index = 0;
		int len = 0;
		char[] temp = null;
		String s1, s2, s3;
		char c = 0;
		char[] b = new char[1024];
		StringBuilder sb = new StringBuilder();
		while (c!=-1) {
			temp = new char[200];
			len = 0;
			while ((c = in.readChar()) != '\t') {//readChar 以什么格式写进去，以什么格式读出来
				temp[len] = c;
				len++;
			}
			s1 = new String(temp, 0, len);
			System.out.println(s1);
			System.out.println(in.readInt());
			in.readChar();
			System.out.println(in.readChar());
			
		}
	}

}
