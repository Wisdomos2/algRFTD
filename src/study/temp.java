package study;

import java.io.*;
import java.util.ArrayList;

public class temp {
    public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String input = br.readLine();

            int N = Integer.parseInt(input);

            ArrayList<ArrayList<Integer>> list =  new ArrayList<>();
            for(int i=0;i<8;i++) {
                list.add(new ArrayList<>());
            }

            list.get(2).add(1);
            list.get(3).add(7);
            list.get(4).add(4);
            list.get(5).add(2);
            list.get(5).add(3);
            list.get(5).add(5);
            list.get(6).add(0);
        list.get(6).add(6);
        list.get(7).add(3);
        list.get(7).add(9);

        dfs(list, 0, N,0);
        System.out.println(result);


    }

    static int result = 0;
    public static void dfs(ArrayList<ArrayList<Integer>> list, int depth, int max, int value) {
        if(depth == max) {
            result = Math.max(result, value);
            return;
        }
        else {
            value = value * 10;
            for (int i = 2; i < list.size(); i++) {
                if (depth + i <= max) {
                    ArrayList<Integer> tempList = list.get(i);
                    for (int j = 0; j < tempList.size(); j++) {
                        dfs(list, depth + i, max, value + tempList.get(j));
                    }
                }
            }
        }
    }
}
