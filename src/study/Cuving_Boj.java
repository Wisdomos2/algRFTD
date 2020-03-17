package study;

import java.util.Scanner;

public class Cuving_Boj {
    /*
        　뒤
        좌위우 6차원?
        　앞
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        for(int t=0;t<testCase;t++) {
            int turn = sc.nextInt();
            String method[] = sc.nextLine().split(" ");
            for(int i=0;i<method.length;i++) {
                String semiMethod[] = method[i].split("");
                rotation(semiMethod[0], semiMethod[1]);
            }
            printDice();
        }
    }
    public static void rotation(String side, String direction) {


    }

    public static void printDice() {

    }
}
