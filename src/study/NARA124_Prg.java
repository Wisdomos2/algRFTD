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
        System.out.println(solution(5000000));

        return;
    }

    /*
     10진법 표를 보고 나누기 3을 해서 몫과 나머지를 보고 판단하는 문제 .
     나머지가 1이면 뒤에 왼쪽으로 1을 붙임, 2이면 2를 붙임 나머지가 0이면 4를 붙임, 대신 몫에서 1을 빼줌.
     첨에 브루트포스로 다 만들었다가 ㅈ망함.
     */
    public static String solution(int n) {
        String answer = "";
        String info[] = {"4","1","2"};

        int fv = n;
        int rv = 0;

        while(fv != 0) {
            fv = n/3;
            rv = n%3;

            if(rv == 0) {
                fv -= 1;
            }
            answer = info[rv] + answer;
            n = fv;
        }

        return answer;
    }

}
