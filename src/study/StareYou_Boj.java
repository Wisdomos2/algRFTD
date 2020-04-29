package study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class StareYou_Boj {
    // https://www.acmicpc.net/problem/15683
    static int row;
    static int col;
    static List<Node> list;
    static int map[][];
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        row = sc.nextInt();
        col = sc.nextInt();

        map = new int[row][col];
        list = new ArrayList<>();


        for(int i=0;i<row;i++) {
            for(int j=0;j<col;j++) {
                map[i][j] = sc.nextInt();
                if(1 <= map[i][j] && map[i][j] <= 5) {
                    list.add(new Node(i,j,map[i][j]));
                }
            }
        }

        search(0, map);
        System.out.println(result);
        return;
    }

    private static void search(int index, int prevMap[][]) {
        int visited[][] = new int[row][col];
        if(index == list.size()) {
            //calculate about 0
            int temp = 0;
            for(int i=0;i<row;i++) {
                for(int j=0;j<col;j++) {
                    if(prevMap[i][j] == 0) {
                        temp++;
                    }
                }
            }
            if(temp < result) {
                result = temp;
            }
        }
        else {
            Node node = list.get(index);
            switch (node.value) {
                case 1:
                    for(int k=0;k<4;k++) {
                        //clone
                        for(int i=0;i<row;i++) {
                            visited[i] = Arrays.copyOf(prevMap[i], col);
                        }
                        spread(visited,node.rowSpot,node.colSpot,k);
                        search(index + 1,visited);
                    }
                    break;
                case 2:
                    for (int k = 0; k < 2; k++) {
                        for (int i = 0; i < row; i++) {
                            visited[i] = Arrays.copyOf(prevMap[i], col);
                        }
                        spread(visited, node.rowSpot, node.colSpot, k);
                        spread(visited, node.rowSpot, node.colSpot, k + 2);
                        search(index + 1, visited);
                    }
                    break;
                case 3 :
                    for (int k = 0; k < 4; k++) {
                        for (int i = 0; i < row; i++) {
                            visited[i] = Arrays.copyOf(prevMap[i], col);
                        }
                        spread(visited, node.rowSpot, node.colSpot, k);
                        spread(visited, node.rowSpot, node.colSpot, (k + 1) % 4);
                        search(index + 1, visited);
                    }
                    break;
                case 4:
                    for (int k = 0; k < 4; k++) {
                        for (int i = 0; i < row; i++) {
                            visited[i] = Arrays.copyOf(prevMap[i], col);
                        }
                        spread(visited, node.rowSpot, node.colSpot, k);
                        spread(visited, node.rowSpot, node.colSpot, (k + 1) % 4);
                        spread(visited, node.rowSpot, node.colSpot, (k + 2) % 4);
                        search(index + 1, visited);
                    }
                    break;
                case 5 :
                    for (int i = 0; i < row; i++) {
                        visited[i] = Arrays.copyOf(prevMap[i], col);
                    }
                    spread(visited, node.rowSpot, node.colSpot, 0);
                    spread(visited, node.rowSpot, node.colSpot, 1);
                    spread(visited, node.rowSpot, node.colSpot, 2);
                    spread(visited, node.rowSpot, node.colSpot, 3);
                    search(index + 1, visited);
                    break;

            }
        }
    }


    private static void spread(int visited[][], int i, int j, int direction) {
        int n = row;
        int m = col;

        //case of direction
        switch (direction) {
            case 0:
                for (int k = j; k >= 0; k--) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 1:
                for (int k = i; k >= 0; k--) {
                    if (map[k][j] == 6) {
                        break;
                    }
                    visited[k][j] = 7;
                }
                break;
            case 2:
                for (int k = j; k < m; k++) {
                    if (map[i][k] == 6) {
                        break;
                    }
                    visited[i][k] = 7;
                }
                break;
            case 3:
                for (int k = i; k < n; k++) {
                    if (map[k][j] == 6) {
                        break;
                    }
                    visited[k][j] = 7;
                }
                break;
        }

    }

    private static class Node {

        public Node(int rowSpot, int colSpot, int value) {
            this.rowSpot = rowSpot;
            this.colSpot = colSpot;
            this.value = value;
        }
        int rowSpot;
        int colSpot;
        int value;

    }
}
