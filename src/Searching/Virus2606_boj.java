package Searching;

import java.util.Scanner;

public class Virus2606_boj {
	static int num = 0;
	static int computer = 0;
	static int vertex = 0;
	static int arr[][] = null;
	static int visit18[] = null;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		computer = sc.nextInt();
		vertex = sc.nextInt();
		
		arr = new int[computer+1][computer+1];
		visit18 = new int[computer+1];
		for(int i=1; i<=vertex; i++) {
			int vertexCol = sc.nextInt();
			int vertexRow = sc.nextInt();
			arr[vertexCol][vertexRow] = 1;
			arr[vertexRow][vertexCol] = 1;
		}
		
		search(1);
		
		
		System.out.println(num);
		sc.close();
		return;
		
	}
	
	static public void search(int next) {
		visit18[next] = 1;
		for(int i=1;i<=computer;i++) {
			if(arr[next][i] == 1 && visit18[i] == 0) {
				search(i);
				num++;
			}
		}
		return;
	}
}
