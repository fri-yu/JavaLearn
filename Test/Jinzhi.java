class Jinzhi
{
public static void main(String[] args){
	byte b=3;
	//b=b+2;可能丢失精度，编译不通过
	b=(byte)(b+2);

System.out.println(60);
System.out.println(0x3c);
System.out.println(Integer.toBinaryString(0x3c));


}
}
/*基本数据类型 值类型  整数类型 byte -128~127 short -32768~32767 int long 浮点类型 -float double 字符型-char 布尔型-boolean 
引用类型 类类型 class 接口 interface 数组[]
*/