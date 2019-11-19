package study;

public class Carpet_Prg {
    public static void main(String[] args) {

        for(int i : solution(10,2)) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i : solution(8,1)) {
            System.out.printf(i + " ");
        }
        System.out.println();
        for(int i : solution(24,24)) {
            System.out.printf(i + " ");
        }

        return;
    }

    public static int[] solution(int brown, int red) {
        int[] answer = new int[2];

        /*
        ░░░░░░░░░░░░░░░░░░░░░░░
        ░░░░█▀▀░█▀█░█▀▀░█░█░░░░
        ░░░░█▀▀░█▀█░▀▀█░▀█▀░░░░
        ░░░░▀▀▀░▀░▀░▀▀▀░░▀░░░░░
        ░░░░░░░░░░░░░░░░░░░░░░░
        #Conditions
        1. 빨간 카펫은 가운데에만 있음.
        2. 리턴은 전체카펫 크기, [가로, 세로]
        3. 가로 >= 세로 , 가로 + 세로 = 전체크기
        4.
        #process
        1. 전체크기의 약수들로 col, row 값을 구함.
            1-1) 3 아래는 제외 (중앙생성불가)
            1-2) 가로는 세로와 같을때부터 시작하여 증가.
        2. col, row 값을 기반으로 테두리값(함수) 구함.
        3. (brown - 테두리) 를 result 라 하자.
            3-1) result > 0 이면 테두리를 더 깎을 수 있음.
            3-2) result == 0 이면 if(전체-result)==red 인지 체크.
                3-2-1) true이면 리턴하고 끝. 아니면 continue;
            3-3) result < 0 이면 다음 값으로 넘어감.(배치오류)

       결과론적으로 , 전체크기 - (brwon - 테두리 값) == red 여야 함.
        */

        int total = brown + red;

        //process 1-1.
        for(int i=3; i<=total;i++) {
            int col = 0;
            int row = 0;

            //process 2.
            if(total%i == 0 && total/i >= 3) {
                col = i;
                row = total/i;
                //Condition 1.
                if(row >= col) {
                    if(roundValue(brown,red,col,row)) {
                        answer[0] = row;
                        answer[1] = col;
                        break;

                    }
                }
            }
            else {
                continue;
            }

        }
        return answer;
    }

    public static boolean roundValue(int brown, int red, int col, int row) {

        //가로*2 + 세로*2 - 4(모서리) 현재 가장 바깥쪽 테두리.
        int round = (col*2 + row*2) - 4;
        int nextbrown = brown - round;

        // process 1-1
        if(col < 3 && row < 3) {
            return false;
        }
        // process 3-3
        if(nextbrown < 0) {
            return false;
        }

        //condition 3.
        if(nextbrown > 0) {
            roundValue(nextbrown, red, col-2, row-2);
        }
        else if(nextbrown == 0) {
            if(col*row - round == red) {
                return true;
            }
        }
        return false;
    }
}
