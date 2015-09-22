class RuntimeDemo 
{
	public static void main(String[] args) 
	{
		Runtime r=Runtime.getRuntime();
		System.out.println(r.maxMemory());
		System.out.println(r.freeMemory());
		System.out.println("Hello World!");
		String str="1"+"2"+"3";
		String str2="";
		for(int i=0;i<5000;i++)
		{str2+=str;}
		System.out.println(r.maxMemory());
		System.out.println(r.freeMemory());
		System.out.println(str2.leng);
		System.out.println(r.freeMemory());
	}
}
