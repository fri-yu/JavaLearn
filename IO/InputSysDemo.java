package IO;

import java.io.IOException;
import java.io.InputStream;

public class InputSysDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		InputStream in = System.in;
		byte[] b = new byte[6];
		int a = 0;
		try {
			a = in.read(b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(new String(b, 0, a));
		System.out.println(a);

	}
}
