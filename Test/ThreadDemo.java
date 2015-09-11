class ThreadDemo 
{
	public static void main(String[] args) 
	{
	MyThread t=new MyThread();
//	t.run(); 与start方法的区别:run是顺序执行，start另起一个线程执行
t.start();
	for(int i=0;i<500;i++)
		System.out.println("Hello main"+i);
	}
}
class MyThread extends Thread
{
	public void run()
	{
		for(int i=0;i<500;i++)
		System.out.println("Hello World!"+i);
	}
}