package study;

import javax.naming.PartialResultException;
import javax.swing.*;
import java.util.LinkedList;
import java.util.Queue;

/*
    카카오 컬러링북
    / KaKaoColoringBook_Prg
 */
public class KaKaoColoringBook_Prg {
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int arr[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int getResult[] = solution(m,n,arr);
        System.out.println(getResult[0] + " " + getResult[1]);
    }

    public static int[] solution(int m, int n, int[][] picture) {

        visited = new boolean[picture.length][picture[0].length];
        M = m;
        N = n;
        count = 0;
        valueOfMax = Integer.MIN_VALUE;

        for(int i=0;i<picture.length;i++) {
            for(int j=0;j<picture[0].length;j++) {
                if(picture[i][j] == 0) {
                    continue;
                }
                if(picture[i][j] != 0 && !visited[i][j] ) {
                    count = count + 1;
                    int tempCount = bfs(i,j,picture[i][j],picture);
                    valueOfMax = Math.max(valueOfMax,tempCount);
                }
            }
        }


        int[] answer = new int[2];
        answer[0] = count;
        answer[1] = valueOfMax;
        return answer;
    }

    public static boolean visited[][] = null;
    public static int M=0;
    public static int N=0;
    public static int count = 0;
    public static int valueOfMax = Integer.MIN_VALUE;

    public static int bfs(int row, int col,int color, int map[][]) {
        int countOfThis = 1;
        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,1,-1};

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row,col,color));
        visited[row][col] = true;


        while(!q.isEmpty()) {
            Node node = q.poll();
            int bfRow = node.row;
            int bfCol = node.col;
            int bfColor = node.color;

            for(int i=0;i<4;i++) {
                int nxRow = bfRow + dr[i];
                int nxCol = bfCol + dc[i];
                int nxColor = bfColor;

                if(nxRow > -1 && nxRow < M && nxCol > -1 && nxCol < N) {
                    if(!visited[nxRow][nxCol]) {
                        if(map[nxRow][nxCol] == bfColor) {
                            visited[nxRow][nxCol] = true;
                            countOfThis++;
                            q.add(new Node(nxRow,nxCol,nxColor));
                        }
                    }

                }
            }


        }

        return countOfThis;
    }

    private static class Node {
        public Node(int row, int col, int color) {
            this.row = row;
            this.col = col;
            this.color = color;
        }

        int row;
        int col;
        int color;
    }
}
