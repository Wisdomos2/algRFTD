package study;

import java.util.Scanner;

public class ExpectingWinner_Boj {

    static double[][] wdl;
    static int[] ta;
    static int[] tb;
    static double[] res;

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);

        String[] teams = new String[4];
        for(int i = 0; i < 4; i++)
        {
            teams[i] = sc.next();
        }

        ta = new int[6];
        tb = new int[6];
        wdl = new double[6][3];
        res = new double[4];

        for(int i = 0; i < 6; i++)
        {
            String a = sc.next();
            String b = sc.next();
            for(int j = 0; j < 4; j++)
            {
                if(a.equals(teams[j]))
                {
                    ta[i] = j;
                }
                if(b.equals(teams[j]))
                {
                    tb[i] = j;
                }
            }
            wdl[i][0] = sc.nextDouble();
            wdl[i][1] = sc.nextDouble();
            wdl[i][2] = sc.nextDouble();

        }

        int[] score = new int[4];
        bf(score, 0, 1);

        System.out.printf("%.06f\n", res[0]);
        System.out.printf("%.06f\n", res[1]);
        System.out.printf("%.06f\n", res[2]);
        System.out.printf("%.06f\n", res[3]);

        sc.close();
    }

    static void bf(int[] score, int index, double p)
    {
        if(index == 6)
        {
            calcResult(score, p);
            return;
        }

        int a = ta[index];
        int b = tb[index];

        score[a] += 3;
        bf(score, index+1, p*wdl[index][0]);
        score[a] -= 3;

        score[a] += 1;
        score[b] += 1;
        bf(score, index+1, p*wdl[index][1]);
        score[a] -= 1;
        score[b] -= 1;

        score[b] += 3;
        bf(score, index+1, p*wdl[index][2]);
        score[b] -= 3;
    }

    static void calcResult(int[] score, double p)
    {
        if(p == 0)
            return;


        // calc rank
        int[] rank = new int[4];

        rank[0] = 1;
        for(int i = 1; i < 4; i++)
        {
            int r = 1;
            for(int j = 0; j <= i; j++)
            {
                if(score[i] < score[j])
                    r++;
                else if(score[i] > score[j])
                    rank[j]++;
            }

            rank[i] = r;
        }

        int num1 = 0;
        int num2 = 0;
        for(int i = 0; i < 4; i++)
        {
            if(rank[i] == 1)
                num1++;
            if(rank[i] == 2)
                num2++;
        }


        // check 1st place
        switch(num1)
        {
            case 1:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 1)
                        res[i] += p;
                }
                break;
            case 2:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 1)
                        res[i] += p;
                }
                return;
            case 3:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 1)
                        res[i] += p*(2.0/3.0);
                }
                return;
            case 4:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 1)
                        res[i] += p*(2.0/4.0);
                }
                return;
        }

        // check 2nd place
        switch(num2)
        {
            case 1:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 2)
                        res[i] += p;
                }
                break;
            case 2:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 2)
                        res[i] += p*(1.0/2.0);
                }
                break;
            case 3:
                for(int i = 0; i < 4; i++)
                {
                    if(rank[i] == 2)
                        res[i] += p*(1.0/3.0);
                }
                break;
        }

    }
}