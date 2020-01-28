package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
    게리멘더링2
    BFS, DFS, Simulation / GrayManthering2_Boj
    https://www.acmicpc.net/problem/17779
    소요시간 : 1시간 40분
 */
public class GrayManthering2_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bf.readLine());

        //init
        map = new int[N][N];
        visited = new int[N][N];
        for(int i=0;i<N;i++) {
            String temp[] = bf.readLine().split(" ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }

        bf.close();
        System.out.println(solution());
        return;

    }

    static int map[][];
    static int N = 0;
    static int visited[][];

    private static int solution() {
        int value = Integer.MAX_VALUE;

        //row
        for(int i=0;i<N-2;i++) {
            //col
            for(int j=1;j<N-1;j++) {
                // d1 범위
                for(int d1 = 1; i+d1 < N-1 && j-d1 >= 0; d1++) {
                    // d2 범위
                    for(int d2 = 1; i+d1+d2 < N && j+d2 < N; d2++) {
                        // visited 배열 0으로 초기화
                        initMap();

                        //각 좌표 연결 (5)
                        for(int k=0;k<=d1;k++) {
                            visited[i + k][j - k] = 5;
                            visited[i + d2 + k][j + d2 - k] = 5;
                        }
                        for(int k=0;k<=d2;k++) {
                            visited[i + k][j + k] = 5;
                            visited[i + d1 + k][j - d1 + k] = 5;
                        }
                        // 1 경계선 찍기
                        for(int m = i-1; m >= 0; m--) {
                            visited[m][j] = 1;
                        }
                        // 2 경계선 찍기
                        for(int n = j+d2+1; n<N; n++) {
                            visited[i+d2][n] = 2;
                        }
                        // 3 경계선 찍기
                        for(int n = j-d1-1; n >=0; n--) {
                            visited[i+d1][n] = 3;
                        }
                        // 4 경계선 찍기
                        for(int m = i+d1+d2+1; m<N; m++) {
                            visited[m][j-d1+d2] = 4;
                        }

                        // BFS로 채우면 더 빠를까?
                        fillMap();

                        // 1,2,3,4,5 count
                        int sumValue[] = new int[6];
                        for(int m=0;m<N;m++) {
                            for(int n=0;n<N;n++) {
                                //해당 value값을 index로 잡음.
                                sumValue[visited[m][n]] = sumValue[visited[m][n]] + map[m][n];
                            }
                        }

                        // 안채운거 , 0은 곧 5임.
                        sumValue[5] =  sumValue[5] + sumValue[0];

                        int minValue = Integer.MAX_VALUE;
                        int maxValue = 0;
                        for(int cnt=1;cnt<sumValue.length;cnt++) {
                            minValue = Math.min(minValue,sumValue[cnt]);
                            maxValue = Math.max(maxValue,sumValue[cnt]);
                        }

                        value = Math.min(value, maxValue - minValue);
                    }
                }
            }
        }

        return value;
    }

    static void initMap() {
        for(int k=0;k<N;k++) {
            Arrays.fill(visited[k], 0);
        }
    }

    static void fillMap() {
        cover(0,0,1);
        cover(0,N-1,2);
        cover(N-1,0,3);
        cover(N-1,N-1,4);
    }

    static void cover(int m, int n, int value) {
        //validate range
        if(m < 0 || m > N-1 || n < 0 || n > N-1) {
            return;
        }
        // 이미 채운곳은 필요 없음
        if(visited[m][n] != 0) {
            return;
        }
        visited[m][n] = value;

        //상하좌우 재귀로 채움
        cover(m-1,n,value);
        cover(m+1,n,value);
        cover(m, n-1, value);
        cover(m, n+1, value);
    }
}
