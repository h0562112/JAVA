package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

import tw.org.iii.classh.student;

public class test54 {

	public static void main(String[] args) {
		try {
					ObjectInputStream oin = new ObjectInputStream(
							new FileInputStream("dir1/student.s1"));
					Object obj = oin.readObject();
					if(obj instanceof student) {
						System.out.println("OK");
					}
					student s1 = (student)obj;
					System.out.println(s1.getName());
					System.out.println(s1.sum());
					System.out.println(s1.avg());
					
					oin.close();
				
		}catch(Exception e) {
			System.out.println(e);
		}
	}

}
