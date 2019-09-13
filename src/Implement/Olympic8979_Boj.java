package Implement;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Olympic8979_Boj {
    static int country = 0;
    static int wantValue = 0;
    static int count = 1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        String input[] = bf.readLine().split(" ");
        Country score[];

        country = Integer.parseInt(input[0]);
        wantValue = Integer.parseInt(input[1]);

        score = new Country[country];

        for(int i=0;i<country; i++) {
            String temp[] = bf.readLine().split(" ");
            int gold = Integer.parseInt(temp[1]);
            int silver = Integer.parseInt(temp[2]);
            int bronze = Integer.parseInt(temp[3]);
            score[i] = new Country(gold, silver, bronze);
        }

        Country want = score[wantValue-1];
        System.out.printf(want.gold + " " + want.silver + " " + want.bronze);
        for(int i=0;i<country;i++) {
            Country other = score[i];
            if ((other.gold > want.gold) || (other.gold == want.gold && other.silver > want.silver) ||
                    (other.gold == want.gold && other.silver == want.silver && other.bronze > want.bronze)) {
                count++;
            }
        }

        System.out.println(count);
        bf.close();
        return;


    }

    private static class Country {
        int gold;
        int silver;
        int bronze;
        public Country(int gold, int silver, int bronze) {
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }
    }
}


/*
import java.util.*;
import java.io.*;

public class Main {
    static class Country {
        public int x, y, z;
        public Country (int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }
    public static void main (String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        String str1[] = br.readLine().split(" ");
        int N = Integer.parseInt(str1[0]);
        int K = Integer.parseInt(str1[1]);
        Country countries[] = new Country[N + 1];
        for (int i = 1; i <= N; i++) {
            String str2[] = br.readLine().split(" ");
            int c = Integer.parseInt(str2[0]);
            int x = Integer.parseInt(str2[1]);
            int y = Integer.parseInt(str2[2]);
            int z = Integer.parseInt(str2[3]);
            countries[c] = new Country(x, y, z);
        }
        int result = 1;
        Country k = countries[K];
        for (int i = 1; i <= N; i++) {
            Country c = countries[i];
            if (c.x > k.x || (c.x == k.x && c.y > k.y) || (c.x == k.x && c.y == k.y && c.z > k.z)) result++;
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
 */