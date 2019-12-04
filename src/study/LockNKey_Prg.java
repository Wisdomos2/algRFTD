package study;
/*
    https://programmers.co.kr/learn/courses/30/lessons/60059
 */
public class LockNKey_Prg {
    static boolean result = false;
    public static void main(String[] args) {
        int inputkey[][] = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int inputlock[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        System.out.println(solution(inputkey,inputlock));

    }

    /*
        ok 0. Lock 배열 3배 크기로 비교배열을 만든다.
        1. 0,0부터 key값을 keyMap Size만큼 반복하여 더해준다.
        2. Lock 배열(중앙)값들이 모두 1인지 확인한다. -> check 함수
            2-1. 모두 1이 아니면 0,1 로 이동하여 1번부터 반복한다.
                2-1-1. 배열 끝까지 왔음에도 아니라면 리턴하고 90도 리턴후 1번부터 반복한다.
            2-2. 모두 1이라면 리턴한다.
     */
    public static boolean solution(int[][] key, int[][] lock) {
        int resultMap[][] = new int[lock.length*3][lock.length*3];

        for(int i=0;i<lock.length;i++) {
            for(int j=0;j<lock.length;j++) {
                resultMap[i+lock.length][j+lock.length] = lock[i][j];
            }
        }
        func1(resultMap,key,0);
        return result;
    }

    // key + resultMap (value)
    // startcol,startrow : key index 이걸 반복문 시작인자로 넣고 ~ keylength+col/row 까지 반복
    public static void func1(int resultMap[][], int key[][], int count) {
        addNCheck(resultMap,key,0,0);
        if(result) {
            return;
        }
        if(count >= 4) {
            return;
        }
        int ratatedKey[][] = rotaion(key);
        func1(resultMap,ratatedKey,count+1);
        return;
    }
    // check values range of lockSizeMap in resultMap :
    // 검수 완료
    public static void addNCheck(int resultMap[][], int key[][],int startcol, int startrow)  {
        if(result) {
            return;
        }
        if(startrow+key.length > resultMap.length) {
            startrow = 0;
            startcol++;
        }
        if(startcol+key.length > resultMap.length) {
            return;
        }

        int tempMap[][] = new int[resultMap.length][resultMap.length];

        //copy lock arr
        for(int i=0;i<resultMap.length;i++) {
            for(int j=0;j<resultMap.length;j++) {
                tempMap[i][j] = resultMap[i][j];
            }
        }

        boolean notMatchflag = false;
        loop:
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                if(key[i][j] == 1) {
                    if(tempMap[i+startcol][j+startrow] == 1) {
                        notMatchflag = true;
                        break loop;
                    }
                    tempMap[i+startcol][j+startrow] = key[i][j];
                }
            }
        }
        if(!notMatchflag) {
            loop:
            for(int i=0;i<resultMap.length/3;i++) {
                for(int j=0;j<resultMap.length/3;j++) {
                    if(tempMap[i+resultMap.length/3][j+resultMap.length/3] != 1) {
                        notMatchflag = true;
                        break loop;
                    }
                }
            }
        }
        if(!notMatchflag) {
            result = true;
        }
        addNCheck(resultMap,key,startcol,startrow+1);
    }

    // 검수 완료
    public static int[][] rotaion(int map[][]) {
        int N = map.length;
        int tempMap[][] = new int[N][N];
        for (int col=0;col<N;col++) {
            for (int row=0;row<N; row++) {
                tempMap[col][row] = map[N-row-1][col];
            }
        }

        return tempMap;
    }

    //print arr
    public static void printarr(int map[][]) {
        int mapsize = map.length;
        for(int i=0;i<mapsize;i++) {
            for(int j=0;j<mapsize;j++) {
                System.out.printf(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("---------------------------");
    }
}
