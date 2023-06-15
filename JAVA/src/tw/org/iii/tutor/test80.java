package tw.org.iii.tutor;

import java.util.Arrays;

public class test80 {

	public static void main(String[] args) {
	
			int num = 52;
			int[] poker = new int[num];
			for(int i = 0;i<poker.length ;i++)poker[i]=i;
			
			for(int i= num-1; i>0 ;i--) {
				int rand = (int)(Math.random()*(i+1));
				
				int temp = poker[rand];
				poker[rand]=poker[i];
				poker[i]=temp;
			}
			//for(int v:poker)System.out.println(v);
			//System.out.println("-----------");
			int [][] players = new int[4][13];
			for (int i=0; i<poker.length;i++) {
				players[i%4][i/4]=poker[i];
				
				
			}
			String[] color = {"黑桃","紅心","方塊","梅花"};
			String[] values = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"}; 
			
			for (int[]player:players) {
				//Arrays.sort(player);
				
				for(int card:player){
					//System.out.print (color[card/13]);
					//System.out.print (card/13);
					System.out.print (values[card%13]+"---");
					//System.out.print (card+"+++");
					
					//for (int i=0; i<valuesssss.length;i++) {
					//	System.out.print (valuesssss[i]);
					//}
					
					//System.out.print (card%13);
					//System.out.printf("%s",values[card%13]); // card除以13商等於0,1,2,3分別等於"黑桃","紅心","方塊","梅花"
					
				}					//color[card/13],									      // card除以13餘數等於1~13分別等於values陣列內的"A","2","3","4","5","6","7","8","9","10","J","Q","K"
				System.out.println();
			}
	}

}
