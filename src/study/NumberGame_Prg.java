package study;

import java.util.*;

/*
    숫자게임
     / NumberGame_Prg
    https://programmers.co.kr/learn/courses/30/lessons/12987
 */
public class NumberGame_Prg {
    /*
        재귀로 경우의 수를 모두 구해서 푸니까 시간초과.
        다른 방법으로 접근함.
        재귀가 아닌 이유는 승점 획득 가능할 경우, 승점을 최대로 획득할 경우는 단 1가지임.
        즉 A가 어떤 순서던 B가 어떤 순서던 승점이 최대로 매칭되는 것은 1가지임.
        B의 최대 값을 구해서 A 내 B보다 작은것들을 지워주고 승점을 증가시켜줌.
     */
    public static void main(String[] args) {

        int A1[] = {5,1,3,7};
        int B1[] = {2,2,6,8};
        int A2[] = {2,2,2,2};
        int B2[] = {1,1,1,1};

        System.out.println(solution(A1,B1));
        System.out.println(solution(A2,B2));
    }

    public static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int score = 0;
        int index = B.length-1;
        for(int i=A.length-1;i>=0;) {
            if(A[i] >= B[index]) {
                i--;
            }
            else {
                score++;
                index--;
                i--;
            }
        }

        return score;
    }



//    static int result = 0;
//    public static int solution(int[] A, int[] B) {
//        int caseTeam[] = new int[A.length];
//
//        // A의 '최소'값이 B의 '최대'값보다 크면 절대 승점 획득 불가.
//        int Amin = Integer.MAX_VALUE;
//        int Bmax = Integer.MIN_VALUE;
//        for(int i=0;i<A.length;i++) {
//            Amin = Math.min(Amin,A[i]);
//            Bmax = Math.max(Bmax,B[i]);
//        }
//        if(Amin >= Bmax) {
//            return 0;
//        }
//
//        getCaseTeamA(A, B, caseTeam, 0);
//
//        return result;
//    }
//
//
//    /*
//        A의 경우의 수를 모두 구한 뒤 B팀과 비교해봄.
//     */
//    private static void getCaseTeamA(int A[], int B[], int caseTeam[], int depth) {
//        if(depth == A.length) {
//            compareTeam(caseTeam,B);
//            return;
//
//        }
//        else {
//            for(int i=0;i<A.length;i++) {
//                if(A[i] == 0) {
//                    continue;
//                }
//                else {
//                    caseTeam[depth] = A[i];
//                    int tempA[];
//                    tempA = A.clone();
//                    tempA[i] = 0;
//                    getCaseTeamA(tempA,B,caseTeam,depth+1);
//                }
//            }
//        }
//
//    }
//
//    private static void compareTeam(int A[], int B[]) {
//        int semi_result = 0;
//        for(int i=0;i<A.length;i++) {
//            if(B[i] - A[i] > 0) {
//                semi_result++;
//            }
//        }
//        result = Math.max(semi_result,result);
//        return;
//    }
}
