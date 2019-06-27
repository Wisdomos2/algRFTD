package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class ATM11399_Boj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int result = 0;
		
		int N = sc.nextInt();
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		result = arr[0];
	
		for(int i=1; i<N; i++) {
			arr[i] = arr[i-1] + arr[i];
			result += arr[i];
		}
		
		System.out.println(result);
	}
}
