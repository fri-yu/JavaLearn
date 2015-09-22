class ThreadStart
{
	public static void main(String[] args){
		TDemo t=new TDemo();
		t.start();
		while(true)
		{
/*try{	Thread.sleep(1000);}catch(Exception e){}*/
/*if(!t.isAlive())
			{
System.out.println(t.getState() );
System.out.println(t.isAlive());
break;
			}
		}
		*/
		//t.start();//多次start会抛异常 CSDN上的解释，线程属于一次性资源，使用完后就被回收，无法重新开启，需要使用new来重新创建然后start
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
