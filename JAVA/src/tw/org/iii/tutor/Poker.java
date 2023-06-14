package tw.org.iii.tutor;

public class Poker {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int [] poker = new int[52];
		for (int i=0;i<poker.length;i++) {
			int temp = (int)(Math.random()*52);
			
			boolean isRepeat = false;
			for (int j=0;j<i;j++) {
				if(poker[j] == temp) {
					
					isRepeat = true;
					break;
				}
			}
			if(!isRepeat) {
			poker[i] = temp;
			System.out.println(poker[i]);
			}else {
				i--;
			}
		}
		long end = System.currentTimeMillis()-start;
		System.out.println(end);
	}

}
