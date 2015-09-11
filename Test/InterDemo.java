class InterDemo 
{
	public static void main(String[] args) 
	{
		Computer.print(new Flash());
		Computer.print(new Print());
	}
}

class Computer
{
	public static void print(USB usb)
	{
    	System.out.println("USB 已连接");
		usb.work();
		System.out.println("USB 已断开...");
	}
}
interface USB
{
	void work();
}
class Flash implements USB
{
	public void work()
	{
		System.out.println("U 盘 run ");
	}
}
class Print implements USB
{
	public void work()
	{
		System.out.println("打印机 run ");
	}
}