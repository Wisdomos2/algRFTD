package study;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cache_Prg {
    public static void main(String[] args) {
        int cacheSize1 = 3;
        String cities[] = {"Jeju", "Jeju", "Seoul", "Seoul", "Seoul", "Seoul",
                "Pangyo", "Pangyo", "Jeju","POPO","seoul"};
        String cities2[] = {"Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul","Jeju","Pangyo","Seoul"};
        System.out.println(solution(cacheSize1, cities));

    }

    public static int solution(int cacheSize, String[] cities) {

        String memoryDB[] = new String[cacheSize];
        int memoryCnt = 0;
        int cacheResult = 0;

        if(cacheSize == 0) {
            return cities.length*5;
        }

        for(int i=0;i<cities.length;i++) {
            String inputCity = cities[i].toLowerCase();
            if(inputCity.length() > 20) {
                continue;
            }

            boolean isChar = true;
            for(int k=0;k<inputCity.length();k++) {
                if(!Character.isLetter(inputCity.charAt(k))) {
                    isChar = false;
                    break;
                }
            }
            if(!isChar) {
                continue;
            }

            if(memoryCnt < cacheSize) {
                int index = checkSame(memoryDB,inputCity);
                //있다.
                if(index >= 0) {
                    //그게 처음이다.
                    if(memoryCnt == 0) {
                        memoryCnt++;
                        cacheResult += 1;
                        continue;
                    }
                    else {
                        //아니다 2개 이상있ㄷ.ㅏ

                    }
                }
                else
                {
                    memoryDB[memoryCnt] = inputCity;
                    memoryCnt++;
                    cacheResult += 5;
                }
            }
            else {
                //같은게 있음 해당 인덱스 까지 왼쪽으로 밀고 오른쪽으로  -> c.
                int checkfuncResult = checkSame(memoryDB,inputCity);
                if(checkfuncResult != -1) {
                    if(checkfuncResult == cacheSize-1) {
                        cacheResult += 1;
                        continue;
                    }
                    else {
                        String tempCity = memoryDB[checkfuncResult];
                        for(int k=checkfuncResult;k<memoryDB.length-1;k++) {
                            memoryDB[k] = memoryDB[k+1];
                        }
                        memoryDB[memoryDB.length-1] = tempCity;
                    }
                    cacheResult += 1;

                }
                //같은거 없음 -> 첫번째꺼 없애고 shift 후 끝에 추가
                else {
                    for(int k=0;k<memoryDB.length-1;k++) {
                        memoryDB[k] = memoryDB[k+1];
                    }
                    memoryDB[memoryDB.length-1] = inputCity;
                    cacheResult += 5;
                }
            }
        }
        return cacheResult;
    }

    private static int checkSame(String[] cities, String inputCity) {
        for(int i=0;i<cities.length;i++) {
            if(cities[i].toLowerCase().equals(inputCity)) {
                return i;
            }
        }

        return -1;
    }

    public static int LRUAlgoritm(int cacheSize, String[] cities) {
        int answer = 0;

        if(cacheSize == 0){
            return cities.length * 5;
        }

        LinkedHashMap<String,Integer> hashMap = new LinkedHashMap<>(){
            @Override
            protected boolean removeEldestEntry(Map.Entry<String, Integer> eldest) {
                return cacheSize > 0 ? (this.size() > cacheSize) : false;
            }
        };

        for(int i=0;i<cities.length;i++){
            if(hashMap.containsKey(cities[i].toLowerCase())){
                hashMap.remove(cities[i].toLowerCase());
                hashMap.put(cities[i].toLowerCase(),i);
                answer+=1;
            }else{
                hashMap.put(cities[i].toLowerCase(),i);
                answer+=5;
            }
        }


        return answer;
    }
}
