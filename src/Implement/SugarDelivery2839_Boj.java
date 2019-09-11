package Implement;

import java.util.Scanner;

public class SugarDelivery2839_Boj {
    static int TotalSugar = 0;
    static int count = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TotalSugar = sc.nextInt();


        int maxfive = TotalSugar / 5;
        for(int i=0; i<=maxfive; i++) {
            int incount = 0;
            int otherSugar = TotalSugar - (5*i);
            if(otherSugar == 0) {
                incount = i;
                count = Math.min(count, incount);
            }
            else {
                int mainValue = otherSugar / 3;
                int restValue = otherSugar % 3;
                if(restValue == 0) {
                    incount = i+mainValue;
                    count = Math.min(count, incount);
                }
            }
        }

        if(count == Integer.MAX_VALUE) {
            System.out.println(-1);
        }
        else {
            System.out.println(count);
        }

        sc.close();
        return;

    }
}
