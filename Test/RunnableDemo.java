class  RunnableDemo
{
	public static void main(String[] args) 
	{
		Thread t=new Thread(Ticket.getInstance());
		Thread t2=new Thread(Ticket.getInstance());
		Thread t3=new Thread(Ticket.getInstance());
		t.start();
		t3.start();
		t2.start();
		System.out.println("Hello World!");
	}
}
class Ticket implements Runnable
{
	private int count=100;
	private Ticket(){}//私有化构造函数，不允许显式创建对象
	private static Ticket t=new Ticket();//恶汉式单例
	public static Ticket getInstance(){
		return t;
	}
	public void  run()
	{
		while(count>0)
		{
			try{Thread.sleep(10);}catch(Exception e){}
			System.out.println(count--);
		}
	}
}