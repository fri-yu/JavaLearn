import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.File;
class FileDemo2 
{
	public static void main(String[] args) throws Exception 
	{
		File f=new File("D:\\IOTest.txt");
		OutputStream out=null;
		//out=new FileOutputStream(f);//直接写入，
		out=new FileOutputStream(f,true);//追加式写入
		String str=" \r\n Hello world";//\r\n 文本换行
		byte[] b=str.getBytes();
		out.write(b);
		//逐字节写入跟直接写入字节数组，效果一样
		/*for(int i=0;i<b.length;i++){
			out.write(b[i]);
		}*/
		out.close();
		System.out.println("Hello World!");
	}
}
