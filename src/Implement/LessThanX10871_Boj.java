package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class LessThanX10871_Boj {
    static int N = 0;
    static int X = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> q = new LinkedList<Integer>();

        String NX[] = bf.readLine().split(" ");
        N = Integer.parseInt(NX[0]);
        X = Integer.parseInt(NX[1]);


        String arr[] = bf.readLine().split(" ");
        for(int i = 0; i < arr.length; i++) {
            int temp = Integer.parseInt(arr[i]);
            if(X > temp) {
                System.out.printf(temp + " ");
            }
        }


        bf.close();
        return;

    }
}
