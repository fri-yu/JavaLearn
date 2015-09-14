class ThreadName 
{
	public static void main(String[] args) 
	{
		RDemo r=new RDemo();
		new Thread(r,"01").start();
		new Thread(r,"02").start();
		new Thread(r,"03").start();
		new Thread(r,"04").start();
		System.out.println("Hello World!");
		System.out.println(Thread.currentThread().getName());//main函数的进程名为“main”
}
}
class RDemo implements Runnable
{
	public void run()
	{
	System.out.println(Thread.currentThread().getName());//new Thread(runnable,ThreadName) 指定thread的名字
	}
}