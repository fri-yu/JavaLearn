import java.util.Scanner;
class  Main
{
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int sum = 0;
		while(x != 1){
			if(x % 2 == 0){
				x = x / 2;
			}
			else{
				x = (3*x + 1)/2;
			}
			sum ++;
		}
		System.out.println(sum);
	}
}
