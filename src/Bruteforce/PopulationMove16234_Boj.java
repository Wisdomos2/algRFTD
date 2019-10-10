package Bruteforce;

import java.util.Scanner;

public class PopulationMove16234_Boj {
    static int map[][] = null;
    static int beforeMap[][] = null;
    static int visited[][] = null;

    static int N = 0;
    static int L = 0;
    static int R = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        L = sc.nextInt();
        R = sc.nextInt();

        map = new int[N][N];
        beforeMap = new int[N][N];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = sc.nextInt();
                map[i][j] = sc.nextInt();
            }
        }


        int day = 0;
        int beforeday = 0;
        while(true) {
            beforeday = day;
            for(int i=0;i<N;i++) {
                for(int j=0;j<N;j++) {
                    day = day + moving();
                }
            }

            if(day == beforeday) {
                System.out.println(day);
                return;
            }
        }



    }

    public static int moving() {


        return 0;

    }


}
