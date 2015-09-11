class TicketDemo 
{
	public static void main(String[] args) 
	{
		Ticket2 t=new Ticket2();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);
		Thread t3=new Thread(t);

		t1.start();
		t2.start();
		t3.start();

	}
}
/*
同步的前提：
1.必须两个或两个以上的线程
2.多个线程使用同一个锁

*/
class Ticket implements Runnable
{
	private int count=100;
	Object obj=new Object();
	public  void run()
	{
	while(count>0){
		synchronized(obj)
		{
			//if(!Thread.currentThread().getName().equals("Thread-0"))
			{
		if(count>0){
			try{Thread.sleep(1);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	}}
		}
	}
}
class Ticket2 implements Runnable
{
	private int count=100;
	public  void run()
	{
	while(count>0){
		method();//这里注意，同步函数同步的内容，需要严格判断
		}
	}
	private synchronized  void method()
	{
		
		if(count>0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	
	}
}
