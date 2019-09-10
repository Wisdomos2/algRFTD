package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
/*
    벽을 1번만 부수므로, 모든 벽을 깨면서 진행했다간 시간초과 나기 쉬운문제.
    보통 visited을 boolean으로 check하지만, 이처럼 최단 경로를 해결하기위해선 int형으로 갱신해가며 해결해야함.
    참고 : https://kim6394.tistory.com/201

 */

public class BrokeWall2206_Boj {
    static int N = 0;
    static int M = 0;
    static int map[][] = null;
    static int visited[][] = null;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for(int i=0;i<N;i++) {
            String temp[] = bf.readLine().split("");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                visited [i][j] = Integer.MAX_VALUE;
            }
        }

        if(map[0][0] == 1 || map[N-1][M-1] == 1) {
            return;
        }

        Search(0,0,1,0);
        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }

        bf.close();
        return;
    }

    private static void Search(int col, int row, int count, int drill) {
        Queue<Info> q = new LinkedList<Info>();
        int dc[] = {0,0,-1,1};
        int dr[] = {-1,1,0,0};

        visited[col][row] = 0;
        q.add(new Info(col,row,count,drill));

        while(!q.isEmpty()) {
            int ncol = q.peek().col;
            int nrow = q.peek().row;
            int ncount = q.peek().count;
            int ndrill = q.poll().drill;

            if(ncol == (N-1) && nrow == (M-1)) {
                result = Math.min(result, ncount);
            }

            for(int i=0; i<4;i++) {
                int nxcol = ncol + dc[i];
                int nxrow = nrow + dr[i];

                if(nxcol < 0 || nxcol > (N-1) || nxrow < 0 || nxrow > (M-1)) continue;
                if(visited[nxcol][nxrow] <= ndrill) continue;
                /*
                 visited 가 True and False로 갈릴경우 배열을 따로 파줘야함.
                 무한으로 접근은 가능하지만 (지나올수는 있지만)
                 */

                //if wall
                if(map[nxcol][nxrow] == 1) {
                    //dont using drill
                    if(ndrill == 0) {
                        visited[nxcol][nxrow] = ndrill + 1;
                        q.add(new Info(nxcol, nxrow, ncount+1,ndrill+1));
                    }
                }
                //if not wall
                else if(map[nxcol][nxrow] == 0) {
                    visited[nxcol][nxrow] = ndrill;
                    q.add(new Info(nxcol,nxrow, ncount+1,ndrill));
                }

            }


        }


    }

    private static class Info {
        int col;
        int row;
        int count;
        int drill;

        private Info(int col, int row, int count, int drill) {
            this.col = col;
            this.row = row;
            this.count = count;
            this.drill = drill;
        }
    }
}
