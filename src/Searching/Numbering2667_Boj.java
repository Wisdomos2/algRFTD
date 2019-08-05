package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Numbering2667_Boj {
	static int arr[][] = null;
	static int visited[][] = null;
	static int nums = 0;
	static int N = 0;
	static Queue<location> q = null;
	static ArrayList<Integer> result = null;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(bf.readLine());
		
		arr = new int[N][N];
		visited = new int[N][N];
		q = new LinkedList<location>();
		result = new ArrayList<Integer>();
		
		for(int i=0; i<N; i++) {
			String line = bf.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = (line.charAt(j) - '0');
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(arr[i][j] == 1 && visited[i][j] == 0) {
					search(i,j);
					nums++;
				}
			}
		}
		
		System.out.println(nums);
		result.sort(null);
		for(int i=0; i<result.size(); i++) {
			System.out.println(result.get(i));
		}
		return;
		
	}
	
	/*
	 * add, offer 의 차이 : 기능은 같지만 add의 경우 throw 를 제공할 수 없음.
	 */
	static private void search(int col, int row) {
		int how = 0;
		int dc[] = {0,0,1,-1};
		int dr[] = {1,-1,0,0};
		q.offer(new location(col,row));
		visited[col][row] = 1;
		how++;
		
		while(!q.isEmpty()) {
			int getcol = q.peek().col;
			int getrow = q.poll().row;
			
			for(int i=0;i<4;i++) {
				int nextcol = getcol + dc[i];
				int nextrow = getrow + dr[i];
				
				if(nextcol > -1 && nextrow > -1 && nextcol < N && nextrow < N) {
					if(arr[nextcol][nextrow] == 1 && visited[nextcol][nextrow] == 0) {
						q.offer(new location(nextcol, nextrow));
						visited[nextcol][nextrow] = 1;
						how++;
					}
				}
			}
			
		}
		result.add(how);
		return;
	}
	
	
	static public class location {
		int col;
		int row;
		public location(int col,int row) {
			this.col = col;
			this.row = row;
		}
	}
}
