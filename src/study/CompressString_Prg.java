package study;

import java.util.ArrayList;
import java.util.List;

public class CompressString_Prg {
    public static void main(String[] args) {

        String input1 = "aabbaccc";
        String input2 = "ababcdcdababcdcd";
        String input3 = "abcabcdede";
        String input4 = "abcabcabcabcdededededede";
        String input5 = "xababcdcdababcdcd";

        System.out.println(solution(input1));
        System.out.println(solution(input2));
        System.out.println(solution(input3));
        System.out.println(solution(input4));
        System.out.println(solution(input5));


    }
    static List<String> list;
    public static int solution(String s) {
        String Sarray[] = s.split("");
        int answer = Sarray.length;

        int depth = 2;

        for(int i=depth;i<Sarray.length;i++) {

        }


        return answer;
    }
}
