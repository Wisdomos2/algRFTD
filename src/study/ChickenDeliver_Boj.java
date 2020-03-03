package study;

import java.util.Scanner;

public class ChickenDeliver_Boj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = sc.nextInt();
            }
        }

    }

    static int N; // map
    static int M; // 살아남을 치킨집
    static int map[][];
}
