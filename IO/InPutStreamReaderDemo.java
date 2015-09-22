package IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class InPutStreamReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "fileWriterUseOutputStreamWriterFile.txt");
		Reader reader = new InputStreamReader(new FileInputStream(file));//InputStreamReader将字节流转换成字符流
		int temp = 0;
		StringBuilder sb = new StringBuilder();
		while ((temp = reader.read()) != -1) {
			sb.append((char) temp);
		}
		reader.close();
		System.out.println(sb.toString());
	}

}
