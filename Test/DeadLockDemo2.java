class DeadLockDemo2
{
	public static void main(String[] args) 
	{
		
		Thread t1=new Thread(new Test(true));
		Thread t2=new Thread(new Test(false));

		t1.start();
		try{Thread.sleep(10);}catch(Exception e){}
		t2.start();

	}
}
/*
死锁。同步中嵌套同步

*/

class Test implements Runnable
{
	private boolean flag=true;
	public Test(boolean flag)
	{
		this.flag=flag;
	}
	static Object oa=new Object();
	static Object ob=new Object();
	public  void run()
	{
		while(true)
		{
			if(flag)
			{
				synchronized(oa)
				{
					System.out.println("true oa");
					synchronized(ob)
					{
						System.out.println("true ob");
					}
				}
			}
			else
			{
				synchronized(ob)
				{
					System.out.println("false ob");
					synchronized(oa)
					{
						System.out.println("false oa");
					}
				}
			}
		}
	}
	
}


