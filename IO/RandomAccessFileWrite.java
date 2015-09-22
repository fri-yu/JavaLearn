package IO;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileWrite {

	public static void main(String[] args) throws Exception{
		File file=new File("D:"+File.separator+"JavaFile"+File.separator+"randomAccess.txt");
		
			RandomAccessFile rdf=new RandomAccessFile(file, "rw");
			rdf.writeBytes("abcdefghij");
			rdf.writeBytes("ABCDEFGHIJ");
			rdf.writeInt(1111);
			rdf.writeInt(1111);
			rdf.close();
		
		}
}
