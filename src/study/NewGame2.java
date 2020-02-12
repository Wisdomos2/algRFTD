package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    새로운게임2
        ??? / NewGame2_Boj
        소요 시간 :
 */
public class NewGame2 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String getinfo[] = bf.readLine().split(" ");
        N = Integer.parseInt(getinfo[0]);
        K = Integer.parseInt(getinfo[1]);

        for(int i=0;i<N;i++) {
            getinfo = bf.readLine().split(" ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(getinfo[j]);
            }
        }

        for(int i=0;i<K;i++) {
            getinfo = bf.readLine().split(" ");
            int pcRow = Integer.parseInt(getinfo[0]);
            int pcCol = Integer.parseInt(getinfo[1]);
            int pcDirection = Integer.parseInt(getinfo[2]);
        }

        bf.close();
        return;


    }

    static int N=0;
    static int K=0;
    static int map[][];


}
