package study;

public class temp {
    public static void main(String[] args) {

        int arr[] = new int[2];
        arr[0] = 7;
        arr[1] = 8;

        arr[1] = arr[0] + arr[1];
        arr[1] = arr[1] - arr[0];

        System.out.println(arr[0] + " " + arr[1]);


    }
}
