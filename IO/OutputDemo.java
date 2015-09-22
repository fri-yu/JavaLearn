package IO;

import java.io.IOException;
import java.io.OutputStream;

public class OutputDemo {
	public static void main(String[] args) {
		OutputStream out = System.out;
		try {
			out.write(65);
			out.write("\r\n".getBytes());
			out.write("hello java ".getBytes());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		try {
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
