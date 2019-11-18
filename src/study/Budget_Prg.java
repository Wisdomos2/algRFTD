package study;

import java.util.Arrays;

public class Budget_Prg {
    public static void main(String[] args) {
        int input[] = {120, 110, 140, 150};
        int input2[] = {1,2,3,4,5,6,7,8,8};
        int M = 485;

        System.out.println(solution(input,M));
        return;
    }


    /* 효율성 2번 -> 모든배열에서 sum하는 부분 Overflow 발생, int -> long으로 바꿔줌.
    * */
    public static int solution(int[] budgets, int M) {
        int answer = 0;
        long sum = 0;
        int min = 0;
        int max = 0;
        int mid = 0;
        int beforemid = 0;
        Arrays.sort(budgets);


        for(int i : budgets) {
            sum += i;
        }

        // min , max
        min = (int)Math.floor(M / budgets.length);

        max = budgets[budgets.length-1];
        // 1. 조건, 처음에는 합산값을 return 해야하는 줄알아서 통과 못했었음. 최대값 넘겨주면 됨.
        if(sum <= M) {
            return budgets[budgets.length-1];
        }

        //2. 조건
        else {
            while(true) {
                // mid
                mid = (int)Math.ceil((max+min)/2);
                /* if lower than mid(base), add budget element.
                   else if bigger than mid(base), add mid */
                sum = 0;
                for(int i : budgets) {
                    if(i > mid) {
                        sum += mid;
                    }
                    else {
                        sum += i;
                    }
                }

                // never change, break
                if(mid == beforemid) {
                    answer = mid;
                    break;
                }

                //mid is bigger than base, max move max to mid.
                if(sum > M) {
                    max = mid;
                }
                //mid is bigger than base, min move min to mid.
                else {
                    min = mid;
                }

                //Not only mid, beforemid aren't same but also working is done.
                beforemid = mid;


            }
        }

        return answer;
    }

}
