package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
    https://trello.com/c/umFplGti
    https://www.acmicpc.net/problem/2580
    BackTracking
 */
public class Sudoko_Boj_BackTracking {
    static boolean findFlag = false;
    static int resultMap[][] = new int[9][9];
    static int map[][] = new int[9][9];

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < map.length; i++) {
            String temp[] = bf.readLine().split(" ");
            for (int j = 0; j < map.length; j++) {
                map[i][j] = Integer.parseInt(temp[j]);
            }
        }
        //map = init();

        ArrayList<Point> pointList = new ArrayList<>();

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map.length; j++) {
                if (map[i][j] == 0) {
                    pointList.add(new Point(i, j));
                }
            }
        }

        dfs(pointList, 0);
        printarr(resultMap);

        return;
    }

    public static void dfs(ArrayList<Point> pointList, int index) {
        //끝
        if (findFlag) {
            return;
        }
        if (pointList.size() == index) {
            findFlag = true;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map.length; j++) {
                    resultMap[i][j] = map[i][j];
                }
            }
            return;
        } else {
            for (int i = 1; i < 10; i++) {
                int ncol = pointList.get(index).col;
                int nrow = pointList.get(index).row;
                //check row, check box, visit == false
                if (checkcolrow(pointList, index, i) && checkbox(pointList, index, i)) {
                    map[ncol][nrow] = i;
                    dfs(pointList, index + 1);
                    map[ncol][nrow] = 0;
                }
            }
        }
    }

    //같은게 있으면 안됨.
    public static boolean checkcolrow(ArrayList<Point> pointList, int index, int value) {
        //가로
        for (int i = 0; i < 9; i++) {
            if (i == pointList.get(index).row) {
                continue;
            } else {
                if (map[pointList.get(index).col][i] == value) {
                    return false;
                }
            }
        }

        //세로
        for (int i = 0; i < 9; i++) {
            if (i == pointList.get(index).col) {
                continue;
            } else {
                if (map[i][pointList.get(index).row] == value) {
                    return false;
                }
            }
        }

        return true;
    }

    //같은게 있으면 안됨.
    public static boolean checkbox(ArrayList<Point> pointList, int index, int value) {
        int startcol = pointList.get(index).col / 3;
        int startrow = pointList.get(index).row / 3;

        startcol = startcol * 3;
        startrow = startrow * 3;

        for (int i = startcol; i < startcol + 3; i++) {
            for (int j = startrow; j < startrow + 3; j++) {
                if (i == pointList.get(index).col && j == pointList.get(index).row) {
                    continue;
                } else {
                    if (map[i][j] != 0 && map[i][j] == value) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    static class Point {
        int col;
        int row;

        public Point(int col, int row) {
            this.col = col;
            this.row = row;
        }
    }

    public static void printarr(int inputmap[][]) {
        for (int i = 0; i < inputmap.length; i++) {
            for (int j = 0; j < inputmap.length; j++) {
                System.out.printf(inputmap[i][j] + " ");
            }
            System.out.println();
        }
    }
}

    /* ***************************************************************** */
    //문제 input
    /*
    public static int[][] init() {
        int resultmap[][] = new int[9][9];
        String input = "0 3 5 4 6 9 2 7 8\n" +
                "7 8 2 1 0 5 6 0 9\n" +
                "0 6 0 2 7 8 1 3 5\n" +
                "3 2 1 0 4 6 8 9 7\n" +
                "8 0 4 9 1 3 5 0 6\n" +
                "5 9 6 8 2 0 4 1 3\n" +
                "9 1 7 6 5 2 0 8 0\n" +
                "6 0 3 7 0 1 9 5 2\n" +
                "2 5 8 3 9 4 7 6 0";

        String temp[] = input.split("\n");
        for(int i=0;i<resultmap.length;i++) {
            String inputTemp[] = temp[i].split(" ");
            for(int j=0;j<resultmap.length;j++) {
                resultmap[i][j] = Integer.parseInt(inputTemp[j]);
            }
        }

        return resultmap;
    }

    //문제 result와 같은지 확인.
    public static boolean test(int comparemap[][]) {
        String result = "1 3 5 4 6 9 2 7 8\n" +
                "7 8 2 1 3 5 6 4 9\n" +
                "4 6 9 2 7 8 1 3 5\n" +
                "3 2 1 5 4 6 8 9 7\n" +
                "8 7 4 9 1 3 5 2 6\n" +
                "5 9 6 8 2 7 4 1 3\n" +
                "9 1 7 6 5 2 3 8 4\n" +
                "6 4 3 7 8 1 9 5 2\n" +
                "2 5 8 3 9 4 7 6 1";

        String temp[] = result.split("\n");
        for(int i=0;i<comparemap.length;i++) {
            String inputTemp[] = temp[i].split(" ");
            for(int j=0;j<comparemap.length;j++) {
               //resultmap[i][j] = Integer.parseInt(inputTemp[j]);
                if(Integer.parseInt(inputTemp[j]) != comparemap[i][j]) {
                    return false;
                }
            }
        }


        return true;
    }
*/


