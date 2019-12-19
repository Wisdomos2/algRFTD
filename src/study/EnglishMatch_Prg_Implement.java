package study;

import java.util.ArrayList;
import java.util.Map;

public class EnglishMatch_Prg_Implement {
    /*
    * ㅈ같은 프로그래머스 바꾸는방법
    * 1. 첫번째 String[0]에서 띄어쑤기 하나해줌
    * 2. 공백 -> " 으로 바꿔줌.
    * 3. , -> ", 으로 바꿔주고 맨마지막에 " 하나 더 붙여줌.
    * */
    public static void main(String[] args) {
        int n1 = 3;
        String word1[] = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"};
        for(int i : solution(n1,word1)) {
            System.out.println(i);
        }

        int n2 = 5;
        String word2[] = {"hello","observe","effect","take","either","recognize","encourage","ensure","establish","hang","gather","refer","reference","estimate","executive"};
        for(int i : solution(n2,word2)) {
            System.out.println(i);
        }

        int n3 = 2;
        String word3[] = {"hello","one","even","never","now","world","draw"};
        for(int i : solution(n3,word3)) {
            System.out.println(i);
        }

    }

    public static int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        ArrayList<String> list = new ArrayList<>();
        list.add(words[0]);

        int maxCnt = 2;
        // list에 없어야한다 -> 중복X
        // 이전 index의 끝자리와 현재 앞자리가 같아야한다.
        // 몇번쨰놈, 차례( 전체를 뭘로 계산?)
        for(int i=1;i<words.length;i++) {
            if(maxCnt > n) {
                maxCnt = 1;
            }
            if(list.contains(words[i]) || !check(list.get(i-1),words[i])) {
                //해당 index하고 끝
                answer[1] = (i/n)+1;
                answer[0] = maxCnt;
                break;
            }
            else {
                list.add(words[i]);
                maxCnt++;
            }
        }


        //만약 주어진 단어들로 탈락자가 생기지 않는다면, [0, 0]을 return 해주세요.
        if(list.isEmpty()) {
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }

    private static boolean check(String s, String word) {
        if(s.charAt(s.length()-1) == word.charAt(0)) {
             return true;
        }
        return false;
    }
}
