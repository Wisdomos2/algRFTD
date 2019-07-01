package String;

import java.util.Scanner;

public class FindAhlpabet10809_Boj {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String s[] = sc.nextLine().toLowerCase().split("");
		
		if(s.length > 100) {
			return;
		}
		
		String check[] = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
		int output[] = new int[check.length];
		
		for(int i=0;i<output.length;i++) {
			output[i] = -1;
		}
		
		for(int i=0; i<s.length; i++) {
			for(int j=0;j<check.length;j++) {
				if(s[i].equals(check[j]) ) {
					if(output[j] == -1) {
						output[j] = i;
					}
				}
			}
		}
		
		for(int o : output) {
			System.out.printf(o + " ");
		}
		
	}
}
