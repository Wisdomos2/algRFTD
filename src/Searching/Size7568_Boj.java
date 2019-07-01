package Searching;

import java.util.Scanner;

public class Size7568_Boj {
	public static void main(String[] args) { 
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int arr[][] = new int[n][2];
		int out[] = new int[n];
		
		for(int i=0;i<n;i++) {
			arr[i][0] = sc.nextInt();
			arr[i][1] = sc.nextInt();
		}
		
		
		for(int i=0;i<n;i++) {
			int rank = 1;
			int height = arr[i][0];
			int weight = arr[i][1];
			for(int j=0;j<n;j++) {
				if(i==j) {
					continue;
				}
				else {
					int other_height = arr[j][0];
					int other_weight = arr[j][1];
					if(height < other_height && weight < other_weight) {
						rank++;
					}
				}
			}
			out[i] = rank;
		}
		
		for(int output : out) {
			System.out.print(output + " ");
		}
		
	}
}
