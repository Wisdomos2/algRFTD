package Searching;
import java.util.*;

public class FindSosu_Prgs {
        public static void main(String[] args) {

            String input = "17";

            System.out.println(solution(input));



            return;

        }



        public static int solution(String numbers) {

            String divide[] = numbers.split("");

            int arr[] = new int[divide.length];



            for(int i=0;i<divide.length;i++) {

                arr[i] = Integer.parseInt(divide[i]);

            }



            Set<Integer> sosulist = new HashSet<Integer>();

            //1~arr.length 자리까지.

            for(int i=1;i<=arr.length;i++) {

                mixNums(divide, 0, i, sosulist);

            }

            return sosulist.size();

        }

        // 순열 만들기 ( 중복허용)

        public static void mixNums(String arr[], int depth, int k, Set sosulist) {

            if(depth == k) {

                String num = "";

                for(int i=0;i<k;i++) {

                    num = num + String.valueOf(arr[i]);

                }

                checksosu(sosulist, Integer.parseInt(num));



                return;

            }

            else {

                for(int i=depth; i<arr.length;i++) {

                    swap(arr, i, depth);

                    mixNums(arr, depth + 1, k, sosulist);

                    swap(arr, i, depth);

                }

            }

        }



        public static void swap(String arr[], int i, int j) {

            String temp = arr[i];

            arr[i] = arr[j];

            arr[j] = temp;

        }



        //소수인지 체크 함

        public static void checksosu(Set sosulist, int num) {

            boolean sosu = true;

            if(num <= 1) {

                return;

            }

            for(int i=2;i<=Math.sqrt(num);i++) {

                if(num%i == 0){

                    sosu = false;

                    break;

                }

            }

            if(sosu) {

                sosulist.add(num);

            }

        }

    }
