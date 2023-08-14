package tw.org.iii.tutor;

import java.util.Scanner;

public class test004 {

	public static void main(String[] args) {
		
		Scanner aa = new Scanner(System.in);
		
		int a = aa.nextInt();
//		Scanner bb= new Scanner(System.in);
	
//		
		if(a%4 != 0 ) {
			System.out.print("平年");
		}else if(a%4 == 0 && a%100 != 0 ) {
			System.out.print("閏年");
		}else if(a%100 == 0 && a%400 != 0 ){
			System.out.print("平年");
		}else if(a%400 == 0 ) {
			System.out.print("閏年");
		}
		int b = aa.nextInt();
		if(b%4 != 0) {
			System.out.print("平年");
		}else if(b%4 == 0 && b%100 != 0) {
			System.out.print("閏年");
		}else if( b%100 == 0 && b%400 != 0){
			System.out.print("平年");
		}else if(b%400 == 0) {
			System.out.print("閏年");
		}
	}
	}

