class QuanxianDemo 
{
	public static void main(String[] args) 
	{
		System.out.println(new Demo().quanxianStr);
	}
}
/*default权限修饰的类和类成员类方法，均可被同一包名下的其他类访问
不同的包下，即使是继承了该类，也不允许访问
*/
class Demo
{
	String quanxianStr="quanxian";
	int quanxianZhi=0;
	void quanxianMethod(){
		System.out.println("quanxianMethod");
	}
}