class FactoryDemo 
{
	public static void main(String[] args) 
	{
		AnimalEat obj=AnimalFactory.getInstance("chick");
		obj.eat();
		System.out.println("Hello World!");
	}
}
interface AnimalEat
{
	void eat();
}

class  AnimalFactory
{
private AnimalFactory(){}
private static AnimalEat s=null;
public static AnimalEat getInstance(String arg)
	{
if("dog".equals(arg))
		{
s=new dog();
}
if("cat".equals(arg))
{
s=new cat();
}
if("chick".equals(arg))
		{
s=new chick();
}
return s;
}
}
class dog implements AnimalEat
{
public void eat(){
System.out.println(" π∑≥‘»‚ ");
}
}
class cat implements AnimalEat
{
 public	void eat(){System.out.println(" √®≥‘”„ ");}
}
class chick implements AnimalEat
{
	public void eat(){System.out.println(" º¶≥‘√◊ ");}
}