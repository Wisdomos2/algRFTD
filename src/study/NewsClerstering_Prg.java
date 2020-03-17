package study;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewsClerstering_Prg {
    public static void main(String[] args) {
        String str1 = "FRANCE";
        String str2 = "french";
        System.out.println(solution(str1,str2));


        String str3 = "handshake";
        String str4 = "shake hands";
        System.out.println(solution(str3,str4));


        String str5 = "aa1+aa2";
        String str6 = "AAAA12";
        System.out.println(solution(str5,str6));


        String str7 = "E=M*C^2";
        String str8 = "e=m*c^2";
        System.out.println(solution(str7,str8));

    }

    public static int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = divideStr(str1);
        ArrayList<String> list2 = divideStr(str2);

        if(list1.size() < 1 && list2.size() < 1) {
            return 65536;
        }

        answer = getScore(list1,list2);

        return answer;
    }
    public static ArrayList<String> divideStr(String str) {
        ArrayList<String> list = new ArrayList<>();
        for(int i=0;i<str.length()-1;i++) {
            if(Character.isLetter(str.charAt(i))) {
                if(Character.isLetter(str.charAt(i+1))) {
                    String inputStr = str.substring(i,i+2);
                    list.add(inputStr);
                }
            }
        }
        return list;

    }

    public static int getScore(ArrayList<String> list1, ArrayList<String> list2) {
        ArrayList<String> compareListHead = new ArrayList<>();
        double under = list1.size() + list2.size();

        for(int i=0;i<list1.size();i++) {
            String compareString = list1.get(i).toLowerCase();
            for(int j=0;j<list2.size();j++) {
                if(compareString.equals(list2.get(j).toLowerCase())) {
                    compareListHead.add(list2.get(j));
                    list2.remove(j);
                    break;
                }
            }
        }


        double head = compareListHead.size();
        under = under - head;

        double result = (compareListHead.size()/under) * 65536;

        return (int)result;
    }


}
