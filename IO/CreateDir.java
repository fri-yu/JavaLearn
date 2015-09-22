package IO;

import java.io.File;

public class CreateDir {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile");
		// file.mkdir();//创建目录
		String[] fStrings = file.list();// 获取目录下的所有文件信息，文件+文件夹，只展示名称
		for (String s : fStrings) {
			// System.out.println(s);

		}
		File[] files = file.listFiles();// 获取目录下的所有文件信息，文件+文件夹，展示完整路径
		for (File s : files) {
			System.out.println(s);//File.toString 覆写的是 实现自身的getPath方法
			System.out.println(s.getPath());//

		}
	}

}
