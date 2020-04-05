package temp;

import java.util.Stack;

public class Line2020no2 {
    public static void main(String[] args) {
        System.out.println(solution(new String("if (Count of eggs is 4.) {Buy milk.}")));
    }
    public static int solution(String inputString) {
        int total = 0;
        Stack<String> a = new Stack<>();

        Stack<String> b = new Stack<>();

        Stack<String> c = new Stack<>();

        Stack<String> d = new Stack<>();

        String inputSringArr[] = inputString.split("");
        for(int i=0;i<inputSringArr.length;i++) {
            if(inputSringArr[i].equals("(")) {
                a.add(inputSringArr[i]);
            }
            else if(inputSringArr[i].equals(")")) {
                if(a.isEmpty()) {
                    return -1;
                }
                a.pop();
                total++;
            }
            else if(inputSringArr[i].equals("{")) {
                b.add(inputSringArr[i]);
            }
            else if(inputSringArr[i].equals("}")) {
                if(b.isEmpty()) {
                    return -1;
                }
                b.pop();
                total++;
            }
            else if(inputSringArr[i].equals("[")) {
                c.add(inputSringArr[i]);
            }
            else if(inputSringArr[i].equals("]")) {
                if(c.isEmpty()) {
                    return -1;
                }
                c.pop();
                total++;
            }
            else if(inputSringArr[i].equals("<")) {
                d.add(inputSringArr[i]);
            }
            else if(inputSringArr[i].equals(">")) {
                if(d.isEmpty()) {
                    return -1;
                }
                d.pop();
                total++;
            }
        }



        return total;
    }
}
