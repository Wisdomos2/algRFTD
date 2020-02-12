package study;
/*
    스티커모으기2

 */
public class CollectSticker_Prg {
    public static void main(String[] args) {
        int sticker1[] = {14, 6, 5, 11, 3, 9, 2, 10};
        int sticker2[] = {1, 3, 2, 5, 4};

        System.out.println(solution(sticker1));
        System.out.println(solution(sticker2));
    }
    /*
        HHH   HHH     OOO     LLL      LLL     YYY   YYY
        HHH   HHH  OOO   OOO  LLL      LLL       YY YY
        HHHHHHHHH  OOO   OOO  LLL      LLL        YYY
        HHH   HHH  OOO   OOO  LLLLLL   LLLLLL      Y
        HHH   HHH     OOO     LLLLLL   LLLLLL      Y   Shit 재귀쓰지마 ㅡ지마쓰지마 쓰지마
    */

    public static int solution(int sticker[]) {

        int answer = 0;

        if(sticker.length == 1) {
            return sticker[0];
        }

        int dp1[] = new int[sticker.length];
        int dp2[] = new int[sticker.length];

        dp1[0] = sticker[0];
        dp1[1] = sticker[1];

        for(int i=2;i<sticker.length-1;i++) {
            dp1[i] = Math.max(dp1[i-1], dp1[i-2] + sticker[i]);
        }

        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2;i<sticker.length;i++) {
            dp2[i] = Math.max(dp2[i-1], dp2[i-2] + sticker[i]);
        }

        answer = Math.max(dp1[sticker.length-2], dp2[sticker.length-1]);

        return answer;

    }

//    public static void delete(int sticker[],int depth) {
//        if(depth >= sticker.length) {
//            int sumResult = 0;
//            for(int i=0;i<sticker.length;i++) {
//                if(sticker[i] != 0) {
//                    sumResult += Math.abs(sticker[i]);
//                }
//            }
//            maxValue = Math.max(sumResult, maxValue);
//        }
//        else {
//            for(int i=0;i<sticker.length;i++) {
//                if(sticker[i] > 0) {
//                    int sticker2[] = sticker.clone();
//                    sticker2[i] = sticker2[i] - sticker2[i]*2;
//                    if(i == 0) {
//                        sticker2[1] = 0;
//                        sticker2[sticker2.length-1] = 0;
//                    }
//                    else if(i == sticker2.length-1) {
//                        sticker2[sticker2.length-2] = 0;
//                        sticker2[0] = 0;
//                    }
//                    else {
//                        sticker2[i-1] = 0;
//                        sticker2[i+1] = 0;
//                    }
//                    delete(sticker2, depth+3);
//                }
//            }
//            return;
//        }
//    }

}
