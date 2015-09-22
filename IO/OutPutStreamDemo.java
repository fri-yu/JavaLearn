package IO;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class OutPutStreamDemo {
	public static void main(String[] args) throws Exception {
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "outPutStreamFile.txt");
		// OutputStream o = new FileOutputStream(file);
		OutputStream o = new FileOutputStream(file, true);// 可以向原文件中追加
		o.write("-我爱你".getBytes());
		//o.flush();/*stream 字节流，即使不使用flush 或者close 字节数据依旧可以存入文件中*/
		// o.close();
		System.out.println("done");
	}
}
