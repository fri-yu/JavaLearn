class TicketDemo2 
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
多个线程使用同一个锁
这里演示一个错误的示例
*/

class Ticket2 implements Runnable
{
	private int count=100;
	boolean flag=true;
	Object obj=new Object();
	public  void run()
	{
		if(flag)
		{
		while(count>0){
			synchronized(obj)//synchronized(this) 如果obj改成this就可以保证线程的安全，因为非静态synchronized 同步函数使用的对象为this
			{
			if(count>0){
				try{Thread.sleep(10);}catch(Exception e){}
				System.out.println(Thread.currentThread().getName()+"..."+count--);
			}
			}
		}
		}
		else
		{
			while(count>0){
				method();//这里注意，同步函数同步的内容，需要严格判断
			}
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
