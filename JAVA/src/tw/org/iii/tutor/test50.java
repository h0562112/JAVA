package tw.org.iii.tutor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test50 {

	public static void main(String[] args) {
		
		try {
			FileInputStream fin = new FileInputStream("dir1/testimg.jpg");
			FileOutputStream fout = new FileOutputStream("dir2/testimg3.jpg");
			
		int len;byte[] buf = new byte[4*1024];
		while((len = fin.read(buf)) != -1) {
			fout.write(buf,0,len);
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
