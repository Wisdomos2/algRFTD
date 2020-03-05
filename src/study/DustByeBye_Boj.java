package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class DustByeBye_Boj {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input[] = bf.readLine().split(" ");
        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        T = Integer.parseInt(input[2]);

        int cleanerIndex = 0;
        map = new int[R][C];
        for(int i=0;i<R;i++) {
            input = bf.readLine().split(" ");
            for(int j=0;j<C;j++) {
                map[i][j] = Integer.parseInt(input[j]);
                if(map[i][j] == -1) {
                    cleanerInfo[cleanerIndex] = new cleaner(i,j);
                    cleanerIndex++;
                }
                if(map[i][j] != -1 && map[i][j] != 0) {
                    dusts.add(new Dust(i,j));
                }
            }
        }

        int time = 0;
        while(time < T) {
            sumMap = new int[R][C];
            spread();
            cycleCleaner();
            pushdust();
            time++;
        }

        int result = sumAlldust();
        System.out.println(result);

        bf.close();
        return;




    }
    static int R = 0;
    static int C = 0;
    static int T = 0;
    static int map[][];
    static int sumMap[][];
    static cleaner[] cleanerInfo = new cleaner[2];
    static Queue<Dust> dusts = new LinkedList<>();

    static void printMap() {
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                System.out.printf(map[i][j] + " " );
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    static void spread() {
        int dr[] = {0,0,1,-1};
        int dc[] = {1,-1,0,0};

        while(!dusts.isEmpty()) {
            Dust getDust = dusts.poll();
            int possibleDirections = 0;
            int spreadValue = map[getDust.row][getDust.col]/5;

            for(int k=0;k<4;k++) {
                int nextRow = getDust.row + dr[k];
                int nextCol = getDust.col + dc[k];

                // 범위 안에 있고
                if(nextRow > -1 && nextRow < R && nextCol > -1 && nextCol < C) {
                    // 다음 좌표에 청정기가 없고
                    if(map[nextRow][nextCol] != -1) {
                        possibleDirections++;
                        sumMap[nextRow][nextCol] += spreadValue;
                    }
                }
            }
            sumMap[getDust.row][getDust.col] -= spreadValue*possibleDirections;
        }

        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                map[i][j] += sumMap[i][j];
            }
        }


    }

    static void cycleCleaner() {
        cleaner UpperClenaer = cleanerInfo[0];
        int upcRow = UpperClenaer.row;


        for(int i=upcRow-1; i>=0; i--) {
            if(i!=0) {
                map[i][0] = map[i-1][0];
            }
        }

        for(int i=0; i<C-1; i++) {
            map[0][i] = map[0][i+1];
        }

        for(int i=0; i<upcRow; i++) {
            map[i][C-1] = map[i+1][C-1];
        }

        for(int i=C-1; i>=1; i--) {
            map[upcRow][i] = map[upcRow][i-1];

            if(i==1) {
                map[upcRow][i] = 0;
            }
        }

        cleaner UnderCleaner = cleanerInfo[1];
        int uncRow = UnderCleaner.row;


        for(int i=uncRow+1; i<R; i++) {
            if(i!=R-1) {
                map[i][0] = map[i+1][0];
            }
        }

        for(int i=0; i<C-1; i++) {
            map[R-1][i] = map[R-1][i+1];
        }

        for(int i=R-1; i>uncRow; i--) {
            map[i][C-1] = map[i-1][C-1];
        }

        for(int i=C-1; i>=1; i--) {
            map[uncRow][i] = map[uncRow][i-1];

            if(i==1) {
                map[uncRow][i] = 0;
            }
        }


    }

    static void pushdust() {
        dusts.clear();
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                if(map[i][j] != -1 && map[i][j] != 0) {
                    dusts.add(new Dust(i,j));
                }
            }
        }

    }

    static int sumAlldust() {
        int result = 0;
        for(int i=0;i<R;i++) {
            for(int j=0;j<C;j++) {
                result += map[i][j];
            }
        }

        return result+2;
    }

    static class cleaner {
        int row;
        int col;

        public cleaner(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    static class Dust {
        public Dust(int row, int col) {
            this.row = row;
            this.col = col;
        }

        int row;
        int col;
    }

}
