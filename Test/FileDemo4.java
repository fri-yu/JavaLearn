import java.io.Writer;
import java.io.FileWriter;
import java.io.File;

class FileDemo4 
{
	public static void main(String[] args)  throws Exception
	{
		File f=new File("D:"+File.separator+"useWriter.txt");
		Writer writer=null;
		//writer=new FileWriter(f);
		writer=new FileWriter(f,true);//进行追加
		writer.write("\r\n使用writer写数据，字符流");//\r\n占两个字节，中文的“，”逗号，也占两个字节
		writer.close();
		System.out.println("Hello World!");
	}
}
