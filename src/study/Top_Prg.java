package study;

public class Top_Prg {
    public static void main(String[] args) {
        int input1[] = {6,9,5,7,4};
        int input2[] = {3,9,9,3,5,7,2};
        int input3[] = {1,5,3,6,7,6,5};

        int output1[] = solution(input1);
        int output2[] = solution(input2);
        int output3[] = solution(input3);
        for(int i : output1) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i : output2) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i : output3) {
            System.out.printf(i + " ");
        }
        System.out.println();
        return;
    }

    /*
    0. 발사한 신호는 신호를 보낸 "탑보다 높은 탑에서만" 수신.
    1. 동시에 레이저 신호를 발사합니다.
    2. 한 번 "수신된 신호는 다른 탑으로 송신되지 않습니다."
     */
    public static int[] solution(int[] heights) {
        // 수신만 기록, 자기보다 높은 탑 , ★★★index 를 기록함.
        // 순서는 오른쪽에서 왼쪽으로.
        int[] answer = {};

        answer = new int[heights.length];
        for(int i=heights.length-1;i>=0;i--) {
            for(int j=i-1;j>=0;j--) {
                if(heights[j] > heights[i]) {
                    answer[i] = j+1;
                    break;
                }
            }
        }

        return answer;
    }
}
