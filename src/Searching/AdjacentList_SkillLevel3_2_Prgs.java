package Searching;

public class AdjacentList_SkillLevel3_2_Prgs {
}


/*
https://programmers.co.kr/learn/courses/30/lessons/1829
https://pasudo123.tistory.com/226 <- 참고
import java.util.*;

class Solution {
  public static int[] solution(int m, int n, int[][] picture) {
    int[] answer = new int[2];
    boolean[][] visited = new boolean[m][n];
    Stack<Integer> stackX = new Stack<>();
    Stack<Integer> stackY = new Stack<>();
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            int count = 0;
            if(picture[i][j] > 0 && visited[i][j] == false) {
                plus(stackX, stackY, visited, j, i);
                count++;
                answer[0]++;
            }
            while(!stackX.isEmpty()) {
                int x = stackX.pop();
                int y = stackY.pop();
                // 위 이동
                if(y > 0 && picture[y - 1][x] == picture[i][j] && visited[y - 1][x] == false) {
                    plus(stackX, stackY, visited, x, y - 1);
                    count++;
                }
                // 좌측 이동
                if(x > 0 && picture[y][x - 1] == picture[i][j] && visited[y][x - 1] == false) {
                    plus(stackX, stackY, visited, x - 1, y);
                    count++;
                }
                // 아래 이동
                if(y < m - 1 && picture[y + 1][x] == picture[i][j] && visited[y + 1][x] == false) {
                    plus(stackX, stackY, visited, x, y + 1);
                    count++;
                }
                // 우측 이동
                if(x < n - 1 && picture[y][x + 1] == picture[i][j] && visited[y][x + 1] == false) {
                    plus(stackX, stackY, visited, x + 1, y);
                    count++;
                }
            }
            answer[1] = Math.max(answer[1], count);
        }
    }

    return answer;
}

public static void plus(Stack<Integer> stackX, Stack<Integer> stackY, boolean[][] visited, int j, int i) {
    stackX.add(j);
    stackY.add(i);
    visited[i][j] = true;
}
}
 */