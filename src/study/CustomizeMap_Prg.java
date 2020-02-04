package study;

import java.util.*;

/*
    지형편집
    ??? / CustomizeMap_Prg
    소요 시간 :
    https://programmers.co.kr/learn/courses/30/lessons/12984
 */
public class CustomizeMap_Prg {
    public static void main(String[] args) {
        int land1[][] = {{1, 2}, {2, 3}};
        int p1 = 3;
        int q1 = 2;

        System.out.println(solution(land1,p1,q1));

        int land2[][] = {{4, 4, 3}, {3, 2, 2}, { 2, 1, 0 }};
        int p2 = 5;
        int q2 = 3;

        System.out.println(solution(land2,p2,q2));
    }

    /*
        역시나 완탐은 또 시간초과가 뜸.
        시간초과이기에 이분탐색으로 죠져봄.
     */
    public static long solution(int[][] land, int P, int Q) {
        long answer = -1;

        long minBlock = Integer.MAX_VALUE;
        long maxBlock = Integer.MIN_VALUE;

        for(int i=0;i<land.length;i++) {
            for(int j=0;j<land[0].length;j++) {
                minBlock = Math.min(minBlock, land[i][j]);
                maxBlock = Math.max(maxBlock, land[i][j]);
            }
        }

        long midBlock = 0;
        while(minBlock<=maxBlock) {
            if(minBlock == maxBlock) {
                break;
            }
            midBlock = (minBlock+maxBlock)/2;
            long resultOfleft = calculation(land,P,Q,midBlock);
            long resultOfright = calculation(land,P,Q,midBlock+1);
            if(resultOfleft == resultOfright) {
                break;
            }
            else if(resultOfleft < resultOfright) {
                maxBlock = midBlock;
            }
            else  {
                minBlock = midBlock + 1;
            }
        }

        return calculation(land,P,Q,midBlock);
    }

    private static long calculation(int land[][], int P, int Q, long value) {
        long result = 0;
        for(int i=0;i<land.length;i++) {
            for(int j=0;j<land[0].length;j++) {
                if(land[i][j] > value) {
                    result = result + (land[i][j] - value)*Q;
                }
                else if(land[i][j] < value) {
                    result = result + (value - land[i][j])*P;
                }
            }
        }

        return result;
    }


}
