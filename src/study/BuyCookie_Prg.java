package study;
/*
    쿠키구입 / Implement
    https://programmers.co.kr/learn/courses/30/lessons/49995?language=java
 */
public class BuyCookie_Prg {
    public static void main(String[] args) {
        int cookie1[] = {1,1,2,3};
        int cookie2[] = {1,2,4,5};
        System.out.println(solution(cookie1));
        System.out.println(solution(cookie2));
        return;
    }


    public static int solution(int[] cookie) {
        int answer = -1;

        /*
            양쪽으로 작은 쪽을 하나씩 증가시켜보는 방법.
            긴가 민가해서 해봤는데 됐음.
            의문점이 드는것은 왼쪽거 다 더해서 가야 오른쪽 맨끝과 같을경우는?
            어차피 for문돌기 땜에 된다. 먼저 생각했던 3중 포문과 다를 것이 없음.
            대신 모두다 순차적으로 하지 않고 조건에 따라 분기시켜주었기 떄문에 빠름.
         */

        for(int i=0;i<cookie.length-1;i++) {
            int fssum = cookie[i];
            int sssum = cookie[i+1];

            // 첫째는 << 이쪽으로
            int findex = i;
            // 둘째는 >> 으로
            int sindex = i+1;

            while (true) {
                if(fssum == sssum) {
                    answer = Math.max(answer, (sssum+fssum)/2);
                }
                if(findex > 0 && fssum <= sssum) {
                    findex--;
                    fssum += cookie[findex];
                }
                else if(sindex < cookie.length-1 && fssum >= sssum) {
                    sindex++;
                    sssum += cookie[sindex];
                }
                else {
                    break;
                }
            }

        }

        if(answer == -1) {
            return 0;
        }

        return answer;

//        for(int i=0;i<cookie.length-1;i++) {
//            int firstSonSum = 0;
//
//            for(int firstSon = i; firstSon < cookie.length-1; firstSon++) {
//                firstSonSum += cookie[firstSon];
//                int secondSonSum = 0;
//
//                for(int secondSon = firstSon + 1; secondSon < cookie.length; secondSon++) {
//                    secondSonSum += cookie[secondSon];
//                    if(secondSonSum > firstSonSum) {
//                        break;
//                    }
//                    if(secondSonSum == firstSonSum && secondSon != 0 && firstSon != 0) {
//                        answer = Math.max(answer,secondSonSum);
//                    }
//
//                }
//            }
//        }
//
//        if(answer == -1) {
//            return 0;
//        }
//
//        return answer;
    }
}
