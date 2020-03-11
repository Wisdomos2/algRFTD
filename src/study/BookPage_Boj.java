package study;

import java.util.Scanner;

public class BookPage_Boj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int result[] = solution(N);
        for(int i: result) {
            System.out.printf(i + " ");
        }
        return;
    }

    private static int[] solution(int N) {
        int result[] = new int[10];
        int positionValue = (int)(Math.log10(N)+1);
        int startPageStep = 1;

        int startIndex = 1;

        while(startPageStep <= positionValue) {
            while(N%10 != 9 && startIndex <= N) {
                int tempPage = N;
                while(tempPage > 0) {
                    result[tempPage%10] += (int)Math.pow(10,startPageStep-1);
                    tempPage = tempPage / 10;
                }
                N--;
            }

            if(N < startIndex) {
                break;
            }

            while(startIndex%10 != 0 && startIndex <= N) {
                int tempIndex = startIndex;
                while(tempIndex > 0) {
                    result[tempIndex%10] += (int)Math.pow(10,startPageStep-1);
                    tempIndex = tempIndex / 10;
                }
                startIndex++;
            }

            startIndex = startIndex / 10;
            N = N / 10;
            for(int i=0;i<result.length;i++) {
                result[i] = result[i] + (N - startIndex +1 ) * (int)Math.pow(10,startPageStep-1);
            }
            startPageStep++;
        }


        return result;
    }
}
