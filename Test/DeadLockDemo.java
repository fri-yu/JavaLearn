class DeadLockDemo 
{
	public static void main(String[] args) 
	{
		Ticket2 t=new Ticket2();
		Thread t1=new Thread(t);
		Thread t2=new Thread(t);

		t1.start();
			try{Thread.sleep(10);}catch(Exception e){}
			t.flag=false;
		t2.start();

	}
}
/*
死锁。同步中嵌套同步

*/

class Ticket2 implements Runnable
{
	private static int count=100;
	boolean flag=true;
	Object obj=new Object();
	public  void run()
	{
		if(flag)
		{
		while(count>0){
			synchronized(obj)
			{
				method();
			}
		}
		}
		else
		{
			while(count>0){
				method();
			}
		}
	
	}
	private synchronized  void method()
	{
			synchronized(obj)
			{
		if(count>0){
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(Thread.currentThread().getName()+"..."+count--);
		}	
			}
	}
}


