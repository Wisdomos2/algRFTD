package Kakao2019;

public class failPercent {
    public static void main(String[] args) {
        int N1 = 5;
        int input1[] = {2, 1, 2, 6, 2, 4, 3, 3};

        int N2 = 4;
        int input2[] = {4,4,4,4,4};

        for(int i : Solution(N1,input1)) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i : Solution(N2,input2)) {
            System.out.printf(i + " ");
        }

        return;
    }

    static int[] Solution(int N, int[] stages) {
        int[] answer = new int[N];
        float failValue[] = new float[N];


        for(int i=0; i<N; i++) {
            int checkStage = i+1;
            int nopeople = 0;
            int okpeople = 0;
            for(int j=0;j<stages.length;j++) {
                if(stages[j] <= checkStage) {
                    nopeople++;
                }
                else if(stages[j] > checkStage) {
                    okpeople++;
                }
            }
            System.out.println("okpeole : " + okpeople);
            System.out.println("nopeople : " + nopeople);
            if(okpeople == 0) {
                failValue[i] = 0;
            }
            else {
                failValue[i] = nopeople/okpeople;
            }
        }

        for(double test : failValue) {
            System.out.printf(test + " " );
        }

        return answer;
    }
}
