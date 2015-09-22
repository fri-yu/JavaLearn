package IO;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;

public class FileReaderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args)  throws Exception {
		// TODO Auto-generated method stub
		File file = new File("D:" + File.separator + "JavaFile"
				+ File.separator + "fileWriterFile.txt");
		Reader r=new FileReader(file);
		StringBuilder sbBuilder=new StringBuilder();
		int temp=0;
		while((temp=r.read())!=-1)
		{
			sbBuilder.append((char)temp);
		}
		System.out.println(sbBuilder.toString());
	}

}
