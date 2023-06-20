package tw.org.iii.tutor;

import tw.org.iii.classh.TWId;

public class test32 {

	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		sb.append("abcdefg")
		.append("XX")
		.append("Ok");
		System.out.println(sb);
		System.out.println("---------");
		TWId id = TWId.newTWId("A123456789");
		if(id == null) {
			System.out.println("XX");
		}else {
			System.out.println("OK");
		}
	}

}
