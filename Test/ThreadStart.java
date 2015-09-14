class ThreadStart
{
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
/*try{	Thread.sleep(1000);}catch(Exception e){}
System.out.println(t.getState() );*/
		//t.start();//多次start会抛异常
		System.out.println("Hello World!");
	}
}
class TDemo extends Thread
{
	public  void run() 
	{
		System.out.println("Hello Thread");
	}
	/*可以正常编译运行的*/
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
		//t.start();
		System.out.println("Hello World!");
	}
}
