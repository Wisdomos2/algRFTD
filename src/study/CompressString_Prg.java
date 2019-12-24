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

    public static int solution(String s) {
        int answer = s.length();

        for(int i=1;i<=s.length()/2;i++) {
            int index = 0;
            int length = s.length();
            while(index+i <= s.length()) {
                String partition = s.substring(index,index+i);
                index = index + i;

                int count = 0;
                while(index + i <= s.length()) {
                    if(partition.equals(s.substring(index, index+i))) {
                        count++;
                        index = index+i;
                    }
                    else {
                        break;
                    }
                }

                if(count > 0) {
                    length = length - (i*count);
                    //1자리 인경우
                    if(count < 9) {
                        length = length + 1;
                    }
                    else if(count < 99) {
                        length = length + 2;
                    }
                    else if(count < 999) {
                        length = length + 3;
                    }
                    else {
                        length = length + 4;
                    }
                }
            }
            answer = Math.min(answer,length);
        }

        return answer;

    }

}
