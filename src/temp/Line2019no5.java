package temp;

import java.util.HashMap;
import java.util.Map;
/*
코니와 문의 술래잡기
가로, 세로가 각각 n과 m인 모눈종이 공간에서 코니와 문이 술래잡기를 하고 있다.
이때, 코니가 (x,y)위치로 도망 간 뒤, 문이 코니를 가장 빨리 잡을 수 있는 경우의 수는 몇 가지인가?

다음은 코니와 문의 술래잡기 규칙이다.

코니는 도망간 뒤 이동하지 않는다
문은 (0,0) 지점에서 게임을 시작한다
문은 가로, 세로로만 이동이 가능하다
한 칸을 이동할 때 1초의 시간이 필요하다
코니가 모눈종이 공간 밖으로 도망 간 경우 문은 코니를 잡을 수 없다
모눈종이 공간의 n, m 크기는 1부터 24 사이의 자연수이다 (0 < n,m < 25)
예시
아래는 가로x세로 9x9 모눈종이 공간이다. 코니가 (2,1) 위치로 도망을 갔다.
문이 (0,0) 위치에서 출발하여 코니를 가장 빨리 잡을 수 있는 경우의 수는 3가지이며 3초의 시간이 걸린다.

입력 형식
첫 줄에는 술래잡기할 모눈종이 공간의 가로 세로를 입력한다
두 번째 줄에는 코니가 도망간 위치의 가로 세로 좌표를 입력한다
출력 형식
표준 출력으로 결과를 출력한다
문이 코니를 잡을 수 있을때, 첫 줄에는 문이 코니를 잡기까지 필요한 최소 시간을 출력한다
문이 코니를 잡을 수 있을때, 둘째 줄에는 문이 코니를 최소 시간으로 잡는 경우의 수를 출력한다
문이 코니를 잡을 수 없거나 게임이 시작될 수 없는 경우, fail 을 출력한다
입출력 예제

입력
9 9
2 1

출력
3
3
 */
public class Line2019no5 {
    public static void main(String[] args) {

        map[2][1] = 1;
        list = new HashMap<>();
        if(checkRow > 9 || checkCol > 9) {
            System.out.println("fail");
            return;
        }

        solution();

        System.out.println(list);
        return;

    }

    static int map[][] = new int[9][9];
    static int checkRow = 2;
    static int checkCol = 1;
    static Map<Integer, Integer> list;

    public static void solution() {
        boolean visited[][] = new boolean[9][9];
        visited[0][0] = true;
        dfs(0,0,visited,0);
        return;
    }

    public static void dfs(int row, int col, boolean visited[][], int depth) {
        int dr[] = {0,0,-1,1};
        int dc[] = {1,-1,0,0};

        if(checkRow == row && checkCol == col) {
            System.out.println(depth);
            System.out.println("???");
            if(!list.containsKey(depth)) {
                list.put(depth, 1);
            }
            else {
                list.replace(depth, list.get(depth)+1);
            }
        }
        else {
            visited[row][col] = true;
            for(int i=0;i<4;i++) {
                int nextRow = row + dr[i];
                int nextCol = col + dc[i];
                if(nextRow > -1 && nextRow < 9 && nextCol > -1 && nextCol < 9) {
                    if(!visited[nextRow][nextCol]) {

                        dfs(nextRow,nextCol,visited,depth+1);
                    }
                }
            }
        }
    }
}
