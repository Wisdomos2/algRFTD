package study;

/*
    지형편집
    Binary Search / CustomizeMap_Prg
    소요 시간 : 45분 (뻘짓..)
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
        1. Map으로 정렬한 뒤 가장 많은 레벨의 블록 수를 기준으로 맞춰봄. -> TestCase 성공, 부분 실패
        2. 완탐 -> 시간초과
        3. 이분탐색 -> 성공
        뻘짓 지렷꾸
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


        long mid = 0;

        while(minBlock <= maxBlock) {

            mid = (minBlock+maxBlock)/2;

            if(minBlock == maxBlock) {
                break;
            }

            long resultOfleft = calculation(land,P,Q,mid);
            long resultOfright = calculation(land,P,Q,mid+1);

            if(resultOfleft < resultOfright) {
                maxBlock = mid;
            }
            else if(resultOfleft > resultOfright){
                minBlock = mid + 1;
            }
            else {
                break;
            }
        }
        answer = calculation(land,P,Q,mid);

        return answer;
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
