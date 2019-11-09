package Kakao2019;

import java.util.ArrayList;
import java.util.List;

public class num1 {
    public static void main(String[] args) {
        int arr[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int arr1[] = {1,5,3,5,1,2,1,4};

        System.out.println(solution(arr,arr1));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        int size = board.length;
        List<Integer> list = new ArrayList<Integer>();

        for (int i = 0; i < moves.length; i++) {
            int nowmove = moves[i];
            for (int j = 0; j < size; j++) {
                if (board[j][nowmove - 1] == 0) {
                    continue;
                } else if (board[j][nowmove - 1] != 0) {
                    list.add(board[j][nowmove - 1]);
                    board[j][nowmove - 1] = 0;
                    break;
                }
            }
        }



        for(int i=0;i<list.size()-1;i++) {
            if(list.get(i) == list.get(i+1)) {
                list.remove(i);
                list.remove(i);
                answer = answer + 2;
                if(i != 0) {

                    i = i - 2;
                }
            }
        }
/*        int count = 0;
        while (true) {
            if (count == list.size()-1) {
                break;
            } else {
                int now = list.get(count);
                int next = list.get(count+1);
                if (now == next) {
                    list.remove(count);
                    list.remove(count);

                    answer = answer + 2;
                    if(count != 0) {
                        count = count - 1;
                    }
                } else if (now != next) {
                    count = count+1;
                }
            }
        }*/
        return answer;
    }

}
