package Kakao2019;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class num3 {
    public static void main(String[] args) {
        String words[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String queries[] = {"fro??", "????o", "fr???", "fro???", "pro?"};

        for(int test : Solution(words,queries)) {
            System.out.println(test);
        }
    }
    private static int[] Solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for(int i=0;i<queries.length;i++) {
            String nowQ[] = queries[i].split("");
            int Questions = 0;
            int fb = 1; //0이면 접두 1이면 접미
            String temp = "";

            for(int q=0;q<nowQ.length;q++) {
                if(q == 0 && nowQ[0].equals("?")) {
                    fb = 0;
                }
                if(nowQ[q].equals("?")) {
                    Questions++;
                }
                else if(!nowQ[q].equals("?")){
                    temp = temp + nowQ[q];
                }
            }

            String inputRegex = "";
            // ?가 접두
            if(fb == 0) {
                inputRegex = "(^[a-z]{" + String.valueOf(Questions) + "}" + temp + "$)";
            }
            // ?가 접미
            else {
                inputRegex = "(^" + temp + "[a-z]{" + String.valueOf(Questions) + "}$)";
            }

            Pattern p = Pattern.compile(inputRegex);
            Matcher m = null;

            int count = 0;
            for(int j=0;j<words.length;j++) {
                m = p.matcher(words[j]);
                if(m.find()) {
                    count++;
                }
            }
            answer[i] = count;
        }
        return answer;
    }
}
