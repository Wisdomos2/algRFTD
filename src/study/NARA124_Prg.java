package study;

import java.util.LinkedList;
import java.util.Queue;

public class NARA124_Prg {
    public static void main(String[] args) {
        int n1 = 1;
        int n2 = 2;
        int n3 = 3;
        int n4 = 10;

       // System.out.println(solution(n1));
       // System.out.println(solution(n2));
       // System.out.println(solution(n3));
        System.out.println(solution(53535));

        return;
    }

    public static String solution(int n) {
        /*
        * 큐사용하지 않고 해보기. 5000000이라는 조건 다 넘겨야함.
        * 3의 1승 , 3의 2승 식으로 반복횟수가 증가됨.
        * */
        String answer = null;

        String arr[] = new String[n];
        Queue<String> q = new LinkedList<String>();
        arr[0] = "1";
        arr[1] = "2";
        arr[2] = "4";

        if(n < 4) {
            answer = arr[n-1];
            return answer;
        }

        q.add(arr[0]);
        q.add(arr[1]);
        q.add(arr[2]);

        String info[] = {"1","2","4"};
        for(int i=3;i<n;) {
            int qsize = q.size();
            for(int k=0;k<qsize;k++) {
                String getNum = q.poll();
                for(int j=0;j<3;j++) {
                    arr[i+j] = getNum + ""+ info[j];
                    if(i+j == n-1) {
                        answer = arr[i+j];
                        return answer;
                    }
                    q.add(arr[i+j]);
                }
                i = i+3;
            }
        }

        return answer;
    }


}
