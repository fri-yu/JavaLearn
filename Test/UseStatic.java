class UseStatic 
{
	public static void main(String[] args) 
	{
		Person p1=new Person();
		System.out.println(p1.country);
		Person p2=new Person();
		System.out.println(p1.country);
		p2.country="eg";
		System.out.println(p1.country);
		System.out.println(p2.country);

		System.out.println("Hello World!");
	}
}
class Person
{
	static String country="CN";
}
