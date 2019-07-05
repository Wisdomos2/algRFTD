package X.Prgmers;

import java.util.HashMap;

public class Spy_Prgmers {
	public static void main(String[] args) {
		String arr[][] = {{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
		
		System.out.println(solution(arr));
		return;
		
	}
	
	
    static public int solution(String[][] clothes) {
        int answer = 1;
        HashMap<String,Integer> ctg = new HashMap<String,Integer>();
        
        for(int i=0;i<clothes.length;i++) {
        	if(ctg.containsKey(clothes[i][1])) {
        		ctg.replace(clothes[i][1], ctg.get(clothes[i][1]), ctg.get(clothes[i][1])+1);
        	}
        	else if(!ctg.containsKey(clothes[i][1])) {
        		ctg.put(clothes[i][1], 1);
        	}
        }
        
        //+1을 하는이유 위에서는 모두 선택하는 것을 기준. 선택 안 할수도 있기 때문에 그 경우 추가.
        for(int a : ctg.values()) {
        	answer *= (a+1);
        }
        
        //종류별로 모두 선택 안할 수 있는 경우 1개 빼줌.(조건에 무조건 1개는 입으니까.)
        return answer - 1;
    }
}
