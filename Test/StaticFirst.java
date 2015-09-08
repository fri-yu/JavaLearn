class StaticFirst 
{
	static//静态代码块可以成功执行，并exit。但是如果不声明main方法，是直接抛异常，不会执行静态代码块，与文档里面不一致。
	{
		System.out.println("静态代码块执行了");
		System.exit(1);
	}
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
