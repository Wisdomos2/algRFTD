package study;

import java.util.ArrayList;
import java.util.Scanner;

public class ChickenDeliver_Boj {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        map = new int[N][N];
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i][j] = sc.nextInt();
                if(map[i][j] == 1) {
                    home.add(new Node(i,j));
                }
                else if(map[i][j] == 2) {
                    chicken.add(new Node(i,j));
                }
            }
        }

        visited = new boolean[chicken.size()];

        for(int i=0;i<chicken.size();i++) {
            visited[i] = true;
            getCase(i+1,1);
            visited[i] = false;
        }

        System.out.println(result);

    }

    static int N; // map
    static int M; // 살아남을 치킨집
    static int map[][];
    static boolean visited[];
    static int[] output;
    static int result = Integer.MAX_VALUE;
    static ArrayList<Node> home = new ArrayList<>();
    static ArrayList<Node> chicken = new ArrayList<>();


    static void getCase(int index, int depth) {
        if(depth == M) {

            int semiSum = 0;
            for(int i=0;i<home.size();i++) {
                int homeTempDistiance = Integer.MAX_VALUE;
                for(int j=0;j<visited.length;j++) {
                    if(visited[j]) {
                        homeTempDistiance = Math.min(calcDistance(home.get(i), chicken.get(j)),homeTempDistiance);
                    }
                }
                semiSum += homeTempDistiance;
            }
            result = Math.min(result, semiSum);

        }
        else {
            for(int i=index;i<visited.length;i++) {
                visited[i] = true;
                getCase(i+1,depth+1);
                visited[i] = false;
            }

        }

    }

    public static int calcDistance(Node node1, Node node2) {
        return Math.abs(node1.row - node2.row) + Math.abs(node1.col - node2.col);

    }

    static public class Node {
        int row;
        int col;

        public Node(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
