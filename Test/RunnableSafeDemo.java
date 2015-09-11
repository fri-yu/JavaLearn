class  RunnableSafeDemo
{
	public static void main(String[] args) 
	{
		Thread t=new Thread(Ticket.getInstance());
		Thread t2=new Thread(Ticket.getInstance());
		Thread t3=new Thread(Ticket.getInstance());
		t3.start();
		t2.start();
				t.start();
System.out.println("Hello World!");
	}
}
class Ticket implements Runnable
{
	private int count=1000;
	private Ticket(){}//私有化构造函数，不允许显式创建对象
	private static Ticket t=new Ticket();//恶汉式单例
	public static Ticket getInstance(){
		return t;
	}
	static	Object o=new Object();
	public void  run()
	{
		while(count>0)
			{
				synchronized(t){
					try{Thread.sleep(10);}catch(Exception e){}
					if(count>0)
						System.out.println(Thread.currentThread().getName()+"----"+count--);
				}
			}
		
	}
}
//synchronized(o)
		//{