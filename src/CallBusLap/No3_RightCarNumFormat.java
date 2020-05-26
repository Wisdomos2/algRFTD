package CallBusLap;

public class No3_RightCarNumFormat {
    /*
        차량번호 확인하기
     */
    public static void main(String[] args) {
        System.out.println("--------------------------------------------------");
        System.out.println("***TEST CASE***");
        test();
        return;

    }

    private static boolean isRightCarNumFormat(String carNum) {
        if(carNum.length() != 9) {
            return false;
        }

        for(int i=0;i<carNum.length();i++) {
            switch (i) {
                case 0: // 문자
                    if(!Character.isLetter(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 1: // 문자
                    if(!Character.isLetter(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 2: // 숫자
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 3: // 숫자
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 4: // 문자
                    if(!Character.isLetter(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 5:
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 6:
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 7:
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
                case 8:
                    if(!Character.isDigit(carNum.charAt(i))) {
                        return false;
                    }
                    break;
            }
        }

        return true;
    }


    private static void test() {

        // 정상적인 차 번호
        System.out.println("--------------------------------------------------");
        String carNum1 = "서울27가8421";
        System.out.println("정상적인 차 번호 / " + carNum1 + " -> " + isRightCarNumFormat(carNum1));

        // 차 번호 길이가 올바르지 않을 때
        String carNum2 = "서울27가";
        System.out.println("차 번호 길이가 올바르지 않을 때 / " + carNum2 + " -> " + isRightCarNumFormat(carNum2));

        // index 0,1에 문자가 오지 않을 때
        String carNum3 = "1127가8421";
        System.out.println("index 0,1에 문자가 오지 않을 때 / " + carNum3 + " -> " + isRightCarNumFormat(carNum3));

        // index 2,3에 숫자가 오지 않을 때
        String carNum4 = "서울콜랩가8421";
        System.out.println("index 2,3에 숫자가 오지 않을 때 / " + carNum4 + " -> " + isRightCarNumFormat(carNum4));

        // index 4에 문자가 오지 않을 때
        String carNum5 = "서울2738421";
        System.out.println("index 4에 문자가 오지 않을 때 / " + carNum5 + " -> " + isRightCarNumFormat(carNum5));

        //index 5,6,7,8에 숫자가 오지 않을 때
        String carNum6 = "서울27가콜버스랩";
        System.out.println("index 5,6,7,8에 숫자가 오지 않을 때 / " + carNum6 + " -> " + isRightCarNumFormat(carNum6));
        System.out.println("--------------------------------------------------");

    }
}
