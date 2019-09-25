package Searching;


import java.util.*;

/*
 간접 인접리스트 ! Adjacent List
 */

//6	[[3, 6], [4, 3], [3, 2], [1, 3], [1, 2], [2, 4], [5, 2]]	3
public class SkillLevel3_Prgs {
    public static void main(String[] args) {
        int n = 6;
        int arr[][] = {{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}};
        int result = solution(n,arr);
        System.out.println(result);
        return;
    }
    public static int solution(int n, int arr[][]) {
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        Queue<Integer> q = new LinkedList<Integer>();


        for(int i=0;i<arr.length;i++) {
            list.add(new ArrayList<Integer>());
        }

        for(int i=0;i<arr.length;i++) {
            int a = arr[i][0];
            int b = arr[i][1];
            list.get(a).add(b);
            list.get(b).add(a);
        }

        int d[] = new int[n+1];
        Arrays.fill(d,-1);

        d[1] = 0;
        q.add(1);

        while (!q.isEmpty()) {
            int index = q.poll();
            for(int i : list.get(index)) {
                if(d[i] == -1 ) {
                    d[i] = d[index]+1;
                    q.add(i);
                }
            }
        }

        Arrays.sort(d);

        int count = 0;
        int max = d[d.length-1];
        for(int i : d) {
            if(i == max) {
                count++;
            }
        }

        return count;
    }
}


/*
import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<ArrayList<Integer>> list = new <ArrayList<Integer>> ArrayList();
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = 0; i < edge.length; i++) {
            list.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < edge.length; i++) {
            int m = edge[i][0];
            int h = edge[i][1];
            list.get(m).add(h);
            list.get(h).add(m);
        }

        int[] d = new int[n+1];
        Arrays.fill(d, -1);

        d[1] = 0;
        q.add(1);
        int u = 0;
        while(q.size() > 0) {
            u = q.poll();
            for(int e : list.get(u)) {
                if(d[e] == -1) {
                    d[e] = d[u]+1;
                    q.add(e);
                }
            }

        }

        int count = 0;
        int max = d[0];
        for(int i : d) {
            if(max < i) {
                max = i;
                count = 1;
            }else if(max == i){
                count++;
            }
        }
        return count;
    }
}
 */