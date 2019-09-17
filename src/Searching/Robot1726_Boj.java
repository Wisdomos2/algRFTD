package Searching;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    왜 visited가 3차원인지 손으로 직접 그려보기.
    머리로도 대충 알 것 같기도?
    ----> 3번갔는데 막혔으면 <---갈수도 있어야함. 방향을 따로 체크하지않으면 돌아올수가 없음.
    문제가 병신인지 내눈이 병신인지 모르겠네
    3이 없어지는것은 그 뭐냐 행과 열 차이인거같은데 씨이파아아아앙새
 */
public class Robot1726_Boj {
    static int M;
    static int N;
    static int map[][];
    static boolean visited[][][];
    static int st_col;
    static int st_row;
    static int st_way;
    static int en_col;
    static int en_row;
    static int en_way;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M+1][N+1];
        visited = new boolean[5][M+1][N+1];

        for(int i=1;i<=M;i++) {
            for(int j=1;j<=N;j++) {
                map[i][j] = sc.nextInt();
            }
        }

        st_col = sc.nextInt();
        st_row = sc.nextInt();
        st_way = sc.nextInt();

        en_col= sc.nextInt();
        en_row = sc.nextInt();
        en_way = sc.nextInt();

        visited[st_way][st_col][st_row] = true;
        Search();

        sc.close();
        return;

    }

    public static void Search() {
        /* 동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4 */
        Queue<Info> q = new LinkedList<>();
        int dc[] = {0,0,0,-1,1};
        int dr[] = {0,1,-1,0,0};
        q.add(new Info(st_col, st_row, st_way, 0));

        while(!q.isEmpty()) {
            Info getq = q.poll();
            int nowcol = getq.col;
            int nowrow = getq.row;
            int nowway = getq.way;
            int nowcnt = getq.cnt;
            if(nowrow== en_row && nowcol == en_col && nowway== en_way) {
                System.out.println(nowcnt);
                return;
            }


            // Go K
            for(int i=1;i<=3;i++) {
                int nextcol = nowcol + (dc[nowway] * i);
                int nextrow = nowrow + (dr[nowway] * i);
                if(nextcol > 0 && nextcol <= M && nextrow > 0 && nextrow <= N) {
                    if(map[nextcol][nextrow] == 0 && visited[nowway][nextcol][nextrow] == false) {
                        visited[nowway][nextcol][nextrow] = true;
                        q.add(new Info(nextcol, nextrow, nowway, nowcnt + 1));
                    }
                }
                else {
                    break;
                }
            }

            // Turn dir
            for(int i=1;i<=4;i++) {
                int add = 1;
                if(nowway != i && visited[i][nowcol][nowrow] == false) {
                    if(nowway == 1) {
                        if(i == 2) {
                            add++;
                        }
                    }
                    else if(nowway == 2) {
                        if(i == 1) {
                            add++;
                        }
                    }
                    else if(nowway == 3) {
                        if(i == 4) {
                            add++;
                        }
                    }
                    else if(nowway == 4) {
                        if(i == 3) {
                            add++;
                        }
                    }
                }
                visited[i][nowcol][nowrow] = true;
                q.add(new Info(nowcol, nowrow, i, nowcnt + add));
            }


        }

    }

    public static class Info {
        int col;
        int row;
        int way;
        int cnt;

        public Info (int col, int row, int way, int cnt) {
            this.col = col;
            this.row = row;
            this.way = way;
            this.cnt = cnt;
        }
    }
}
