package IO;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

public class FileWriterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "fileWriterFile.txt");
		Writer wr = new FileWriter(file, true);
		wr.write("我爱你中国");
		// wr.flush();/*writer 字符流，不使用flush 或者close 数据无法存入文件中*/
		// wr.close();
		System.out.println("done");
	}

}
