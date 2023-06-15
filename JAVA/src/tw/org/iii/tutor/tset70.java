package tw.org.iii.tutor;

public class tset70 {

	public static void main(String[] args) {
		int number [] =new int[10];
		for(int i=0;i<number.length;i++) {	
			 number[i] = (int)(Math.random()*(10)+1);
			
			System.out.println(number[i]);
			}
		int max=number[0];
		for(int i=1;number.length>i;i++) {
			if (number[i]>max) {
				max=number[i];
			}
			
		}
		System.out.println("最大數:"+max);
	}

}
