package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Prgtester {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        int accuracy_min = Integer.MAX_VALUE;
        int accuracy_max = Integer.MIN_VALUE;
        int efficiency_min = Integer.MAX_VALUE;
        int efficiency_max = Integer.MIN_VALUE;


        String text = "";

        boolean flag = false; // true - 정확도 / false - 효율성
        while(true) {
            String addString = bf.readLine();
            if(addString.equals("")) {
                System.out.println("정확도 : " + accuracy_min + "ms/" + accuracy_max + "ms");
                System.out.println("효율성 : " + efficiency_min + "ms/" + efficiency_max + "ms");
                return;
            }
            else {
                if(addString.startsWith("효")) {
                    flag = true;
                }
                //정확도
                if(flag == false) {

                }
                //효율성
                else {

                }
            }
        }

        return;
    }
    /*
    정확성  테스트
    테스트 1 〉	통과 (0.76ms, 42.8MB)
    테스트 2 〉	통과 (0.82ms, 42.5MB)
    테스트 3 〉	통과 (0.94ms, 42.9MB)
    테스트 4 〉	통과 (0.98ms, 43.2MB)
    테스트 5 〉	통과 (1.16ms, 43.2MB)
    테스트 6 〉	통과 (1.00ms, 42.9MB)
    테스트 7 〉	통과 (1.20ms, 42.7MB)
    테스트 8 〉	통과 (0.76ms, 43MB)
    테스트 9 〉	통과 (0.74ms, 42.7MB)
    테스트 10 〉	통과 (1.00ms, 43.8MB)
    효율성  테스트
    테스트 1 〉	통과 (12.59ms, 52.6MB)
    테스트 2 〉	통과 (11.95ms, 51.2MB)
    테스트 3 〉	통과 (12.83ms, 53.5MB)
    테스트 4 〉	통과 (12.69ms, 52.1MB)
    테스트 5 〉	통과 (13.21ms, 52.3MB)
    테스트 6 〉	통과 (12.83ms, 53.6MB)
    테스트 7 〉	통과 (17.17ms, 52.7MB)
    테스트 8 〉	통과 (11.96ms, 52MB)
    테스트 9 〉	통과 (12.63ms, 52.5MB)
    테스트 10 〉	통과 (12.49ms, 52.4MB)
     */

}
