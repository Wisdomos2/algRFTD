package study;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CandidateKey_Prg_Bitmask_BruteForce {
    public static void main(String[] args) {
        String relaion[][] = {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}};

        System.out.println(solution(relaion));
        return;
    }
    /*
        Dfs * Set로 풀다가 ㅈ망테크탐. 너무 머리뽀개짐.

        0. Tuple을 유일하게 식별할 수 있는 "속성" or "속성의 집합" 중 조건 만족 = 후보키.
            0-1. 유일성 : 식별 쌉가능.
            0.2. 최소성 : 유일성을 가진 키를 구성하는 속성 중 하나라도 제외하면 유일성 깨지는 경우.

         1. 비트 연산 사용해서 부분집합 구하기.
         2. 비트를 기반으로 해당 row를 기준으로 아래로 내려가면서 같은 값이 있는지 확인하면서 유일성체크.
         3. List에 더해진 것들을 비트를 기반으로 & 연산하여 최소집합인지 확인.

     */


    public static int solution(String relation[][]) {
        int answer = 0;

        List<Integer> list = new ArrayList<>();
        int colsize = relation.length;
        int rowsize = relation[0].length;

        // 0000~10000 make bit mask.
        for(int i=1;i<1<<rowsize;i++) {
            if(compareUnder(relation,colsize,rowsize,i)) {
                list.add(i);
            }
        }

        //최소성 확인. 어차피 가장 작은 것부터 저장되어있음. 1부터~(정렬필요 없음).
        while(list.size() != 0) {
            int init = list.remove(0);
            answer++;

            //중복 제거, 최소성 만족 위해.
            for(Iterator<Integer> it = list.iterator(); it.hasNext();) {
                int next = it.next();
                //init를 포함한 집합이라면 자기 자신이 나오게 됨.!
                //ex) init : 0001
                //ex) next : 1101 & 연산은 0001(init) 즉 최소성 만족.
                if((init & next) == init) {
                    it.remove();
                }
            }

        }

        return answer;
    }

    //아래로 내려가면서 유일성 확인.
    private static boolean compareUnder(String[][] relation, int colsize, int rowsize, int bit) {
        for(int i=0;i<colsize-1;i++) {
            for(int j=i+1;j<colsize;j++) {
                boolean flag = true;
                //속성별 체크.
                for(int k=0;k<rowsize;k++) {
                    if((bit&(1<<k)) == 0) {
                        continue;
                    }
                    if(!relation[i][k].equals(relation[j][k])) {
                        flag = false;
                        break;
                    }
                }
                if(flag) {
                    return false;
                }
            }
        }
        return true;
    }

}
