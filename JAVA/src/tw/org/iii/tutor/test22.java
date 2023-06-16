package tw.org.iii.tutor;

import tw.org.iii.classh.Scooter;

public class test22 {

	public static void main(String[] args) {
		Scooter s1 = new Scooter();
		System.out.println(s1.getSpeed());
		
		System.out.println(s1.upGear());
		for (int i=0 ; i<14 ; i++) {
			s1.upSpeed();
		}
		System.out.println(s1.getSpeed());
		s1.downSpeed();s1.downSpeed();
		System.out.println(s1.getSpeed());
		
		System.out.println(s1.upGear());
		
		System.out.println(s1.getSpeed());
	}

}
