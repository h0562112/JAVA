package tw.org.iii.tutor;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class test62 {

	public static void main(String[] args) {
		try {
		InetAddress ip = InetAddress.getByName("192.168.0.444");
				System.out.println(ip.getHostAddress());
		}catch (UnknownHostException e) {
			System.out.println(e);
		}
	}
}
