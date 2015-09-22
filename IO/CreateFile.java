package IO;

import java.io.File;

public class CreateFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File f = new File("D:\\IOFile.txt");
		File f2 = new File("D:" + File.separator + "IOFile.txt");
		try {
			f.createNewFile();
			f2.createNewFile();// 当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。检查文件是否存在，若不存在则创建该文件
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
