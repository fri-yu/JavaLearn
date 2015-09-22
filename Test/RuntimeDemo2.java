class RuntimeDemo2 
{
	public static void main(String[] args) 
	{
		Runtime r=Runtime.getRuntime();
		Process p=null;
		try{
		p=r.exec("notepad.exe");
		}catch(Exception e)
		{}
		try{
		Thread.sleep(5000);
		}catch(Exception e)
		{}
		p.destroy();
		System.out.println("Hello World!");
	}
}
