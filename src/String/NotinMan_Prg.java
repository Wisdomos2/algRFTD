package String;

import java.util.Arrays;

public class NotinMan_Prg {
    public static void main(String[] args) {
        String input1[] = {"leo", "kiki", "eden"};
        String input2[] = {"eden", "kiki"};
        System.out.println(solution(input1,input2));
    }
    public static String solution(String[] participant, String[] completion) {
        String answer = "";
        Arrays.sort(participant);
        Arrays.sort(completion);

        for(int i=0;i<participant.length;i++) {
            if(i==completion.length) {
                answer = participant[participant.length-1];
                return answer;
            }
            else {
                if(!participant[i].equals(completion[i])) {
                    answer = participant[i];
                    return answer;
                }
            }
        }

        return answer;
    }
}
