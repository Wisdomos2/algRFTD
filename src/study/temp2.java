package study;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;

public class temp2 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int testCase = Integer.parseInt(input);

        for(int k=0;k<testCase;k++) {
            String arrInfo[] = br.readLine().split(" ");
            int map[][] = new int[Integer.parseInt(arrInfo[0])][Integer.parseInt(arrInfo[1])];
            Queue<Node> q = new LinkedList<>();
            for(int i=0;i<map.length;i++) {
                String temp[] = br.readLine().split(" ");
                for(int j=0;j<map[0].length;j++) {
                    map[i][j] = Integer.parseInt(temp[j]);
                    if(map[i][j] == 1) {
                        q.add(new Node(i,j));
                    }
                }
            }
            if(q.isEmpty()) {
                System.out.println("YES");
                continue;
            }
            boolean result = gogo(map,q);
            if(result) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
        br.close();
        return;
    }

    public static boolean gogo(int map[][], Queue<Node> q) {
        //왼쪽 위
        int dr1[] = {-1,-1,0};
        int dc1[] = {0,-1,-1};

        //오른쪽 위
        int dr2[] = {-1,-1,0};
        int dc2[] = {0,1,1};

        //왼쪽 아래
        int dr3[] = {1,1,0};
        int dc3[] = {0,-1,-1};

        //오른쪽 아래
        int dr4[] = {1,1,0};
        int dc4[] = {0,1,1};

        while(!q.isEmpty()) {
            Node node = q.poll();
            int checkNum = 4;

            if(!checkNear(map, node, dc1, dr1)) {
                checkNum--;
            }
            if(!checkNear(map, node, dc2, dr2)) {
                checkNum--;
            }
            if(!checkNear(map, node, dc3, dr3)) {
                checkNum--;
            }
            if(!checkNear(map, node, dc4, dr4)) {
                checkNum--;
            }

            if(checkNum == 0) {
                return false;
            }

        }


        return true;
    }


    public static boolean checkNear(int map[][], Node node, int dc[], int dr[]) {
        int checkNum = 3;
        for(int i=0;i<3;i++) {
            int nextrow = node.row + dr[i];
            int nextcol = node.col + dc[i];
            if(nextrow > -1 && nextcol > -1 && nextrow < map.length && nextcol < map[0].length) {
                if(map[nextrow][nextcol] == 1) {
                    checkNum--;
                }
            }
        }

        if(checkNum == 0) {
            return true;
        }

        return false;
    }

    public static class Node {
        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }

        int row;
        int col;
    }
}
