package Simulation;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StarTournament1057_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String temp[] = bf.readLine().split(" ");
        int N = Integer.parseInt(temp[0]);
        int a = Integer.parseInt(temp[1]);
        int b = Integer.parseInt(temp[2]);
        int round = 0;

        while(a!=b) {
            round++;
            a = a/2 + a%2;
            b = b/2 + b%2;
        }
        if(round != 0) {
            System.out.println(round);
        }
        else {
            System.out.println(-1);
        }
    }
}
