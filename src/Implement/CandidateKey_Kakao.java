package Implement;

public class CandidateKey_Kakao {
    public static void main(String[] args) {
        String relaion[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};
        System.out.println(solution(relaion));
        return;

    }
    public static int solution(String[][] relation) {
        int answer = 0;

        for(int i=0;i<relation[0].length;i++) {
            String inputArr[][] = initRow(relation,i);
            //행
            if(!checkSame(inputArr)) {
                System.out.println(i + " 가 후보키로 사용됩니다.");
                answer++;
            }
            else {
                answer = answer + merge(relation,i,inputArr);
            }

        }
        return answer;
    }

    public static int merge(String[][] relation, int row, String[][] nowrelation) {
        if(row == relation[0].length-1) {
            return 0;
        }
        else {
            for(int k=0;k<nowrelation.length;k++) {
                nowrelation[k][0] = nowrelation[k][0] + relation[k][row+1];
            }
            if(!checkSame(nowrelation)) {
                System.out.println(row + " / " + (row+1) + "가 후보키로 사용됩니다. ");
                return 1;
            }
            else {
                merge(relation,row+1,nowrelation);
            }

        }

        return 0;

    }

    public static boolean checkSame(String[][] inputArr) {
        for(int i=0;i<inputArr.length-1;i++) {
            String a = inputArr[i][0];
            for(int j=i+1;j<inputArr.length;j++) {
                if(inputArr[i][0].equals(inputArr[j][0])) {
                    return true;
                }
            }
        }
        return false;
    }

    public static String[][] initRow(String [][] relation, int row) {
        String result[][] = new String[relation.length][1];
        for(int i=0;i<relation.length;i++) {
            result[i][0] = relation[i][row];
        }

        return result;
    }
}
