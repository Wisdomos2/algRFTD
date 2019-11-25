package study;

import java.util.Arrays;

/*  studyLink : https://trello.com/c/vrFYApd4
    DP , https://programmers.co.kr/learn/courses/30/lessons/43105
 */
public class Triangle_Prg {
    public static void main(String[] args) {
        int input[][] = {{7}, {3, 8}, {8, 1, 0},{2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(input));

    }

    public static int solution(int[][] triangle) {
        int answer = 0;


        int d[][] = new int[triangle.length][triangle.length];
        /*
          dp 배열 만들기.
          수식 세우기. ( 이전 값과 현재 계산된 값을 비교하여 '최대값'으로 갱신하면서 내려감 )
            ------------------
            7
            3 8
            8 1 0
            2 7 4 4
            4 5 2 6 5
            ------------------
            7 0 0 0 0
            10 15 0 0 0
            18 16 15 0 0
            20 25 20 19 0
            24 30 27 26 24
            ------------------
         */
        d[0][0] = triangle[0][0];
        int height = 1;
        for(int i=0;i<triangle.length-1;i++) {
            for(int j=0;j<height;j++) {
                d[i+1][j] = Math.max(d[i+1][j],d[i][j]+triangle[i+1][j]);
                d[i+1][j+1] = Math.max(d[i+1][j+1],d[i][j] + triangle[i+1][j+1]);
            }
            height++;
        }

        //get max
        for(int i=0;i<height;i++) {
            answer = Math.max(d[triangle.length-1][i],answer);
        }
        return answer;
    }
}
