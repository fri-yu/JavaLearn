package IO;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

public class DataOutputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "DataOutputStreamFile.txt");
		DataOutputStream out = new DataOutputStream(new FileOutputStream(file));
		String[] s1 = { " È", "±æ", "± " };
		int[] s2 = { 20, 10, 2};
		String[] s3 = { "2", "1", "2" };
		for (int i = 0; i < 3; i++) {
			out.writeChars(s1[i]);
			out.writeChar('\t');
			out.writeInt(s2[i]);
			out.writeChar('\t');
			out.writeChars(s3[i]);
			out.writeChar('\t');
			out.writeChar('\n');
		}
		out.close();
	}

}
