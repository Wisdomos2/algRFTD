package study;

import java.util.LongSummaryStatistics;

public class LookniceSquare_Prg {
    public static void main(String[] args) {
        System.out.println(solution(8,12));

    }

    public static long solution(int w,int h) {
        long answer = 1;

        /*
            최대 공약수 구하기.
            전체 - (((W / 최대 공약수, H / 최대 공약수) - 2) * 최대 공약수)
         */

        long valueOfgcd = gcd(w,h);
        long total = (long)w * (long)h;
        answer = total - valueOfgcd * (w/valueOfgcd + h/valueOfgcd -1);

        return answer;
    }

    //최대 공약수 구하기.
    public static long gcd(long p, long q) {
        if(q == 0) {
            return p;
        }
        return gcd(q, p%q);
    }

    //최소 공배수 구하기.
    public static long lcd(long p, long q) {
        return (p*q)/gcd(p,q);
    }

}
