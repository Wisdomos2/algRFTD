package CallBusLap;

import java.util.Scanner;

public class No1_ServiceTime {
    /*
        콜버스 운행여부 확인하기
     */

    public static void main(String[] args) {


        System.out.println("요일과 날짜를 입력하세요.");
        Scanner sc = new Scanner(System.in);

        int inputDay = sc.nextInt();
        int inputHourOfDay = sc.nextInt();

        System.out.println(isServiceTime(inputDay,inputHourOfDay));
        System.out.println("--------------------------------------------------");
        System.out.println("***TEST CASE***");
        test();
        return;

    }


    private static boolean isServiceTime(int day, int hourOfDay) {

        if(day < 0 || day > 6 || hourOfDay < 0 || hourOfDay > 23) {
            return false;
        }

        switch (day) {
            case 6 :
                return false;
            case 2 :
                if(hourOfDay == 22 || hourOfDay == 23) {
                    return true;
                }
                else if (hourOfDay < 4) {
                    return true;
                }
                else {
                    return false;
                }
                default :
                   if(hourOfDay == 23) {
                       return true;
                   }
                   else if(hourOfDay < 4) {
                       return true;
                   }
                   else {
                       return false;
                   }
        }
    }

    private static void test() {
        System.out.println("--------------------------------------------------");
        System.out.println("일요일 23시 -> expect : false / result : " + isServiceTime(6,23));
        System.out.println("수요일 22시 -> expect : true / result : " + isServiceTime(2,22));
        System.out.println("평일 21시 -> expect : false / result : " + isServiceTime(5,21));
        System.out.println("평일 0시 -> expect : true / result : " + isServiceTime(5,0));
        System.out.println("평일 03시 -> expect : true / result : " + isServiceTime(5,3));
        System.out.println("--------------------------------------------------");
    }
}
