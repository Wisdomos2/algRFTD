package Implement;

import java.util.Scanner;

public class MoneyHunter15953_Boj {
    static int chell1[][];
    static int chell2[][];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            init
         */
        chell1 = new int[][]{{1,5000000,1,1}, {2,3000000,2,0}, {3,2000000,3,0}, {4,500000,4,0}, {5,300000,5,0}, {6,100000,6,0}};
        chell2 = new int[][]{{1,5120000,1,1}, {2,2560000,2,0}, {3,1280000,4,0}, {4,640000,8,0}, {5,320000,16,0}};

        for(int i=1;i<6;i++) {
            chell1[i][3] = chell1[i-1][3] + chell1[i][2];
        }
        for(int i=1;i<5;i++) {
            chell2[i][3] = chell2[i-1][3] + chell2[i][2];
        }


        int testcase = sc.nextInt();

        for(int i=0;i<testcase;i++) {
            int input1 = sc.nextInt();
            int input2 = sc.nextInt();
            System.out.println(solution(input1, input2));
        }
        sc.close();
        return;
    }

    static public int solution(int input1, int input2) {
        int result = 0;


        for(int i=1;i<6;i++) {
            if(input1 == 1) {
                result += chell1[0][1];
                break;
            }
            else if(input1 > chell1[5][3]) {
                result += 0;
                break;
            }
            else {
                if(input1 <=chell1[i][3] && input1 > chell1[i-1][3]) {
                    result += chell1[i][1];
                    break;
                }
            }
        }

        for(int i=1;i<5;i++) {
            if(input2 == 1) {
                result += chell2[0][1];
                break;
            }
            else if(input2 > chell2[4][3]) {
                result += 0;
                break;
            }
            else {
                if(input2 <= chell2[i][3] && input2 > chell2[i-1][3] ) {
                    result += chell2[i][1];
                    break;
                }
            }
        }


        return result;
    }
}
