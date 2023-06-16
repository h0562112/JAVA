package tw.org.iii.tutor;

import tw.org.iii.classh.Bike;

public class test21 {

	public static void main(String[] args) {
		Bike b1 = new Bike();
		
		System.out.println(b1.owner);
		System.out.println(b1.getSpeed());
		
		b1.upSpeed();	b1.upSpeed();	b1.upSpeed();	b1.upSpeed();
	System.out.println(b1.getSpeed());
		b1.downSpeed();b1.downSpeed();b1.downSpeed();b1.downSpeed();
		System.out.println(b1.getSpeed());
		for (int i=0 ; i<14 ; i++) {
			b1.upSpeed();
		}
		System.out.println(b1.getSpeed());
		
		
		
	}

}
