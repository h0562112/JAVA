package tw.org.iii.tutor;

import tw.org.iii.classh.Scooter;

public class test23 {

	public static void main(String[] args) {
		Brad233 obj1 = new Brad233();
	}

}
class Brad231 {
	Brad231(){
		// super();
		System.out.println("Brad231()");
	}
}
class Brad232 extends Brad231{
	Brad232(int a ){
		// super();
		System.out.println("Brad232()");
	}
}
class Brad233 extends Brad232{
	Brad233(){
		 super(4);
		System.out.println("Brad233()");
	}
}