package study;

import java.util.LinkedList;
import java.util.Queue;

public class Friends4Block_Prg {
    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        String board1[] = {"CCBDE",
                           "AAADE",
                           "AAABF",
                           "CCBBF"};

        //solution(m1,n1,board1);


        int m2 = 6;
        int n2 = 6;
        String board2[] = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"};
        solution(m2,n2,board2);

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        map = new String[m][n];

        for(int i=0;i<m;i++) {
            String temp[] = board[i].split("");
            for(int j=0;j<n;j++) {
                map[i][j] = temp[j];
            }
        }

        while(changeflag) {
            changeflag = false;
            deleteSameBlock(m,n);

            shiftEmptyBlock(m,n);

        }

        return cnt;
    }

    static String map[][];
    static int cnt = 0;
    static boolean changeflag = true;

    public static void deleteSameBlock(int m, int n) {
        boolean visited[][] = new boolean[m][n];

        for(int i=0;i<m-1;i++) {
            for(int j=0;j<n-1;j++) {
                if(map[i][j].equals("X")) {
                    continue;
                }
                if(map[i][j].equals(map[i][j+1]) && map[i][j].equals(map[i+1][j]) && map[i][j].equals(map[i+1][j+1])) {
                    visited[i][j] = true;
                    visited[i][j+1] = true;
                    visited[i+1][j] = true;
                    visited[i+1][j+1] = true;
                    changeflag = true;
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if(visited[i][j]) {
                    cnt++;
                    map[i][j] = "X";
                }
            }
        }

    }

    public static void shiftEmptyBlock(int m, int n) {
        for(int j=0;j<n;j++) {
            for(int i=m-1;i>0;i--) {
                if(map[i][j].equals("X")) {
                    for(int k=i;k>=0;k--) {
                        if(!map[k][j].equals("X")) {
                            map[i][j] = map[k][j];
                            map[k][j] = "X";
                            break;
                        }
                    }
                }
            }

        }

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
