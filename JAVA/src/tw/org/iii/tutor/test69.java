package tw.org.iii.tutor;

public class test69 {

	public static void main(String[] args) {
		String passwd = "123456";
		String hashPasswd =  BCrypt.hashpw(passwd, BCrypt.gensalt());
		System.out.println(hashPasswd);
		
		String passwd2 = "123456";
		if(BCrypt.checkpw(passwd2, hashPasswd)) {
			System.out.println("OK");
		}else {
			System.out.println("XX");
		}
	}

}
