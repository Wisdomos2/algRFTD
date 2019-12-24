package study;

/*
    https://www.acmicpc.net/problem/17822
 */
public class Cycleonepan {
    public static void main(String[] args) {

        String input1 = "4 4 1\n" +
                "1 1 2 3\n" +
                "5 2 4 2\n" +
                "3 1 3 5\n" +
                "2 1 3 2\n" +
                "2 0 1";
        test(input1);
    }

    public static void test(String input) {
        String i= "4 4 1\n" +
                "1 1 2 3\n" +
                "5 2 4 2\n" +
                "3 1 3 5\n" +
                "2 1 3 2\n" +
                "2 0 1";
        String arr[] = i.split("\n");
        String info[] = arr[0].split(" ");
        int N = Integer.parseInt(info[0);
        int M = Integer.parseInt(info[1]);
        int T = Integer.parseInt(info[2]);

        int map[][] = new int[N][M];
        int testcase[] = new int[T];
        for(int i=0;i<N;i++) {
            String temp[] = i[i+1];
            for(int j=0;j<M;j++) {
                map[i][j] = Integer.parseInt(temp[j]);
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }

    }
}
