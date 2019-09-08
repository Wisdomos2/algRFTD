package Kakao2019;

import java.util.Stack;

public class parentheses_rebuilding {
    public static void main(String[] args) {
        String s = ")(";
        System.out.println(Solution(s));
        return;
    }
    private static String Solution(String p) {
        String answer = "";
        answer = changeArr(p);

        return answer;

    }

    private static String changeArr(String p) {

        if(p.equals("")) {
            return "";
        }
        else {
            String u = "";
            String v = "";
            String tempP[] = p.split("");
            for(int i=0;i< tempP.length;i++) {
                u += tempP[i];
                if(okArr(u)) {
                    if(i == tempP.length-1) {
                        v = "";
                    }
                    else {
                        for(int j=i+1;j< tempP.length;j++) {
                            v += tempP[j];
                        }
                    }
                    break;
                }
            }
            String temp = null;
            if(yesArr(u)) {
                return u + changeArr(v);
            }
            else if(!yesArr(u)) {
                temp = "("  + changeArr(v) + ")";
                u = u.substring(1,u.length()-1);
                u = u.replace(")", "a");
                u = u.replace("(",")");
                u = u.replace("a","(");

                temp = temp + u;
            }
            return temp;
        }
    }

    //균형 ) , ( 수가 같은지
    private static boolean okArr(String p) {
        String temp[] = p.split("");
        int tempLeft = 0;
        int tempRight = 0;

        for(int i=0;i<temp.length;i++) {
            if(temp[i].equals("(")) {
                tempLeft++;
            }
            else if(temp[i].equals(")")) {
                tempRight++;
            }
        }
        if(tempLeft == tempRight) {
            return true;
        }
        else {
            return false;
        }
    }

    // 옳바른지
    private static boolean yesArr(String p) {
        boolean returnValue = true;
        Stack<Character> stack = new Stack<Character>();

        char temp;
        for(int i=0; i<p.length(); i++) {
            temp = p.charAt(i);
            if(temp == '(') {
                stack.push(temp);
            }
            else if(temp == ')') {
                if(!stack.isEmpty()) {
                    stack.pop();
                }
                else {
                    returnValue = false;
                    break;
                }
            }
        }

        if(!stack.isEmpty()) {
            returnValue = false;
        }

        return returnValue;
    }
}
