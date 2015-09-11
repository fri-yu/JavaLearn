class StringTest 
{
	public static void main(String[] args) 
	{
		String str1="string";
		String str2=new String("string");
		String str3="string";
		String str4=str2;
		System.out.println("str1==str2-¡·"+(str1==str2));//f
		System.out.println("str1==str3-¡·"+(str1==str3));//t
		System.out.println("str1==str4-¡·"+(str1==str4));//f
		System.out.println("str2==str4-¡·"+(str2==str4));//t
		System.out.println("----------------");
		System.out.println("str1 equals str2-¡·"+(str1.equals(str2)));//t
		System.out.println("str1 equals str3-¡·"+(str1.equals(str3)));//t
		System.out.println("str1 equals str4-¡·"+(str1.equals(str4)));//t

		System.out.println("Hello World!");
	}
}
