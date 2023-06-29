package tw.org.iii.tutor;

import java.io.File;

public class test43 {

	public static void main(String[] args) {
		File dir1 = new File("d:/123/dir");
		if(dir1.exists()) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
