package tw.org.iii.tutor;
import java.util.Scanner;
public class test0615 {

	public static void main(String[] args) {
		System.out.println("n= ");
		Scanner scanner =new Scanner(System.in);
		int n = scanner.nextInt();
		int i = 0, sum = 0 ;
		while(i<=n) {
			sum +=i++;
			
			
		}
		System.out.printf("1+2+3+...+%d = %d",n,sum);
	}

}
