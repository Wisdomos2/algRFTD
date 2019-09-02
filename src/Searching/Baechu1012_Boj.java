package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 이거풀고 백트래킹 2개정도 풀 예정.
 */
public class Baechu1012_Boj {
	static BufferedReader bf = null;
	static StringTokenizer st = null;
	static int testcase = 0;
	static int row = 0;
	static int col = 0;
	static int chu = 0;
	static int map[][] = null;
	static boolean visited[][] = null;
	static Queue<location> q = null;
	static int dc[] = {0,0,1,-1};
	static int dr[] = {1,-1,0,0};
	static int printarr[] = null;
	public static void main(String[] args) throws IOException{
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		testcase = Integer.parseInt(bf.readLine());
		printarr = new int[testcase];
		
		for(int i=0;i<testcase;i++) {
			st = new StringTokenizer(bf.readLine()," ");
			row = Integer.parseInt(st.nextToken());
			col = Integer.parseInt(st.nextToken());
			
			map = new int[col][row];
			visited = new boolean[col][row];
			
			chu = Integer.parseInt(st.nextToken());
			
			for(int j=0;j<chu;j++) {
				st = new StringTokenizer(bf.readLine(), " ");
				int tempRow = Integer.parseInt(st.nextToken());
				int tempCol = Integer.parseInt(st.nextToken());
				if(tempCol > -1 && tempCol < col && tempRow > -1 && tempRow < row) {
					map[tempCol][tempRow] = 1;
				}
			}
			
			int insect = 0;
			for(int a=0; a<col; a++) {
				for(int b=0; b<row; b++) {
					if(map[a][b] == 1 && visited[a][b] == false) {
						Search(a,b);
						insect++;
					}
				}
			}
			printarr[i] = insect;
		}
		for(int i : printarr) {
			System.out.println(i);
		}
	}
	
	static private void Search(int a, int b) {
		q = new LinkedList<location>();
		q.offer(new location(a,b));
		visited[a][b] = true;
		while(!q.isEmpty()) {
			int nowc = q.peek().col;
			int nowr = q.poll().row;
			
			for(int k=0;k<4;k++) {
				int nextc = nowc + dc[k];
				int nextr = nowr + dr[k];
				if(nextc > -1 && nextc < col && nextr > -1 && nextr < row) {
					if(map[nextc][nextr] == 1 && visited[nextc][nextr] == false) {
						q.offer(new location(nextc,nextr));
						visited[nextc][nextr] = true;
					}
				}
			}
		}
	}
	
	static class location {
		int col;
		int row;
		
		public location(int col, int row) {
			this.col = col;
			this.row = row;
		}
	}
}
