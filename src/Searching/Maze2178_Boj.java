package Searching;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Maze2178_Boj {
	static BufferedReader bf = null;
	static StringTokenizer st = null;
	static int N = 0; //col
	static int M = 0; //row
	static int map[][] = null;
	static boolean visited[][] = null;
	static int result = 0;
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(bf.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		//input
		for(int i=0; i<N; i++) {
			String temp[] = bf.readLine().split("");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(temp[j]);
			}
		}
		
		Search(0,0,1);
		
		bf.close();
		
		return;
	}
	
	static private void Search(int col, int row, int step) {
		Queue<info> q = new LinkedList<info>();
		q.offer(new info(col,row,step));
		visited[col][row] = true;
		
		int dn[] = {0,0,1,-1};
		int dm[] = {1,-1,0,0};
		
		while(!q.isEmpty()) {
			int nowN = q.peek().N;
			int nowM = q.peek().M;
			int nowStep = q.poll().step;
			
			for(int k=0; k<4; k++) {
				int nextN = nowN + dn[k];
				int nextM = nowM + dm[k];
				int nextStep = nowStep + 1;
				
				if(nextN > -1 && nextN < N && nextM > -1 && nextM < M) {
					if(map[nextN][nextM] == 1 && !visited[nextN][nextM]) {
						q.offer(new info(nextN,nextM,nextStep));
						visited[nextN][nextM] = true;
						map[nextN][nextM] = nextStep;
					}
				}
			}
			
		}
		
		System.out.println(map[N-1][M-1]);
		
		
		
	}
	
	static class info {
		int N;
		int M;
		int step;
		
		public info(int N,int M,int step) {
			this.N = N;
			this.M = M;
			this.step = step;
		}
	}
}
