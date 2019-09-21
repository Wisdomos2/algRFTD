package Implement;
/*
    https://www.acmicpc.net/problem/15956
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

//a==b&&b==c&&c==a
public class ShortCoding15956_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine(),"&&");
        ArrayList equal = new ArrayList();
        ArrayList notEqual = new ArrayList();


        while(st.hasMoreTokens()) {
            String temp = st.nextToken();
            String temp2[] = temp.split("==");
            if(temp2.length == 1) {
                /* != 일때  */
                temp2 = temp.split("!=");
                notEqual.add(temp2[0]);
                notEqual.add(temp2[1]);
            }
            else {
                equal.add(temp2[0]);
                equal.add(temp2[1]);
            }
        }

        String result = "";

        if(equal.size() > 2) {
            for(int i=0;i<equal.size();i+=2) {
                String first = String.valueOf(equal.get(i));
                String second = String.valueOf(equal.get(i+1));
                if(first.equals(second)) continue;
                for(int j=i+2;j<equal.size();j++) {
                    if(equal.get(j).equals(first)) {
                        equal.set(j,second);
                    }
                }
                result = result + first + "==" + second + "&&";
            }
        }
        else if (equal.size() == 2){
            result = result + equal.get(0) + "==" + equal.get(1) + "&&";
        }

        if(notEqual.size() > 2) {
            for(int i=0;i<notEqual.size();i+=2) {
                String first = String.valueOf(notEqual.get(i));
                String second = String.valueOf(notEqual.get(i+1));
                if(first.equals(second)) continue;
                for(int j=i+2;j<notEqual.size();j++) {
                    if(notEqual.get(j).equals(first)) {
                        notEqual.set(j,second);
                    }
                }
                result = result + first + "!=" + second + "&&";

            }
        }
        else if (notEqual.size() == 2){
            result = result + notEqual.get(0) + "!=" + notEqual.get(1) + "&&";
        }
        if(result.charAt(result.length()-1) == '&') {
            result = result.substring(0,result.length()-2);
        }
        System.out.println(result);


    }
}
