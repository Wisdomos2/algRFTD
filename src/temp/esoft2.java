package temp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class esoft2 {
    public static void main(String[] args) {
        int A[] = {51,71,17,42};
        System.out.println(solution(A));
    }

    public static int solution(int[] A) {

        Map<Integer, ArrayList<Integer>> map = new HashMap<>();

        for(int i=0;i<A.length;i++) {
            String temp[] = String.valueOf(A[i]).split("");
            int tempResult = 0;
            for(int j=0;j<temp.length;j++) {
                tempResult += Integer.parseInt(temp[j]);
            }
            if(map.containsKey(tempResult)) {
                ArrayList<Integer> getList = map.get(tempResult);
                getList.add(A[i]);
                map.replace(tempResult,map.get(tempResult),getList);
            }
            else {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(A[i]);
                map.put(tempResult, list);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int key : map.keySet()) {
            if(map.get(key).size() > 1) {
                ArrayList<Integer> list = map.get(key);

                int temp = 0;
                for(int i=0;i<list.size()-1;i++) {
                    int valueA = list.get(i);
                    for(int j=i+1;j<list.size();j++) {
                        int valueB = list.get(j);
                        if(valueA + valueB > temp) {
                            temp = valueA + valueB;
                        }
                    }
                }
                if(result < temp) {
                    result = temp;
                }
            }
        }

        if(result == Integer.MIN_VALUE) {
            return -1;
        }
        else {
            return result;
        }

    }

}
