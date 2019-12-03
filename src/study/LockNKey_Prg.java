package study;
/*
    https://programmers.co.kr/learn/courses/30/lessons/60059
    https://dundung.tistory.com/138 참고
 */
public class LockNKey_Prg {
    public static void main(String[] args) {
        int inputkey[][] = {{0, 0, 0}, {1, 0, 0}, {0, 1, 1}};
        int inputlock[][] = {{1, 1, 1}, {1, 1, 0}, {1, 0, 1}};

        test(inputkey,inputlock);
        System.out.println(solution(inputkey,inputlock));

    }

    public static void test(int[][] key, int[][] lock) {
        int keyMapSize = key.length;
        int lockMapSize = lock.length;
        int resultMapSize = lockMapSize*3;

        int resultMap[][] = new int[resultMapSize][resultMapSize];

        for(int i=lockMapSize;i<lockMapSize*2;i++) {
            for(int j=lockMapSize;j<lockMapSize*2;j++) {
                resultMap[i][j] = lock[i-lockMapSize][j-lockMapSize];
            }
        }

        for (int i = 0; i < resultMapSize; i++) {
            for (int j = 0; j < resultMapSize; j++) {
                System.out.printf(resultMap[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("-----------");
        addNCheck(resultMap,key,lockMapSize,0,0);




        return;
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
        int keyMapSize = key.length;
        int lockMapSize = lock.length;
        int resultMapSize = lockMapSize*3;

        int resultMap[][] = new int[resultMapSize][resultMapSize];

        for(int i=lockMapSize;i<lockMapSize*2;i++) {
            for(int j=lockMapSize;j<lockMapSize*2;j++) {
                resultMap[i][j] = lock[i-lockMapSize][j-lockMapSize];
            }
        }

        // resultMap print
//        for(int i=0;i<resultMapSize;i++) {
//            for(int j=0;j<resultMapSize;j++) {
//                System.out.printf(resultMap[i][j] + " ");
//            }
//            System.out.println();
//        }

        return func1(resultMap,key,lockMapSize,0,0);
    }

    // key + resultMap (value)
    // startcol,startrow : key index 이걸 반복문 시작인자로 넣고 ~ keylength+col/row 까지 반복
    // 안되는 이유  : resultMap 이 재탕되는 거같음 .
    public static boolean func1(int resultMap[][], int key[][], int checkindex ,int startcol, int startrow) {
        int dc[] = {0,1};
        int dr[] = {1,0};
        int nextcol = 0;
        int nextrow = 0;

        for(int i=0;i<4;i++) {
            if(i==3) {
                key = rotaion(key, key.length);
                continue;
            }
            else {
                if(addNCheck(resultMap,key,checkindex,startcol,startrow)) {
                    return true;
                }
                key = rotaion(key, key.length);
            }
        }

        for(int i=0;i<2;i++) {
            nextcol = startcol + dc[i];
            nextrow = startrow + dr[i];
            if(nextcol <= (resultMap.length-checkindex) && nextrow <= (resultMap.length-checkindex)) {
                return func1(resultMap,key,checkindex,nextcol,nextrow);
            }
        }
        return false;
    }
    // check values range of lockSizeMap in resultMap : ok
    public static boolean addNCheck(int resultMap[][], int key[][], int checkindex ,int startcol, int startrow) {
        int resultMapSize = resultMap.length;

        //add
        for(int i=0;i<key.length;i++) {
            for(int j=0;j<key.length;j++) {
                if(i+startcol < resultMapSize && j+startrow < resultMapSize) {
                    resultMap[i+startcol][j+startrow] += key[i][j];
                }
            }
        }
        //check , range : checkindex ~ <checkindex*2
        for(int i=checkindex;i<checkindex*2;i++) {
            for(int j=checkindex;j<checkindex*2;j++) {
                if(resultMap[i][j] != 1) {
                    return false;
                }
            }
        }

        return true;
    }


    public static int[][] rotaion(int map[][], int N) {
        int tempMap[][] = new int[N][N];
        for (int col=0;col<N;col++) {
            for (int row=0;row<N; row++) {
                tempMap[col][row] = map[N-row-1][col];
            }
        }
        return tempMap;
    }
}
