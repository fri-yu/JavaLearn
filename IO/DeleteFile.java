package IO;

import java.io.File;

public class DeleteFile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "iofile.txt");
		try {
			file.delete();// 当且仅当成功删除文件或目录时，返回 true；否则返回 false。
							// 删除此抽象路径名表示的文件或目录。如果此路径名表示一个目录，则该目录必须为空才能删除。
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
		}
	}

}
