package tw.org.iii.tutor;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import tw.org.iii.classh.student;

public class test53 {

	public static void main(String[] args) {
		student s1 = new student(45,32,56,"Bard");
		System.out.println(s1.sum());
		System.out.println(s1.avg());
		System.out.println(s1.getName());
		try(FileOutputStream fout = new FileOutputStream("dir1/student.s1");
				ObjectOutputStream oout = new ObjectOutputStream(fout);){
			oout.writeObject(s1);
			oout.flush();
		}catch (Exception e) {
			System.out.println(e);
		}
	}

}
