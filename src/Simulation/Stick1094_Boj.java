package Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Stick1094_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        int sum = 0;

        int stick = 64;

        int X = Integer.parseInt(bf.readLine());

        while(true) {
            if(sum == X) {
                System.out.println(count);
                return;
            }
            if(stick+sum > X) {
                stick = stick/2;
            }
            else if(stick+sum <= X) {
                sum = sum + stick;
                count++;
            }
        }


    }
}
