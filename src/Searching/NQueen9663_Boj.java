package Searching;

import java.util.*;

public class NQueen9663_Boj {
    static int col[] = null;
    static int N = 9;
    static int result = 0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        for(int i=1;i<=N;i++) {
            col = new int[N+1];
            col[1] = i;
            dfs(1);
        }


        System.out.println(result);
    }

    public static void dfs(int row) {
        if(row == N) {
            ++result;
        }
        else {
            for(int i=1;i<=N;i++) {
                col[row+1] = i;
                if(check(row+1)) {
                    dfs(row+1);
                }
                else {
                    col[row+1] = 0;
                }
            }
        }
        //back tracking
        col[row] = 0;
    }
    // 행의 차 절대값 == 열의 차 절대값 이 성립하면 두 좌표는 동일 대각선.
    public static boolean check(int row) {

        for(int i=1;i<row;i++) {
            if(col[i] == col[row]) {
                return false;
            }
            if(Math.abs(col[i] - col[row]) == Math.abs(i-row)) {
                return false;
            }
        }
        return true;
    }



}
