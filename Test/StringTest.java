class StringTest 
{
	public static void main(String[] args) 
	{
		String str1="string";
		String str2=new String("string");
		String str3="string";
		String str4=str2;
		System.out.println("str1==str2-¡·"+(str1==str2));
		System.out.println("str1==str3-¡·"+(str1==str3));
		System.out.println("str1==str4-¡·"+(str1==str4));
		System.out.println("str2==str4-¡·"+(str2==str4));
		System.out.println("----------------");

		System.out.println("Hello World!");
	}
}
