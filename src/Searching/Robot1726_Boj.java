package Searching;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Robot1726_Boj {
    static int col;
    static int row;
    static int start_col;
    static int start_row;
    static int end_col;
    static int end_row;
    static int start_direction;
    static int end_direction;
    static int map[][];
    static boolean visited[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String cr[] = bf.readLine().split(" ");

        col = Integer.parseInt(cr[0]);
        row = Integer.parseInt(cr[1]);

        map = new int[col][row];
        visited = new boolean[5][col][row];

        for(int i=0;i<col;i++) {
            String temp[] = bf.readLine().split(" ");
            for(int j=0;j<row;j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        String startinfo[] = bf.readLine().split(" ");
        String endinfo[] = bf.readLine().split(" " );

        start_col = Integer.parseInt(startinfo[0]);
        start_row = Integer.parseInt(startinfo[1]);
        start_direction = Integer.parseInt(startinfo[2]);

        end_col = Integer.parseInt(endinfo[0]);
        end_row = Integer.parseInt(endinfo[1]);
        end_direction = Integer.parseInt(endinfo[2]);


        moving(start_col, start_row, start_direction);

        bf.close();
        return;

    }

    private static void moving(int in_col, int in_row, int in_direction) {
        Queue<info> q = new LinkedList<info>();
        //방향은 동쪽이 1, 서쪽이 2, 남쪽이 3, 북쪽이 4
        int dc[] = {0,0,1,-1};
        int dr[] = {1,-1,0,0};


        //visited[in_direction][in_col][in_row] = true;
        q.add(new info(in_col,in_row,in_direction,0));
        visited[in_direction][in_col][in_row] = true;

        while(!q.isEmpty()) {
            int nowc = q.peek().col;
            int nowr = q.peek().row;
            int nowd = q.peek().direction;
            int nowcount = q.poll().count;
            if(nowc == end_col && nowr == end_row && nowd == end_direction) {
                System.out.println(nowcount);
                break;
            }

            /*
            현재 기준으로 2개의 반복.
            1) Go K.
            2) Turn left 90, right 90.
             */

            for(int k=1; k<=3; k++) {
                int nextc = nowc + (dc[nowd-1] * k);
                int nextr = nowr + (dr[nowd-1] * k);
                if(nextc > -1 && nextc < col && nextr > -1 && nextr < row) {
                    if(!visited[nowd][nextc][nextr] && map[nextc][nextr] == 0) {
                        q.add(new info(nextc,nextr, nowd, nowcount+1));
                        visited[nowd][nextc][nextr] = true;
                    }
                }
                else {
                    break;
                }
            }

            for (int i = 1; i <= 4; i++) {
                if (nowd != i && !visited[i][nowc][nowr]) {
                    int add = 1;
                    if (nowd == 1) {
                        if (i == 2) ++add;
                    } else if (nowd == 2) {
                        if (i == 1) ++add;
                    } else if (nowd == 3) {
                        if (i == 4) ++add;
                    } else {
                        if (i == 3) ++add;
                    }
                    visited[i][nowc][nowr] = true;
                    q.add(new info(nowc, nowr, i, nowcount + add));
                }
            }

        }

        return;
    }

    private static class info {
        int col;
        int row;
        int direction;
        int count;
        public info (int col, int row, int direction, int count) {
            this.col = col;
            this.row = row;
            this.direction = direction;
            this.count = count;
        }
    }
}
