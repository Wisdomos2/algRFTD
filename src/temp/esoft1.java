package temp;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class esoft1 {
    public static void main(String[] args) {
        int A[] = {3,8,2,3,3};

        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<A.length;i++) {
            if(map.containsKey(A[i])) {
                map.replace(A[i],map.get(A[i])+1);
            }
            else {
                map.put(A[i],1);
            }
        }

        int result = Integer.MIN_VALUE;
        for(int key : map.keySet()) {
            int temp = map.get(key);
            if(key == temp && result < temp) {
                result = temp;
            }
        }

        if(result == Integer.MIN_VALUE) {
            System.out.println(0);
        }
        else {
            System.out.println(result);
        }



    }
}
