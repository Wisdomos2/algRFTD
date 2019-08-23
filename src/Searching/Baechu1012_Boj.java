package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 이거풀고 백트래킹 2개정도 풀 예정.
 */
public class Baechu1012_Boj {
	static BufferedReader bf = null;
	static int testcase = 0;
	static int row = 0;
	static int col = 0;
	static int chu = 0;
	static int map[][] = null;
	static boolean visited[][] = null;
	static Queue<location> q = null;
	static int dc[] = {0,0,1,-1};
	static int dr[] = {1,-1,0,0};
	public static void main(String[] args) throws IOException{
		bf = new BufferedReader(new InputStreamReader(System.in));
		
		testcase = Integer.parseInt(bf.readLine());
		
		for(int i=0;i<testcase;i++) {
			String temp[] = bf.readLine().split(" ");
			row = Integer.parseInt(temp[0]);
			col = Integer.parseInt(temp[1]);
			chu = Integer.parseInt(temp[2]);
			
			if(row < -1 || row > 50 || col < -1 || col > 50 || chu < -1 || chu > 2500) {
				return;
			}
			else {
				map = new int[col][row];
				visited = new boolean[col][row];
				q = new LinkedList<location>();
				
				for(int j=0;j<chu;j++) {
					String chus[] = bf.readLine().split(" ");
					int inputcol = Integer.parseInt(chus[0]);
					int inputrow = Integer.parseInt(chus[1]);
					if(inputcol < 0 || inputcol > (col-1) || inputrow < 0 || inputrow > (row-1)) {
						continue;
					}
					else {
						map[inputcol][inputrow] = 1;
					}
				}
				
				for(int t = 0; t < col ; t++) {
					for(int y = 0; y<row; y++) {
						System.out.print(map[t][y]);
					}
					System.out.println();
				}
				/*
				 * start to imply logic
				 */
				int insect  = 0;
				for(int a=0; a<col;a++) {
					for(int b=0;b<row;b++) {
						if(map[a][b] == 1 && visited[a][b] == false) {
							q.offer(new location(a,b));
							visited[a][b] = true;
							System.out.println(a + " / " + b);
							insect++;
							while(!q.isEmpty()) {
								int nowc = q.peek().col;
								int nowr = q.poll().row;
								
								for(int k=0;k<4;k++) {
									int nextc = nowc + dc[i];
									int nextr = nowr + dr[i];
									if(nextc > -1 && nextc < col && nextr > -1 && nextr < row) {
										if(map[nextc][nextr] == 1 && visited[nextc][nextr] == false) {
											visited[nextc][nextr] = true;
											q.offer(new location(nextc,nextr));
										}
									}
								}
							}
						}
					}
				}
				System.out.println(insect);
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
