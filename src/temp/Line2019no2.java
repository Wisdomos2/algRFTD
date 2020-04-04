package temp;

import java.util.Arrays;

public class Line2019no2 {
    public static void main(String[] args) {

        int arr[] = {1,0,2};
        int result = solution(5, arr);
        System.out.println(result);
    }

    static int count = 0;
    static int globalK;
    public static int solution(int k, int arr[]) {
        globalK = k;
        int maxLength = arr.length;
        Arrays.sort(arr);

        getCase(arr, 0, new int[arr.length]);



        return 0;
    }

    public static void getCase(int arr[], int depth, int result[]) {
        if(depth == result.length) {
            count++;
            if(count == globalK) {
                for(int i=0;i<result.length;i++) {
                    System.out.printf(result[i] + " ");
                }
                System.out.println();
                return;
            }
        }
        else {
            for(int i=0;i<arr.length;i++) {
                if(arr[i] == -1) {
                    continue;
                }
                else {
                    int inputArr[] = new int[arr.length];
                    for(int k=0;k<arr.length;k++) {
                        inputArr[k] = arr[k];
                    }

                    result[depth] = inputArr[i];
                    inputArr[i] = -1;


                    getCase(inputArr, depth+1,result);
                }
            }
        }
    }
}
