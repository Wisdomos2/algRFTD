package temp;

import java.util.HashMap;
import java.util.Map;

public class esoft4 {
    public static void main(String[] args) {
        System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker","Example"));
    }
    public static String solution(String S, String C) {
        // write your code in Java SE 8
        // Last_Fist@company
        Map<String,Integer> checkName = new HashMap<>();

        String people[] = S.split("; ");
        String result[] = new String[people.length];

        String alphaCompany = "@"+C.toLowerCase()+".com";

        for(int i=0;i<people.length;i++) {
            String spilitName[] = people[i].split(" ");
            String emailName = spilitName[spilitName.length-1].toLowerCase()+"_"+spilitName[0].toLowerCase();
            if(checkName.containsKey(emailName)) {
                checkName.replace(emailName, checkName.get(emailName)+1);
                emailName = emailName + checkName.get(emailName);
            }
            else {
                checkName.put(emailName,1);
            }
            emailName = emailName.replace("-","");
            String finalResult = people[i] + " " + "<" + emailName + alphaCompany + ">";
            result[i] = finalResult;
        }

        String resultString = "";



        for(int i=0;i<result.length;i++) {
            if(i== result.length-1) {
                resultString = resultString + result[i];
            }
            else {
                resultString = resultString + result[i] + "; ";
            }
        }

        return resultString;
    }
}
