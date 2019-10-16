package Bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PopulationMove16234_Boj {
    static int N;
    static int L;
    static int R;
    static int map[][] = null;
    static boolean visited[][] = null;
    static List<ArrayList<Node>> list = null;
    static int move = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = bf.readLine().split(" ");
        N = Integer.parseInt(temp[0]);
        L = Integer.parseInt(temp[1]);
        R = Integer.parseInt(temp[2]);

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            String inputTemp[] = bf.readLine().split(" ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(inputTemp[j]);
            }
        }

        while(true) {
            //연합(큐)를 넣기 위한 리스트
            list = new ArrayList<ArrayList<Node>>();
            visited = new boolean[N][N];
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    if(!visited[i][j]) {
                        Search(i,j);
                    }
                }
            }
            if(list.size() > 0) {
                move++;
                change(list);
            }
            else {
                System.out.println(move);
                bf.close();
                return;
            }
        }

    }

    public static void Search(int col, int row) {
        int dc[] = {0,0,1,-1};
        int dr[] = {1,-1,0,0};
        //탐색을 위한 큐
        Queue<Node> q = new LinkedList<Node>();
        //연합에 대한 노드들을 담아서 리스트에 전달하는 큐
        ArrayList<Node> inputList = new ArrayList<Node>();

        visited[col][row] = true;
        q.add(new Node(col,row));
        inputList.add(new Node(col,row));

        while(!q.isEmpty()) {
            int pcol = q.peek().col;
            int prow = q.peek().row;
            int pvalue = q.poll().value;

            for(int i=0;i<4;i++) {
                int ncol = pcol + dc[i];
                int nrow = prow + dr[i];
                if(ncol > -1 && ncol < N && nrow > -1 && nrow < N) {
                    if(!visited[ncol][nrow]) {
                        int chaE = Math.abs(pvalue - map[ncol][nrow]);
                        if(chaE >= L && chaE <= R) {
                            visited[ncol][nrow] = true;
                            q.add(new Node(ncol, nrow));
                            inputList.add(new Node(ncol, nrow));
                        }
                    }
                }
            }
        }
        //조건에 해당되는게 2개 -> 연합이 존재 -> 리스트에 추가
        if(inputList.size() > 1) {
            list.add(inputList);
        }
    }

    public static void change(List<ArrayList<Node>> list) {
        for(int i=0; i<list.size();i++) {
            ArrayList<Node> getList = list.get(i);
            int cnt = getList.size();
            int sum = 0;
            int result = 0;
            for(int j=0;j<getList.size();j++) {
                sum = sum + getList.get(j).value;
            }
            result = sum/cnt;
            for(int j=0;j<getList.size();j++) {
                int changecol = getList.get(j).col;
                int changerow = getList.get(j).row;
                map[changecol][changerow] = result;
            }
        }

    }

    public static class Node{
        int col;
        int row;
        int value;

        public Node(int col, int row) {
            this.col = col;
            this.row = row;
            this.value = map[col][row];
        }
    }
}
