package temp;

public class esoft3 {
    public static void main(String[] args) {
        int A[] = {1,3,1,2};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {
        // write your code in Java SE 8
        int result = 0;
        if(checkRole(A)) {
            return 0;
        }
        else {
            //해당 인덱스 뺴고 복사해서 검사 후 true이면 reuslt++
            for(int i=0;i<A.length;i++) {
                int copyArr[] = new int[A.length-1];
                if(i==0) {
                    for(int k=0;k<copyArr.length;k++) {
                        copyArr[k] = A[k+1];
                    }
                }
                else if(i == A.length-1) {
                    for(int k=0;k<copyArr.length;k++) {
                        copyArr[k] = A[k];
                    }
                }
                else {
                    for(int k=0;k<i;k++) {
                        copyArr[k] = A[k];
                    }
                    for(int k=i;k<copyArr.length;k++) {
                        copyArr[k] = A[k+1];
                    }
                }

                if(checkRole(copyArr)) {
                    result++;
                }


            }

        }
        if(result == 0) {
            result = -1;
        }

        return result;
    }

    public static boolean checkRole(int[] A) {
        //위로 시작
        if(A[0] < A[1]) {
            for(int i=0;i<A.length;i=i+2) {
                if(i+1 < A.length) {
                    if(A[i] > A[i+1]) {
                        return false;
                    }
                }
            }
            for(int i=1;i<A.length;i=i+2) {
                if(i+1 < A.length) {
                    if(A[i] < A[i+1]) {
                        return false;
                    }
                }
            }
        }
        else if (A[0] > A[1]){
            for(int i=0;i<A.length;i=i+2) {
                if(i+1 < A.length) {
                    if(A[i] < A[i+1]) {
                        return false;
                    }
                }
            }
            for(int i=1;i<A.length;i=i+2) {
                if(i+1 < A.length) {
                    if(A[i] > A[i+1]) {
                        return false;
                    }
                }
            }
        }
        else {
            return false;
        }

        return true;
    }
}
