package study;

import java.util.Arrays;
import java.util.Comparator;

public class Camera_Prg {
    public static void main(String[] args) {
        int input[][] = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}};
        System.out.println(solution(input));
        return;
    }

    /*
        도로에서 가장 빨리 진출하는 기준으로 정렬.
        제일 처음 진출하는 차량이 기준이 됨.
        다음 차량의 진입점이 이전 차량의 진출지점 보다 작으면 같은 섹터임.
        이전 차량의 진출지점보다 크다면 같은 섹터가 아니므로 카메라를 설치해주고,
        다음 차량의 진출지점을 다시 기준으로 잡음.
        (가능한 이유는 정렬을 했기 때문.)

        가장 빨리 진출하는 차량보다 다른 차량의 시작점이 작다면 같은 섹터로써 1개만 설치하면 됨.
        같은 것은 무시.
        반복문 돌다가 다른 차량의 시작점이 진출점보다 크다면 같은 섹터가 아니므로 카메라 설치해주고
        그 차량의 진출점으로 진출 변수를 갱신해줌.

     */

    public static int solution(int[][] routes) {
        int answer = 0;

        // routes[i][0] 을 기준으로 정렬.
        Arrays.sort(routes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });
        /*
        o1[1] o2[1] 일 때, 마지막점 기준
          */
        int end = Integer.MIN_VALUE;
        for(int i=0;i<routes.length;i++) {
            if(end < routes[i][0]) {
                answer++;
                end = routes[i][1];
            }
        }
        return answer;
    }
}
