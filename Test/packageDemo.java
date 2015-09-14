package a.b;
class  packageDemo
{
	public static void main(String[] args) 
	{
		System.out.println("Hello World!");
	}
}
/*
javac -d . packageDemo.java
java a.b.packageDemo
import a.b.* 与 import a.b.packageDemo没有性能上的差异
*/