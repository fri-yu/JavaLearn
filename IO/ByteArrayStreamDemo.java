package IO;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class ByteArrayStreamDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String string = "abcdef";
		ByteArrayInputStream inputStream = new ByteArrayInputStream(
				string.getBytes());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		int a = 0;
		while ((a = inputStream.read()) != -1) {
			// outputStream.write((char)a);
			outputStream.write((byte) a);
			outputStream.write("-".getBytes());

		}
		StringBuilder sb = new StringBuilder();
		// while((a=outputStream.read())!=-1)
		// {
		// sb
		//
		// }
		System.out.println(outputStream.toString());
	}

}
