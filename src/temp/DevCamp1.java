package temp;

public class DevCamp1 {
    public static void main(String[] args) {
        System.out.println(solution("00000000000000000000","91919191919191919191"));
    }

    public static int solution(String p, String s) {
        int answer = 0;

        String pArr[] = p.split("");
        String sArr[] = s.split("");

        for(int i=0;i<pArr.length;i++) {
            int pValue = Integer.parseInt(pArr[i]);
            int sValue = Integer.parseInt(sArr[i]);

            int result = Math.abs(pValue-sValue);
            if(result>5){
                answer +=  10-result;
            }else{
                answer += result;
            }


        }


        return answer;
    }
}
