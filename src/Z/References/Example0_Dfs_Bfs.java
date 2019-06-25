package Z.References;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Example0_Dfs_Bfs {
	//노드, 간선 저장
	//ArrayList[] 는즉 2차원 배열인 셈이다.
	static ArrayList<Integer>[] a;
	//방문 여부 저장 
	static boolean[] c;
	public static void main(String[] args) throws IOException {
		//전적으로 메인에서는 정점의 개수와 정점에서 정점으로 연결된 것을 파악한뒤 ArrayList에 추가해주는 것 뿐임 
			Scanner sc = new Scanner(System.in);
			//BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
			//정점 
			int n = sc.nextInt();
			//간선 
			int m = sc.nextInt();
			//시작 노드 
			int start = sc.nextInt();
			
			a = new ArrayList[n+1];
			
			for(int i=1;i<=n;i++)
			{
				a[i] = new ArrayList<Integer>();
			}
			
			//간선 추가 
			for(int i=0;i<m;i++)
			{
				int u = sc.nextInt();
				int v = sc.nextInt();
				a[u].add(v);
				a[v].add(u);
				//ex) u = 1, v = 5이면 a[1]에 연결된 정점 5추가,a[5]에서도 1로 갈 수 있으니까 1도 추가 
			}
			
			//각 정점 연결 정렬
			for(int i=1;i<=n;i++)
			{
				Collections.sort(a[i]);
			}
			
			c = new boolean[n+1];
			
			dfs_recrusion(start);
			
			for(boolean i : c)
			{
				System.out.println(i + " ");
			}
			
			c = new boolean[n+1];
			
			bfs(start);
			
			for(boolean i : c)
			{
				System.out.println(i + " ");
			}
			
			
		}
	
	
	//재귀로 dfs 
	static void dfs_recrusion(int Vertex)
	{
		//이미 start노드를 방문했다면 
		if(c[Vertex] == true)
		{
			return;
		}
		//첫 방문이라면 true값을 넣어주
		c[Vertex] = true;
		System.out.println(Vertex + " ");
		//방문한 정점과 연결된 정점들에 대해 다시 dfs실시 
		for(int y : a[Vertex])
		{
			//만약 정점과 연결된 정점이 방문하지 않은 상태라면 
			if(c[y] == false)
			{
				//해당값에 대해 다시 dfs를 실시한다 
				dfs_recrusion(y);
			}
		}
	}
	
	//스택으로 
	static void dfs_stack()
	{
		
	}
	
//	
//	4 5 1
//	1 2
//	1 3
//	1 4
//	2 4
//	3 4
	
	//bfs
	static void bfs(int start)
	{
		Queue<Integer> q = new LinkedList<Integer>();
		q.add(start);
		c[start] = true;
		while(!q.isEmpty())
		{
			int x = q.remove();
			System.out.println(x + " ");
			for(int y : a[x])
			{
				if(c[y] == false)
				{
					c[y] = true;
					q.add(y);
					
				}
			}
		}
	}
	
	
}

	

