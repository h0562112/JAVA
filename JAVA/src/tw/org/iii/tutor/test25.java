package tw.org.iii.tutor;

public class test25 {

	public static void main(String[] args) {
		String s1 = "Brad"; //""內=產稱物件
//		System.out.println(s1.charAt(0));
//		System.out.println("Andy".charAt(2));
//		System.out.println(s1);
		String s2 = new String();
		byte[] b1 = {97,98,99,100};
		byte[] b2 = new byte[] {97,98,99,100};
		String s3 = new String(b1);
		String s4 = new String(b1,1,2);
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		
	}

}
