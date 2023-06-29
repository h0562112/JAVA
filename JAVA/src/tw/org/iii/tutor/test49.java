package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test49 {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("dir1/testimg.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/testimg.jpg");
		int b;
		while((b = fin.read()) != -1) {
			
		}
		
		fin.close();
		
		fout.flush();
		fout.close();
		System.out.println("finish");
	}catch (Exception e) {
		System.out.println(e.toString());
	}
	}
}
