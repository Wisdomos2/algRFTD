package X.Prgmers;

import java.util.Scanner;

public class FinnNUm_Prgmers {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int result = solution(n);
		
		sc.close();
		
		if(result != -1) {
			System.out.println(result);
		}
		
		return;
		
	}
	
	static private int solution(int n) {
		int sum = 0;
		if(n > 10000) {
			return -1;
		}
		else {
			for(int i=1;i<=n;i++) {
				int result = 0;
				for(int j=i;j<=n;j++) {
					result += j;
					if(result == n) {
						sum++;
						break;
					}
				}
			}
		}
		return sum;
	}
}
