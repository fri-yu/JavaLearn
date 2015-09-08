class SingleTon 
{
	public static void main(String[] args) 
	{
		Single single1=Single.GetSingle();
		Single single2=Single.GetSingle();
		Single single3=Single.GetSingle();
		System.out.println(single1);
		System.out.println(single2);		
		System.out.println(single3);

		System.out.println("Hello World!");
	}


}
class Single
{
	private static  Single single=new Single();
	public static Single GetSingle()
	{
	return single;
	}
	private Single(){}
}
