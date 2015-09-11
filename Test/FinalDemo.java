class FinalDemo extends Final1
{
	final int a=0;
	public static void main(String[] args) 
	{

		System.out.println("Hello World!");
		new FinalDemo().pri();
		/*final类型的变量无法再次赋值		new FinalDemo().a=1;*/
	}
	void pri()
	{
		System.out.println("FinalDemo method ");
	}
}
class Final1
{
	private final  void pri()
	{
		System.out.println("a final method ");
	}
    /*这个是编译不通过的 与private不同，如果写了private 那么子类中的相同名称的方法为子类单独创建的，不是覆写（方法覆盖）
	final  void pri()
	{
		System.out.println("a final method ");
	}
	*/

}
