class ArrayDemo
{
public static void main(String[] args)
{
int na[]=null;//可以声明为null
int a[]=new int[2];//也可以声明为两个长度
int[] a2=new int[2];// a[]与[]a 都是可行的
int a3[]={5,6};//声明的时候就赋值
int[] a4={7,8};
a[0]=1;
a[1]=2;
a2[0]=3;
a2[1]=4;
String ad[]=new String[2];
String[] ad2=new String[2];
System.out.println(a[0]);
System.out.println(a[1]);
System.out.println(a2[0]);
System.out.println(a2[1]);
System.out.println(a3[0]);
System.out.println(a3[1]);
System.out.println(a4[0]);
System.out.println(a4[1]);
int [][]a5={{1,2}};//二维数组
int a6[][]={{1,2},{4,5,6}};
System.out.println(a6[0][0]);
System.out.println(a6[0][1]);
//a6[0][2]会抛出异常 超出索引
//System.out.println(a6[0][2]);

System.out.println(a6[1][0]);
System.out.println(a6[1][1]);
System.out.println(a6[1][2]);
for(int x:a3)
	{
System.out.println(x+"a3");

}
}
}