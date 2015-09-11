class ProxyDemo 
{
	public static void main(String[] args) 
	{
		Network net=null;
		net=new MyProxy(new Real());
		net.browse();
	}
}
interface Network
{
	void browse();
}
class Real implements Network
{
	public void browse()
	{
		System.out.println("上网浏览信息");
	}
}
class MyProxy implements Network
{
	private Network network;
	public MyProxy(Network network)
	{
		this.network=network;
	}
	public void check()
	{
		System.out.println("检查用户信息");
	}
	public void browse()
	{
		this.check();
		this.network.browse();
	}
}
