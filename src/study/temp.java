package study;

import java.util.*;

class temp {
    public static void main(String[] args) {
        String brackets = "";
        Stack<String> stack = new Stack<>();
        

        int cnt = 0;
        String bracketsArr[] = brackets.split("");
        for (cnt = 0; cnt < brackets.length(); cnt++) {
            boolean isIncorrect = false;

            switch (bracketsArr[cnt]) {
                case "(":
                case "{":
                case "[":
                    stack.push(bracketsArr[cnt]);
                    break;

                case ")":
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        isIncorrect = true;
                    }
                    break;

                case "}":
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        isIncorrect = true;
                    }
                    break;

                case "]":
                    if (stack.isEmpty() || !stack.pop().equals("(")) {
                        isIncorrect = true;
                    }
                    break;
            }

            if (isIncorrect) {
                break;
            }
        }

        if (stack.isEmpty() && cnt == bracketsArr.length) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}