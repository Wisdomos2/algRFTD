package Kakao2019;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class num5 {
    public static void main(String[] args) {
        int n = 5;
        int build_frame[][] = {{0,0,0,1},{2,0,0,1},{4,0,0,1},{0,1,1,1},{1,1,1,1},
                {2,1,1,1},{3,1,1,1},{2,0,0,0},{1,1,1,0},{2,2,0,1}};
        int result[][] = solution(n,build_frame);


        for(int test[] : result) {
            System.out.println(test[0] + " " + test[1] + " " + test[2]);
        }

    }

    public static int[][] solution(int n, int[][] build_frame) {
        int[][] answer = null;
        Map<String, Integer> map = new HashMap<String,Integer>();

        for(int i=0;i<build_frame.length;i++) {
            int x = build_frame[i][0];
            int y = build_frame[i][1];
            int kind = build_frame[i][2];
            int how = build_frame[i][3];

            String xy = String.valueOf(x)+String.valueOf(y);

            if(!map.containsKey(xy)) {
                if(how == 1) {
                    map.put(xy,kind);
                }
            }
            if(how == 0) {
                map.remove(xy);
            }

        }




        answer = new int[map.size()][3];
        int count = 0;
        for(String xy : map.keySet()) {
            if(count < map.size()) {

                answer[count][0] = Integer.valueOf(xy.substring(0,1));
                answer[count][1] = Integer.valueOf(xy.substring(1,2));
                answer[count][2] = map.get(xy);
                count++;
            }
        }


        return answer;
    }

    public static class spot {
        int x;
        int y;

        public spot(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
