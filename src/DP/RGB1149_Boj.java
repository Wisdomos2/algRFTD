package DP;

import java.util.Scanner;

public class RGB1149_Boj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int col = sc.nextInt();
		
		int in[][] = new int[col+1][3];
		int d[][] = new int[col+1][3];
		
		in[0][0] = 0;
		in[0][1] = 0;
		in[0][2] = 0;
		
		for(int i=1;i<col+1;i++) {
			in[i][0] = sc.nextInt();
			in[i][1] = sc.nextInt();
			in[i][2] = sc.nextInt();
		}
		
		int min = 0;
		
		for(int i=1;i<col+1;i++) {
			d[i][0] = in[i][0] + Math.min(d[i-1][1], d[i-1][2]);
			d[i][1] = in[i][1] + Math.min(d[i-1][0], d[i-1][2]);
			d[i][2] = in[i][2] + Math.min(d[i-1][0], d[i-1][1]);
			
			if(i==col) {
				min = d[i][0];
				if(min > d[i][1]) {
					min = d[i][1];
				}
				if(min > d[i][2]) {
					min = d[i][2];
				}
			}
		}
		
		System.out.println(min);
		
		
		
		
		
	}
}
