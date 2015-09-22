package IO;

import java.io.ByteArrayInputStream;
import java.io.PushbackInputStream;

public class PushBackStreamDemo {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String str = "123456.654321";
		ByteArrayInputStream b = new ByteArrayInputStream(str.getBytes());
		PushbackInputStream p = null;
		p = new PushbackInputStream(b);
		int temp = 0;
		while ((temp = p.read()) != -1) {
			if (temp != '.') {
				System.out.print((char) temp);
			} else {
				p.unread(temp);
				temp = p.read();
				System.out.println("");
				System.out.println((char) temp);
				// break;
			}
		}
		p.close();
	}

}
