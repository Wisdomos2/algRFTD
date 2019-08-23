package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;


/*

 */
public class Tomato7569_Boj  {
	static BufferedReader bf = null;
	static int M = 0;
	static int N = 0;
	static int H = 0;
	static int box[][][] = null;
	static boolean visited[][][] = null;
	static int oktomato = 0;
	static int notomato = 0;
	static int day = 0;
	static Queue<location> q = null;
	public static void main(String[] args) throws IOException {
		bf = new BufferedReader(new InputStreamReader(System.in));
		String boxinfo[] = bf.readLine().split(" ");
		M = Integer.parseInt(boxinfo[0]);
		N = Integer.parseInt(boxinfo[1]);
		H = Integer.parseInt(boxinfo[2]);
		
		
		box = new int[H][N][M];
		visited = new boolean[H][N][M];
		q = new LinkedList<location>();
		
		
		int oktomato = 0;
		int notomato = 0;
		
		for(int h = 0; h < H; h++) {
			for(int n = 0; n < N; n++) {
				String temp[] = bf.readLine().split(" ");
				for(int m = 0; m < M; m++) {
					box[h][n][m] = Integer.parseInt(temp[m]);
					if(box[h][n][m] == 1) {
						visited[h][n][m] = true;
						q.offer(new location(h,n,m));
						oktomato++;
					}
					else if(box[h][n][m] == 0) {
						notomato++;
					}
				}
			}
		}
		
		if(notomato == 0) {
			System.out.println(0);
			return;
		}
		
		/*
		 * day에 -1을 둔이유, 하루가 안지나도 오늘에 끝날수 있기때문.
		 */
		int day = -1;
		while(!q.isEmpty()) {
			int qsize = q.size();
			day++;
			for(int cycle=0;cycle<qsize;cycle++) {
				location x = q.poll();
				int nowh = x.height;
				int nowc = x.col;
				int nowr = x.row;
				
				int dh[] = {-1,1};
				//up down
				for(int i=0;i<2;i++) {
					int nexth = nowh + dh[i];
						if(nexth > -1 && nexth < H) {
						if(box[nexth][nowc][nowr] == 0 && visited[nexth][nowc][nowr] == false) {
							visited[nexth][nowc][nowr] = true;
							box[nexth][nowc][nowr] = 1;
							q.offer(new location(nexth,nowc,nowr));
							notomato--;							}
					}
				}
				
				// 4 directions
				int dc[] = {0,0,1,-1};
				int dr[] = {1,-1,0,0};
				for(int i=0;i<4;i++) {
					int nextc = nowc + dc[i];
					int nextr = nowr + dr[i];
					
					if(nextc > -1 && nextc < N && nextr > -1 && nextr < M) {
						if(box[nowh][nextc][nextr] == 0 && visited[nowh][nextc][nextr] == false) {
							visited[nowh][nextc][nextr] = true;
							box[nowh][nextc][nowr] = 1;
							q.offer(new location(nowh,nextc,nextr));
							notomato--;
						}
					}
				}
			}
		}
		
		if(notomato != 0) {
			System.out.println(-1);
			return;
		}
		else {
			System.out.println(day);
			return;
		}

		
	}
	
	static void printarr(int Arr[][][]) {
		for(int h=0;h<H;h++) {
			for(int n=0;n<N;n++) {
				for(int m=0;m<M;m++) {
					System.out.println();
				}
			}
		}
	}
	
	
	static class location {
		int height;
		int col;
		int row;
		
		public location(int height, int col, int row) {
			this.height = height;
			this.col = col;
			this.row = row;
		}
	}
	
}
