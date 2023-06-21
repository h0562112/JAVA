package tw.org.iii.tutor;

public class test39 {

	public static void main(String[] args) {
		int a = 10, b= 0;
		System.out.println("Hellow Word");
		try {
		System.out.println(a/b);
		}catch(ArithmeticException e) {
			System.out.println("Ooop!");
		}
		int[] c = new int[4];
		System.out.println(c[2]);
		try{
			System.out.println(c[123]);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.out.println("123");
		}
		}

}
