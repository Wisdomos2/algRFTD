package temp;

public class Line2020no5 {
    public static void main(String[] args) {

    }

    public int solution(String answer_sheet, String[] sheets) {
        int answer = -1;
        String answerArr[] = answer_sheet.split("");

        for(int i=0;i<sheets.length-1;i++) {
            String base[] = sheets[i].split("");
            for(int j=i+1;j<sheets.length;j++) {
                String compareArr[] = sheets[j].split("");
                int Xcnt = 0;
                for(int k=0;k<base.length;k++) {
                    if(base[k].equals(compareArr[k])) {
                        if(!base[k].equals(answerArr[k])) {
                            Xcnt++;
                        }
                    }
                }
            }
        }


        return answer;
    }
}
