package tw.org.iii.tutor;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class test48 {

	public static void main(String[] args) {
		String mesg = "\n123";
		try {
		FileOutputStream fout = new FileOutputStream("dir1/file5",true);
			fout.write(mesg.getBytes());
			fout.flush();
			fout.close();
			System.out.println("OK");
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		}

}
