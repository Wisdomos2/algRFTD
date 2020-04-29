package temp;

import javax.naming.PartialResultException;
import java.util.Arrays;

public class DevCamp3 {
    public static void main(String[] args) {
        int numbers[] = {3, 7, 2, 8, 6, 4, 5, 1};
        int k = 3;
        System.out.println(solution(numbers,k));
    }
    public static int solution(int[] numbers,int K){
        int answer = 0;

        int checkArr[] = numbers.clone();
        Arrays.sort(checkArr);

        int checkMin = 0;
        for(int i=0;i<checkArr.length;i++) {
            checkMin = Math.max(checkMin,checkArr[i]);
        }
        if(checkMin > K) {
            return -1;
        }


        for (int i = 1; i < numbers.length; i++) {
            int standard = numbers[i];
            int index = i - 1;

            while (index >= 0 && Math.abs(standard-numbers[index]) < K) {
                numbers[index + 1] = numbers[index];
                index--;
                answer++;
            }
            numbers[index + 1] = standard;  // 기준값 저장
        }


        return answer;

    }

}
