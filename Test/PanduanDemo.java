class PanduanDemo 
{
	public static void main(String[] args) 
	{
		Object o1=new Object();
		Object o2=new Object();
		System.out.println("o1==o2?--" + (o1==o2 ));//f 默认比较的是地址
		System.out.println("o1 equals o2?--"+o1.equals(o2));//f Object 基类的默认equals方法与“==”一致，都是比较地址
	}
}
