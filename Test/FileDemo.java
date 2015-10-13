import java.io.File;
class  FileDemo
{
	public static void main(String[] args) 
	{
		File f=new File("D:\\TEST.TXT");
		try{
		f.createNewFile();
		}
		catch(Exception e){
			System.out.println("Some exception happened");
		}
		System.out.println("Hello World!");
		System.out.println("该操作系统的文件夹路径分隔符:"+File.separator);
		//File f2=new File("D:\\TEST");
		System.out.println(f.mkdir());//文件夹创建是否成功
		File f3=new File("D:\\");
		/*String str[]=f3.list();//获取文件夹下的所有内容（文件夹 + 文件 的名称）
		for(int i =0;i<str.length;i++)
		{System.out.println(str[i]);//
		}*/
		/*File str[]=f3.listFiles();//获取文件夹下的所有内容（文件夹 + 文件 ） File.toString 重载为 File.getPath()
		for(int i =0;i<str.length;i++)
		{System.out.println(str[i]);//
		}*/
	}
}
