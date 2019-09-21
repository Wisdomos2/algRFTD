package Implement;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class KaKaoColoringBook_Pgrs {
    static boolean visited[][] = null;
    static Map<Integer,Integer> map = new HashMap<Integer,Integer>();
    static int Maxcol;
    static int Maxrow;
    public static void main(String[] args) {

        int arr[][] = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
        int m = 6; //col
        int n = 4; //row
        Maxcol = m;
        Maxrow = n;
        int answer[] = solution(m,n,arr);
        for(int i : answer) {
            System.out.println(i);
        }
        return;

    }

    public static int[] solution(int m, int n, int[][] picture) {
        visited = new boolean[m][n];
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(!visited[i][j]) {
                    if(!map.containsKey(picture[i][j])) {
                        map.put(picture[i][j], 0);
                    }
                    Search(new Info(i,j,picture[i][j]), picture);
                }
            }
        }

        for(int i=1;i<map.size();i++) {
            int maxtemp = map.get(i);
            maxSizeOfOneArea = Math.max(maxSizeOfOneArea,maxtemp);
        }

        numberOfArea = map.size();
        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    public static void Search(Info info,int picture[][]) {
        int dc[] = {0,0,1,-1};
        int dr[] = {1,-1,0,0};
        Queue<Info> q = new LinkedList<Info>();
        visited[info.col][info.row] = true;

        int count = 0;

        q.add(info);
        while(!q.isEmpty()) {
            int nowCol = q.peek().col;
            int nowRow = q.peek().row;
            int nowColor = q.poll().color;

            count++;

            for(int i=0;i<4;i++) {
                int nextCol = nowCol + dc[i];
                int nextRow = nowRow + dr[i];
                int nextColor = nowColor;
                if(nextCol > -1 && nextCol < Maxcol && nextRow > -1 && nextRow < Maxrow) {
                    if(!visited[nextCol][nextRow] && nextColor == picture[nextCol][nextRow]) {
                        visited[nextCol][nextRow] = true;
                        q.add(new Info(nextCol, nextRow,nextColor));
                    }
                }
            }
        }

        if(map.containsKey(info.color)) {
            int temp = map.get(info.color);
            map.replace(info.color, map.get(info.color), Math.max(temp, count));
        }



    }

    public static class Info {
        int col;
        int row;
        int color;
        public Info(int col, int row, int color) {
            this.col = col;
            this.row = row;
            this.color = color;
        }
    }
}
