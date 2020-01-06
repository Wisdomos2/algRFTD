package study;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/17142
     연구소3 / DFS / Virus_Boj
 */
public class Virus_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputParams[] = br.readLine().split(" ");
        N = Integer.parseInt(inputParams[0]);
        M = Integer.parseInt(inputParams[1]);

        //init
        map = new int[N][N];
        virusNode = new ArrayList<>();

        for(int i=0;i<N;i++) {
            String inputMaps[] = br.readLine().split(" ");
            for(int j=0;j<N;j++) {
                map[i][j] = Integer.parseInt(inputMaps[j]);
                if(map[i][j] == 2) {
                    virusNode.add(new Node(i,j));
                }
                if(map[i][j] == 0) {
                    leftZero++;
                }
            }
        }

        virusCase = new boolean[virusNode.size()];
        getCase(0,0);

        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(result);
        }
        br.close();
        return;

    }

    static int N;
    static int M;
    static int leftZero = 0;
    static int map[][];
    static ArrayList<Node> virusNode;
    static boolean virusCase[];
    static int result = Integer.MAX_VALUE;

    //경우의 수 구하기
    static void getCase(int index, int depth) {
        if(depth == M) {
            //활성 바이러스 수와 같을 때 퍼트리기 시작.
            int getResult = getSeconds();
            if (getResult > -1) {
                result = Math.min(result,getResult);
            }
        }
        else {
            for(int i=index;i<virusCase.length;i++) {
                virusCase[i] = true;
                getCase(i+1,depth+1);
                virusCase[i] = false;
            }

        }

    }

    static int getSeconds() {

        int dr[] = {1,-1,0,0};
        int dc[] = {0,0,1,-1};
        int resultSecond = 0;
        // true 인 index 를 가져와서 맨 처음에 퍼트려주고 1초를 증가 시킴.
        // 초증가 후 visted배열로 다른지 같은지 확인(Queue사이즈로도 확인가능.) -> 같다? 초 리턴하고 끝.
        boolean visited[][] = new boolean[N][N];
        Queue<Node> queue = new LinkedList<>();

        //최초 M개의 활성 바이러스 셋팅
        for(int i=0;i<virusCase.length;i++) {
            if(virusCase[i]) {
                Node node = virusNode.get(i);
                visited[node.row][node.col] = true;
                queue.add(node);
            }
        }

        //'초'별 변수
        int leftZeroLocal = leftZero;
        int stepSecond = queue.size();
        while(leftZeroLocal > 0) {
            for(int i=stepSecond;i>0;i--) {
                Node node = queue.poll();
                int nowRow = node.row;
                int nowCol = node.col;

                for(int k=0;k<4;k++) {
                    int nextRow = nowRow + dr[k];
                    int nextCol = nowCol + dc[k];
                    if(nextRow > -1 && nextRow < N && nextCol > -1 && nextCol < N) {
                        //일반 빈칸.
                        if(map[nextRow][nextCol] == 0 && !visited[nextRow][nextCol]) {
                            visited[nextRow][nextCol] = true;
                            leftZeroLocal = leftZeroLocal - 1;
                            queue.add(new Node(nextRow,nextCol));
                        }
                        //다음 칸이 비활성 바이러스 일때. -> 활성화로 바꿔줌.
                        //★ 문제 잘.읽.을.것.
                        else if(map[nextRow][nextCol] == 2 && !visited[nextRow][nextCol]) {
                            visited[nextRow][nextCol] = true;
                            queue.add(new Node(nextRow,nextCol));
                        }

                    }
                }

            }
            //빈자리COUNT가 남았는데 큐가 비어있음
            if(queue.isEmpty() && leftZeroLocal > 0) {
                return -1;
            }

            stepSecond = queue.size();
            resultSecond++;

        }



        return resultSecond;
    }


    static class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    /*
        반례
        5 3
2 2 2 0 0
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
answer : 2

4 2
0 1 1 0
2 1 1 2
2 1 1 2
0 1 1 0
answer : 2

5 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
2 0 0 2 0
1 1 1 1 1
answer : 2

5 1
1 1 1 1 1
1 1 1 1 1
1 1 1 1 1
0 2 0 2 0
1 1 1 1 1
answer : 3

5 1
2 2 2 1 1
2 1 1 1 1
2 1 1 1 1
2 1 1 1 1
2 2 2 2 0
answer : 1

4 1
2 1 1 1
1 1 1 1
1 1 1 1
1 1 1 1
answer : 0
     */

}
