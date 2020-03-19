package study;

import java.util.Scanner;

public class Cuving_Boj {
    /*
        　뒤              4
        좌위우밑 6차원?  0123 r  개 시 2발 같은 문제네 ㄹㅇ루다가 출제자 줄빠따마렵
        　앞              5
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();

        printMap = new String[3*testCase][3];

        for(int t=0;t<testCase;t++) {

            map = new String[6][3][3];
            for(int i=0;i<6;i++) {
                fillMap(i);
            }

            int turn = sc.nextInt();

            for(int k=0;k<turn;k++) {
                String getMethod[] = sc.next().split("");
                rotation(getMethod[0], getMethod[1]);
            }

            for(int i=0;i<3;i++) {
                for(int j=0;j<3;j++) {
                    printMap[i+index][j] = map[1][i][j];
                }
            }
            index = index + 3;
        }

        for(int i=0;i<printMap.length;i++) {
            for(int j=0;j<3;j++) {
                System.out.printf(printMap[i][j]);
            }
            System.out.println();
        }
    }

    static String map[][][];
    static String printMap[][];
    static int index = 0;


    public static void rotation(String side, String direction) {
        if(side.equals("L")) {
            L(direction);
        }
        else if(side.equals("U")) {
            U(direction);
        }
        else if(side.equals("R")) {
            R(direction);
        }
        else if(side.equals("D")) {
            D(direction);
        }
        else if(side.equals("B")) {
            B(direction);
        }
        else if(side.equals("F")) {
            F(direction);
        }
        return;
    }


    public static void L(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[3][2-i][2];
                map[3][2-i][2] = map[5][i][0];
                map[5][i][0] = map[1][i][0];
                map[1][i][0] = map[4][i][0];
                map[4][i][0] = temp;
            }
            selfRotationRight(0);

        }
        else {
            for(int i=0;i<3;i++) {
                String temp = map[3][2-i][2];
                map[3][2-i][2] = map[4][i][0];
                map[4][i][0] = map[1][i][0];
                map[1][i][0] = map[5][i][0];
                map[5][i][0] = temp;
            }
            selfRotationLeft(0);

        }

    }

    /*
        위를 돌린다 -> 앞, 좌, 뒤, 우 회전 (0행)
     */
    public static void U(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[2][i][0];
                map[2][i][0] = map[4][2][i];
                map[4][2][i] = map[0][2-i][2];
                map[0][2-i][2] = map[5][0][2-i];
                map[5][0][2-i] = temp;
            }
            selfRotationRight(1);

        }
        else {
            for(int i=0;i<3;i++) {
                String temp = map[2][i][0];
                map[2][i][0] = map[5][0][2-i];
                map[5][0][2-i] = map[0][2-i][2];
                map[0][2-i][2] = map[4][2][i];
                map[4][2][i] = temp;
            }
            selfRotationLeft(1);
        }
    }

    /*
        우를 돌린다 -> 위, 뒤, 앞, 밑 회전 (2열)
     */
    public static void R(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[3][2-i][0];
                map[3][2-i][0] = map[4][i][2];
                map[4][i][2] = map[1][i][2];
                map[1][i][2] = map[5][i][2];
                map[5][i][2] = temp;
            }
            selfRotationRight(2);
        }
        else {
            for(int i=0;i<3;i++) {
                String temp = map[3][2-i][0];
                map[3][2-i][0] = map[5][i][2];
                map[5][i][2] = map[1][i][2];
                map[1][i][2] = map[4][i][2];
                map[4][i][2] = temp;
            }
            selfRotationLeft(2);
        }
    }

    /*
        밑을 돌린다 -> 앞, 좌, 뒤, 우 회전 (2행)
     */
    public static void D(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[2][2-i][2];
                map[2][2-i][2] = map[5][2][i];
                map[5][2][i] = map[0][i][0];
                map[0][i][0] = map[4][0][2-i];
                map[4][0][2-i] = temp;
            }
            selfRotationRight(3);
        }
        else {
            for(int i=0;i<3;i++) {

                String temp = map[2][2-i][2];
                map[2][2-i][2] = map[4][0][2-i];
                map[4][0][2-i] = map[0][i][0];
                map[0][i][0] = map[5][2][i];
                map[5][2][i] = temp;
            }
            selfRotationLeft(3);
        }
    }

    /*
        뒤를 돌린다 -> 위, 좌, 밑, 우 회전 (
     */
    //ok
    public static void F(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[3][2][i];
                map[3][2][i] = map[2][2][i];
                map[2][2][i] = map[1][2][i];
                map[1][2][i] = map[0][2][i];
                map[0][2][i] = temp;
            }
            selfRotationRight(5);
        }
        else {
            for(int i=0;i<3;i++) {
                String temp = map[3][2][i];
                map[3][2][i] = map[0][2][i];
                map[0][2][i] = map[1][2][i];
                map[1][2][i] = map[2][2][i];
                map[2][2][i] = temp;
            }
            selfRotationLeft(5);
        }
    }

    // ok
    public static void B(String direction) {
        if(direction.equals("+")) {
            for(int i=0;i<3;i++) {
                String temp = map[3][0][i];
                map[3][0][i] = map[0][0][i];
                map[0][0][i] = map[1][0][i];
                map[1][0][i] = map[2][0][i];
                map[2][0][i] = temp;
            }
            selfRotationRight(4);
        }
        else {
            for(int i=0;i<3;i++) {
                String temp = map[3][0][i];
                map[3][0][i] = map[2][0][i];
                map[2][0][i] = map[1][0][i];
                map[1][0][i] = map[0][0][i];
                map[0][0][i] = temp;
            }
            selfRotationLeft(4);
        }
    }

    public static void selfRotationRight(int index) {
        String temp[][] = new String[3][3];
        for(int i=0;i<3;i++) {
            temp[i][2] = map[index][0][i];
            temp[i][1] = map[index][1][i];
            temp[i][0] = map[index][2][i];
        }

        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                map[index][i][j] = temp[i][j];
            }
        }
    }

    public static void selfRotationLeft(int index) {
        String temp[][] = new String[3][3];
        for(int i=0;i<3;i++) {
            temp[2-i][0] = map[index][0][i];
            temp[2-i][1] = map[index][1][i];
            temp[2-i][2] = map[index][2][i];
        }
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++) {
                map[index][i][j] = temp[i][j];
            }
        }
    }


    public static void fillMap(int i) {
        if(i == 0) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "g";
                }
            }
        }
        else if(i == 1) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "w";
                }
            }
        }
        else if(i == 2) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "b";
                }
            }
        }
        else if(i == 3) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "y";
                }
            }
        }
        else if(i == 4) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "o";
                }
            }
        }
        else if(i == 5) {
            for(int r=0;r<3;r++) {
                for(int c=0;c<3;c++) {
                    map[i][r][c] = "r";
                }
            }
        }
    }
}
