package temp;

public class coupang2 {
    public static void main(String[] args) {


        int result = solution(4,7,2,3);
    }

    /*
    * N = 물건 배송 기간
    * M = 배송 물건 개수
    * T = 연속된 날짜 길이
    * K = 연속된 날짜 동안 최대로 배송할 수 있는 물건 개수
    * */

    static int result = 0;
    static int T1 = 0;
    static int K1 = 0;
    static int M1 = 0;
    public static int solution(int N, int M, int T, int K) {
        int answer = -1;

        T1 = T;
        K1 = K;
        M1 = M;

        int days[] = new int[N];
        getCase(days,M,0);
        System.out.println(result);

        return answer = result;
    }

    public static void getCase(int days[], int M, int depth) {
        if(M == 0 || depth >= days.length) {
            if(checkSendAll(days,M1) && checkContinue(days,T1,K1)) {
                for(int i=0;i<days.length;i++) {
                    System.out.printf(days[i] + " ");
                }
                System.out.println();
                result++;
            }
            return;
            //check return
        }
        else {
            for(int i=M;i>=0;i--) {
                days[depth] = i;
                getCase(days,M-i,depth+1);
            }
        }
    }

    public static boolean checkSendAll(int days[], int M) {
        int result = 0;
        for(int i=0;i<days.length;i++) {
            result += days[i];
        }

        if(result == M) {
            return true;
        }
        else {
            return false;
        }

    }

    /*
     * T = 연속된 날짜 길이
     * K = 연속된 날짜 동안 최대로 배송할 수 있는 물건 개수
     */
    public static boolean checkContinue(int days[], int T, int K) {

        for(int i=0;i<days.length;i++) {
            if(i+T <= days.length) {
                int temp = 0;
                for(int j=i;j<i+T;j++) {
                    temp += days[j];
                }
                if(temp > K) {
                    return false;
                }
            }


        }
        return true;
    }
}
