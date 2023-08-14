package tw.org.iii.tutor;

import java.util.Scanner;

public class test003 {
	public static void main(String[] args) {
//		System.out.println("請輸入:");
		Scanner aa = new Scanner(System.in);
		int a = aa.nextInt();
		int b = aa.nextInt();
		int c = (a*2+b)%3;
		if(c == 0) {
			System.out.println("普通");
		}else if(c == 1) {
			System.out.println("吉");
		}else {
			System.out.println("大吉");
		}
	}
}
