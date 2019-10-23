package Searching;
//토마토랑 비슷한듯?


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Laboratory17142_Boj {
    static int map[][] = null;
    static int visited[][] = null;
    static ArrayList<Node> list, allowed = null;
    static int N = 0;
    static int virus = 0;
    static int min = 0;

    public static void main(String[] args) throws IOException {
     BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
     String temp[] = bf.readLine().split(" ");
     N = Integer.parseInt(temp[0]);
     virus = Integer.parseInt(temp[1]);

     map = new int[N][N];
     visited = new int[N][N];
     allowed = new ArrayList<Node>();

     min = Integer.MAX_VALUE;

     for(int i=0;i<N;i++) {
         String inputTemp[] = bf.readLine().split(" ");
         for(int j=0;j<N;j++) {
             map[i][j] = Integer.parseInt(inputTemp[j]);
             if(map[i][j] == 2) {
                 allowed.add(new Node(i,j,0));
             }
         }
     }

     for(int i=0; i<allowed.size(); i++) {
         list = new ArrayList<Node>();
         list.add(allowed.get(i));
         goVirus(i,1,virus);

     }
        if(min == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(min);
        }


    }

    public static void goVirus(int index, int count, int limit) {
        if(count == limit) {
            int result = spreadVirus();
            if(result > 0 && min > result) {
                min = result;
            }
        }
        else {
            int size = allowed.size();
            for(int i=index+1; i<size;i++) {
                Node node = allowed.get(i);
                if(map[node.col][node.row] == 2) {
                    list.add(node);
                    goVirus(i,count+1,limit);
                }
            }
        }

        list.remove(list.size()-1);

    }

    public static int spreadVirus() {
        Queue<Node> q = new LinkedList<Node>();
        int copyMap[][] = new int[N][N];
        boolean visited[][] = new boolean[N][N];
        int time = 0;
        int temp = 0;
        q.addAll(list);

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                copyMap[i][j] = map[i][j];
            }
        }

        while(!q.isEmpty()) {
            boolean blank = false;

            int size = q.size();


        }


        return time;
    }

    public static class Node {
        int col;
        int row;
        int cnt;

        public Node (int col, int row, int cnt) {
            this.col = col;
            this.row = row;
            this.cnt = cnt;
        }
    }
}
