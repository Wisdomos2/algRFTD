package study;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
    https://www.acmicpc.net/problem/17822
 */
public class Cycleonepan_Boj {
    public static void main(String[] args) throws Exception{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input1[] = bf.readLine().split(" ");

        int N = Integer.parseInt(input1[0]);
        int M = Integer.parseInt(input1[1]);
        int T = Integer.parseInt(input1[2]);


        int map[][] = new int[N][M];
        int testcase[][] = new int[T][3];
        for(int i=0;i<N;i++) {
            input1 = bf.readLine().split(" ");
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(input1[j]);
            }
        }

        for(int i=0;i<T;i++) {
            input1 = bf.readLine().split(" ");
            testcase[i][0] = Integer.parseInt(input1[0]);
            testcase[i][1] = Integer.parseInt(input1[1]);
            testcase[i][2] = Integer.parseInt(input1[2]);
        }

        for(int i=0;i<testcase.length;i++) {
            map = shift(map,testcase[i][0],testcase[i][1],testcase[i][2]);
            visited = new boolean[map.length][map[0].length];
            changeFlag = false;
            for(int a=0;a<map.length;a++) {
                for(int b=0;b<map[0].length;b++) {
                    if(!visited[a][b] && map[a][b] != 0) {
                        map = check(map,a,b);
                    }
                }
            }
            if(!changeFlag) {
                double average[] = sumMap(map);
                double getaverage = average[0]/average[1];
                map = averageMap(map,getaverage);
            }
        }


        System.out.println((int)sumMap(map)[0]);

        bf.close();
        return;



    }

    //십자가 방향으로 체크 (단 옆에 것이랑 같은 경우 지우면 다음 거에서 잘 못찾을 수 있음.)
    //해당되는 index를 저장해 놓았다가 한번에 처리하는 것 필요할듯? flag를 사용해서 변했는지 아닌지 체크하거나.
    static boolean visited[][];
    static boolean changeFlag;
    public static int[][] check(int map[][],int col, int row) {
        int dc[] = {1,-1,0,0};
        int dr[] = {0,0,1,-1};
        Queue<Node> q = new LinkedList<>();
        visited[col][row] = true;
        q.add(new Node(col,row,map[col][row]));

        while(!q.isEmpty()) {
            Node node = q.poll();
            int pcol = node.col;
            int prow = node.row;
            int pvalue = node.value;

            int ncol = 0;
            int nrow = 0;

            for(int k=0;k<4;k++) {
                ncol = pcol + dc[k];
                nrow = prow + dr[k];

                if(nrow < 0) {
                    nrow = map[0].length-1;
                }
                else if(nrow > map[0].length-1) {
                    nrow = 0;
                }

                if(ncol > -1 && ncol < map.length) {
                    if(!visited[ncol][nrow] && map[ncol][nrow] != 0) {
                        if(map[ncol][nrow] == pvalue) {
                            if(!changeFlag) {
                                changeFlag = true;
                            }
                            if(map[pcol][prow] != 0) {
                                map[pcol][prow] = 0;
                            }
                            visited[ncol][nrow] = true;
                            map[ncol][nrow] = 0;
                            q.add(new Node(ncol,nrow,pvalue));
                        }
                    }
                }
            }


        }

        return map;
    }

    //base의 배수 index를 회전 시계방향 : 0 반시계방향 : 1
    //map을 base의 배수 행을 foward 방향으로 how 만큼 이동
    public static int[][] shift(int map[][], int base, int foward, int how) {

        for(int i=1;i<map.length;i++) {
            if((i+1)%base == 0) {
                // 시계 >>
                int shiftarr[] = map[i].clone();
                if(foward == 0) {
                    for(int s=0;s<how;s++) {
                        int last = shiftarr[shiftarr.length-1];
                        for(int c=shiftarr.length-2;c>=0;c--) {
                            shiftarr[c+1] = shiftarr[c];
                        }
                        shiftarr[0] = last;
                    }
                }
                // 반시계 <<
                else if(foward == 1) {
                    for(int s=0;s<how;s++) {
                        int first = shiftarr[0];
                        for(int c=0;c<shiftarr.length-1;c++) {
                            shiftarr[c] = shiftarr[c+1];
                        }
                        shiftarr[shiftarr.length-1] = first;
                    }
                }
                map[i] = shiftarr.clone();
            }
        }

        return map;
    }


    //평균값에 대한 계산
    public static int[][] averageMap(int map[][], double average) {

        for(int i=0;i<map.length;i++) {
            for(int j=0;j<map[0].length;j++) {
                if(map[i][j] > average && map[i][j] != 0) {
                    map[i][j] = map[i][j] - 1;
                }
                else if(map[i][j] < average && map[i][j] != 0) {
                    map[i][j] = map[i][j] + 1;
                }
            }
        }

        return map;
    }

    //map 총 더하기, 0이 아닌 갯수 구하기
    public static double[] sumMap(int arr[][]) {
        double resultarr[] = new double[2];
        int result = 0;
        int count = 0;

        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                if(arr[i][j] != 0) {
                    count++;
                }
                result = result + arr[i][j];
            }
        }

        resultarr[0] = result;
        resultarr[1] = count;
        return resultarr;

    }

    public static class Node {
        public Node(int col, int row, int value) {
            this.col = col;
            this.row = row;
            this.value = value;
        }
        int col;
        int row;
        int value;

    }

    public static void printmap(int arr[][]) {
        for(int i=0;i<arr.length;i++) {
            for(int j=0;j<arr[0].length;j++) {
                System.out.printf(arr[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-------------------");
    }

}
