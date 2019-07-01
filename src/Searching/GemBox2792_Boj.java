package Searching;

import java.util.Scanner;

public class GemBox2792_Boj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int left = 1;
		int right = Integer.MIN_VALUE;
		int jealousy = Integer.MAX_VALUE;
		
		//number of student
		int n = sc.nextInt();
		//number of gem
		int m = sc.nextInt();
		
		int gems[] = new int[m];
		
		for(int i=0;i<m;i++) {
			gems[i] = sc.nextInt();
			if(right < gems[i]) {
				right = gems[i];
			}
		}
		
		while(left <= right) {
			int mid = (left+right) / 2;
			int people = 0;
			
			for(int i=0;i<m;i++) {
				people += (gems[i] / mid);
				if(gems[i] % mid != 0) {
					people += 1;
				}
			}
			
			if(people <= n) {
				right = mid - 1;
				if(mid < jealousy) {
					jealousy = mid;
				}
			}
			else {
				left = mid + 1;
			}
			
		}
		
		
//		for(int i=max; i>0; i--) {
//			if(((totalgem - i) / otherN) > 0 && ((totalgem - i) % otherN) == 0 ) {
//				jealousy = i;
//			}
//		}
		
		System.out.println(jealousy);
		sc.close();
		
		
		
	}
}
