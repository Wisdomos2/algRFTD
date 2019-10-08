package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Wheel14891_Boj {
    static int wheels[][] = new int[5][8];
    static boolean visited[] = null;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        /*
            12시부터 순서대로, N극 0, S극 1 , 다른극이면 반대로 회전 , 같은 극이면 회전안함
            모두 회전시킨 후 12시방향, [0]의 합을 구함 12시가 N이면 0점, S이면 1번부터 순서대로 1,2,4,8점
            회전수 K, 톱니바퀴번호 / 1은 시계방향 -1은 반시계반향
         */

        for(int i=1;i<5;i++) {
            String temp[] = bf.readLine().split("");
            for(int j=0;j<8;j++) {
                wheels[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int turnsGet = Integer.parseInt(bf.readLine());
        for(int i=0;i<turnsGet;i++) {
            String temp2[] = bf.readLine().split(" ");
            int wheelNum = Integer.parseInt(temp2[0]);
            int direction = Integer.parseInt(temp2[1]);


            visited = new boolean[5];
            workingturn(wheelNum,direction);

        }

        int sum = 0;
        for(int i=1;i<=4;i++) {
            if(wheels[i][0] == 0) {
                continue;
            }
            else {
                int add = (int)Math.pow(2,i-1);
                sum += add;
            }
        }
        System.out.println(sum);

        bf.close();
        return;



    }
    /*
        입력받은 것에 3시 9시 정보를 받고 턴대로 shift 한다. (2,6)
        양 옆의 것과 비교 - 작아지는거는 3시, 9시와 비교. 커지는건 9시와 3시 비교.
        같으면 작업하지 않고 끝, 다르면 방향바꿔서 working turn 다시 실행.
     */
    public static void workingturn(int wheelNum, int direction) {
        int nowLeft = wheels[wheelNum][6];
        int nowRight = wheels[wheelNum][2];
        int nextdirection = 0;


        visited[wheelNum] = true;
        shiftWheel(wheelNum,direction);

        //다음 바퀴는 반향이 정반대
        if(direction == 1) {
            nextdirection = -1;
        } else if (direction == -1) {
            nextdirection = 1;
        }

        //갔다가 또올 가능성이 있다. 이걸 배제시켜주어야한다.

        //왼쪽
        if(wheelNum-1 > 0 && nowLeft != wheels[wheelNum-1][2] && visited[wheelNum-1] == false) {
            workingturn(wheelNum-1, nextdirection);
        }
        //오른쪽
        if(wheelNum+1 < 5 && nowRight != wheels[wheelNum+1][6] && visited[wheelNum+1] == false) {
            workingturn(wheelNum+1,nextdirection);
        }
        return;
    }

    public static void shiftWheel(int wheelNum, int direction) {
        // 시계 방향 >>>
        if(direction == 1) {
            int last = wheels[wheelNum][7];
            for(int i=7;i>0;i--) {
                wheels[wheelNum][i] = wheels[wheelNum][i-1];
            }
            wheels[wheelNum][0] = last;
        }
        // 반시계방향 <<<
        else if(direction == -1) {
            int first = wheels[wheelNum][0];
            for(int i=1;i<8;i++) {
                wheels[wheelNum][i-1] = wheels[wheelNum][i];
            }
            wheels[wheelNum][7] = first;
        }

        return;

    }
}
