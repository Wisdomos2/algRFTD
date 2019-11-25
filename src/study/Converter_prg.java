package study;

import java.util.Stack;

public class Converter_prg {
    public static void main(String[] args) {

        System.out.println(solution("(()())()").equals("(()())()"));
        System.out.println(solution(")(").equals("()"));
        System.out.println(solution("()))((()").equals("()(())()"));
        return;

    }

    public static String solution(String p) {
        String answer = "";

        answer = convert(p);

        return answer;
    }

    public static String convert(String w) {
        String result = "";
        // #Condition 1.
        if(w.equals("")) {
            return result;
        }
        // #Condition 2. =divide
        else {
            String u = "";
            String v = "";
            String wTemp[] = w.split("");
            // 최초 문자 count
            int cnt = 0;
            String before = "";
            for(int i=0;i<wTemp.length;i++) {
                // 최초 문자 setting
                if(i == 0) {
                    u = wTemp[i];
                    before = u;
                    cnt++;
                }
                else {
                    // 균형문자 만족하면 u,v만들어주고 반복문 끝.
                    if(cnt == 0) {
                        for(int j=i;j<wTemp.length;j++) {
                            v = v + wTemp[j];
                        }
                        break;
                    }
                    // 이전문자와 같으면 count++;
                    if(wTemp[i].equals(before)) {
                        u = u + wTemp[i];
                        cnt++;
                    }
                    // 이전문자와 다르면 count--; -> 균형조건맞춰감.
                    else if(!wTemp[i].equals(before)){
                        u = u + wTemp[i];
                        cnt--;
                    }
                }
            }
            //end divide
            //#Condition 3. u -> 올바르다면 3-1
            if(rightcheck(u)) {
                result = u + convert(v);
            }
            //#Condition 4. u -> 올바르지 않다면 4-1 ~ 4-5
            else {
                String prepareString = "(" + convert(v) + ")";
                u = u.substring(1,u.length()-1);

                /*
                    괄호 뒤집기. reverse가 아니고 괄호방향만 바꾸는거임.
                    (()))
                    ( -> 0 : 00)))
                    ) -> ( : 00(((
                    0 -> ) : ))(((
                 */
                u = u.replace('(', '0');
                u = u.replace(')','(');
                u = u.replace('0', ')');
                prepareString = prepareString + u;
                result = prepareString;
            }

        }


        return result;
    }

    public static boolean rightcheck(String u) {
        Stack<String> sleft = new Stack<>();

        // 짝 맞으려면 ( 부터 와야함.
        if(u.charAt(0)==')') {
            return false;
        }
        else {
            /*
            stack에  "(" 만 넣어줌.
            ")"을 만나면 "("을 하나씩 없애줌.
             */
            String uTemp[] = u.split("");
            for(int i=0;i<u.length();i++) {
                if(uTemp[i].equals("(")) {
                    sleft.push(uTemp[i]);
                }
                else {
                    if(sleft.empty()) {
                        return false;
                    }
                    else {
                        sleft.pop();
                    }

                }
            }
        }

        //비어있지 않으면 올바르지 못한거임.
        if(!sleft.empty()) {
            return false;
        }

        return true;
    }


}
