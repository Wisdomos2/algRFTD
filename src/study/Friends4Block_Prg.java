package study;

public class Friends4Block_Prg {
    public static void main(String[] args) {
        int m1 = 4;
        int n1 = 5;
        String board1[] = {"CCBDE", "AAADE", "AAABF", "CCBBF"};

        solution(m1,n1,board1);

        int m2 = 6;
        int n2 = 6;
        String board2[] = {"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTT"};

    }

    public static int solution(int m, int n, String[] board) {
        int answer = 0;

        String map[][] = new String[m][n];

        for(int i=0;i<m;i++) {
            String temp[] = board[i].split("");
            for(int j=0;j<n;j++) {
                map[i][j] = temp[j];
            }
        }




        return answer;
    }

    public static void deleteSameBlock() {

    }

    public static void shiftEmptyBlock() {

    }
}
