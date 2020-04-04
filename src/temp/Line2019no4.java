package temp;

public class Line2019no4 {
    public static void main(String[] args) {

        int arr[] = {1 ,0, 1, 0, 0, 0, 1};
        int positionCount = 3;
        int inputArr[] = new int[3];
        inputArr[0] = 0;
        inputArr[1] = 2;
        inputArr[2] = 6;



        System.out.println(solution(inputArr));
        return;
    }

    public static int solution(int arr[]) {
        int result = Integer.MAX_VALUE;

        for(int i=0;i<arr.length-1;i++) {
            for(int j=i+1;j<arr.length;j++) {
                result = Math.min(result, Math.abs(arr[i]-arr[j]));
            }
        }


        return result;

    }


}
