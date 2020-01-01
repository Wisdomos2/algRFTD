package study;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/*
    https://www.acmicpc.net/problem/17825
 */
public class DiceYoutnori_Boj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        for(int i=0;i<10;i++) {
            Dice[i] = scanner.nextInt();
        }
        inputMap = initMap();
        getCases(0);
        System.out.println(result);
        scanner.close();
        return;

    }

    static int inputMap[][];
    static int Dice[] = new int[10];
    static int visitedDice[] = new int[10];
    static int result = Integer.MIN_VALUE;

    // 4개의 말이 가질 수 있는 경우의 수. 4^10
    public static void getCases(int count) {
        //10번씩 다 돈거임 -> 계산.
        if(count == 10) {
            int outputResult = getResult();
            if(outputResult != -1) {
                result = Math.max(result, outputResult);
            }
            return;
        }
        else {
            for(int i=0;i<4;i++) {
                visitedDice[count] = i;
                getCases(count+1);
            }
        }
    }

    private static int getResult() {
        int outputResult = 0;
        // map에서, 몇번쨰 행에[0], 몇번째 열에 있는지[1], 이동하면서 갱신되는 배열.
        int horses[][] = new int[4][2];

        /*
            Dice   {1, 2, 3, 4, 1, 2, 3, 4, 1, 2}
            말 배치 {1, 1, 2, 3, 1, 2, 2, 3, 2, 1}
         */
        for(int i=0;i<10;i++) {
            int nowHorse = visitedDice[i];

            // 10,20,30에 배치되는 것에 대한 col변경
            if(horses[nowHorse][0] == 0 && horses[nowHorse][1] % 5 == 0) {
                int changeCol = horses[nowHorse][1] / 5;
                if(changeCol > 0 && changeCol < 4) {
                    horses[nowHorse][0] = changeCol;
                    horses[nowHorse][1] = 0;
                }
            }
            horses[nowHorse][1] = horses[nowHorse][1] + Dice[i];


            int nowHorseCol = horses[nowHorse][0];
            int nowHorseRow = horses[nowHorse][1];

            // ★★옮겼을 때★★, 같은 말이 같은 곳에 있는지 확인해야함.
            for(int anotherHouse=0;anotherHouse<4;anotherHouse++) {
                if(anotherHouse == nowHorse) {
                    continue;
                }
                else {
                    int otherHorseCol = horses[anotherHouse][0];
                    int otherHorseRow = horses[anotherHouse][1];
                    // 도착 지점에 가지 않았음
                    if(inputMap[nowHorseCol].length > nowHorseRow && inputMap[otherHorseCol].length > otherHorseRow) {
                        //같은 행,열에 있는경우 -> 뺴박 말 겹침 -> 이동못하G~
                        if(nowHorseCol == otherHorseCol && nowHorseRow == otherHorseRow) {
                            return -1;
                        }
                        //같은 행,열을 위에서 검증했음, 이번 것은 25(중앙점)으로 갈때 문제가 생김. 25에 박히면 걍 끔살당하는기양
                        if(nowHorseCol != 0 && otherHorseCol != 0) {
                            if(inputMap[nowHorseCol][nowHorseRow] == inputMap[otherHorseCol][otherHorseRow]) {
                                return -1;
                            }
                        }
                        // 이거때문에 SSSSSSSSSSSSSSSSSSSSSSSSSSSI-VALLLLLLLLLLLLLLLLLLLLLLLLLLLLL 망할뻔.
                        // 현재 말을 움직였다 -> 근데 이미 40에 도착한 애가 있다-> 성립안됨.
                        if(inputMap[nowHorseCol][nowHorseRow] == 40 && inputMap[otherHorseCol][otherHorseRow] == 40) {
                            return -1;
                        }
                    }
                }
            }
            //
            if(nowHorseRow < inputMap[nowHorseCol].length) {
                outputResult = outputResult + inputMap[nowHorseCol][nowHorseRow];
            }

        }

        return outputResult;
    }

    static public int[][] initMap() {
        int map[][] = {
                {0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40},
                {10,13,16,19,25,30,35,40},
                {20,22,24,25,30,35,40},
                {30,28,27,26,25,30,35,40}
        };
        return map;
    }

}
