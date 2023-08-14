package tw.org.iii.tutor;

import java.util.ArrayList;
import java.util.Arrays;

public class leetcode001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int[] c = new int[2];
	int numss[]= {};
	int nums[] = {3,3};
	int target = 6;
	int a;
	int b;
	
//	System.out.println(nums);
//	System.out.println(nums.length);
	//System.out.println(Arrays.binarySearch(nums,11));
	for(int i : nums){
		a = target-i ;
		if(a < target && a > 0) {
//			System.out.println(a);
//			System.out.println(i);
		}
		
		for(int j : nums){
			
			
			b = a - j;
			if(b == 0 ) {
				for(int k = 0; k < nums.length; k++) {
					if (nums[k] == j) {
						System.out.println("------");
						System.out.println(j);
						System.out.println(k);
						c[0] = j;
						c[1] = k;
//		                return k;  // 找到目標值，回傳索引位置
		            }
				}
//				System.out.println(numss[j]);
			}
			
		}
	}
//	for(int k : numss){
//		System.out.println(k);
//	System.out.println(Arrays.binarySearch(nums,k));
//	}
	}

}
