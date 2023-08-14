package tw.org.iii.tutor;
import java.util.Scanner;
public class leetcode02 {
	public class C1 
	{ 
	 public static void main(String[] args) 
	 {
	  Scanner input = new Scanner(System.in);
	  
	  System.out.println("請輸入整數:");
	  int number = input.nextInt();
	  
	  System.out.println(reverse(number));
	  
	 }
	 
	 public static int reverse(int number)
	 {
	  int[] array = new int[10];
	  int i = 0;
	  int z = number;  
	  int count = 1;
	  int t = 1;
	  int result = 0;
	  
	  while(number > 0)
	  {   
	   int a = number % 10;
	   array[i] = a;
	   z = number / 10 ;
	   number = z;
	   i++ ;
	   count = count + 1; 
	  }
	  
	  for(int a = count - 2 ; a >= 0 ; a--)
	  {
	   int c = array[a] * t ;
	   result = result + c;
	   t = t * 10;   
	  }  
	  return result;  
	 }
	}
}
