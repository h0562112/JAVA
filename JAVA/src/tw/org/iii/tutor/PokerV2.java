package tw.org.iii.tutor;

public class PokerV2 {

	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		int [] poker = new int[52];
		boolean isRepeat;
		int temp;
		for (int i=0;i<poker.length;i++) {
			
		do {
			 temp = (int)(Math.random()*52);
			 isRepeat = false;
			for (int j=0;j<i;j++) {
				if(poker[j] == temp) {
					
					isRepeat = true;
					break;
				}
			}
			
				
		}while(isRepeat);
			
			
		poker[i] = temp;
		System.out.println(temp);
		}
		long end = System.currentTimeMillis()-start;
		System.out.println(end);
	}

}
