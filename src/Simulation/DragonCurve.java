package Simulation;

import java.util.ArrayList;
import java.util.Scanner;

public class DragonCurve {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int infoArr[][] = new int[N][4];

        for(int i=0;i<N;i++) {
            infoArr[i][0] = sc.nextInt();
            infoArr[i][1] = sc.nextInt();
            infoArr[i][2] = sc.nextInt();
            infoArr[i][3] = sc.nextInt();
        }

        solution(infoArr);
        sc.close();
        return;
    }

    public static void solution(int infoArr[][]) {
        boolean map[][] = new boolean[101][101];
        int count = 0;

        for(int i=0;i<infoArr.length;i++) {
            int x = infoArr[i][0];
            int y = infoArr[i][1];
            int d = infoArr[i][2];
            int g = infoArr[i][3];

            ArrayList<Integer> list = new ArrayList<Integer>();

            list.add(d);
            //해당세대까지, 방향에 근거한 커브만들기
            for(int j=1;j<=g;j++) {
                for(int k=list.size()-1;k>=0;k--) {
                    int a = list.get(k) == 3 ? 0 : list.get(k) + 1;
                    list.add(a);
                }
            }

            int nowX = x;
            int nowY = y;
            //맵에 새기기
            map[nowY][nowX] = true;
            for(int j=0; j<list.size();j++) {
                int direcion = list.get(j);

                if(direcion == 0) {
                    nowX = nowX + 1;
                }
                else if(direcion == 1) {
                    nowY = nowY - 1;
                }
                else if(direcion == 2) {
                    nowX = nowX - 1;
                }
                else if(direcion == 3) {
                    nowY = nowY + 1;
                }
                map[nowY][nowX] = true;
            }

        }
        //탐색하면서 사각형 찾기 -> 100은 탐색안하는 이유 : 맵끝은 사각형을 구성할 수 없음
        for(int a=0; a<100;a++) {
            for(int b=0;b<100;b++) {
                if(map[a][b] && map[a][b+1] && map[a+1][b] && map[a+1][b+1]) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
