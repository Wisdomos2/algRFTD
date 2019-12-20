package study;

import java.util.*;

public class EatEatEat {
    public static void main(String[] args) {
        int foodtimes[] = {3, 1, 2};
        long k = 5;
        System.out.println(solution(foodtimes,k));
    }

    /*/
        너무 쉽다고 생각했나, 10분 컷일리가 없지. while , queue 해서 효율성 싹다 광탈잼
        효율성 나오면 정렬하고 완탐을 지.양하는 방식으로 푼다.

     */
    public static int solution(int[] food_times, long k) {
        int answer = 0;

        List<Info> food = new LinkedList<>();
        int size = food_times.length;

        //init
        for(int i=0;i<size;i++) {
            food.add(new Info(i+1,food_times[i]));
        }

        //time 순 정렬
        Comparator<Info> cmpTime = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.time - o2.time;
            }
        };

        //index 순 정렬: 맨마지막에 다시 돌리기 위함.
        Comparator<Info> cmpIndex = new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                return o1.index - o2.index;
            }
        };

        food.sort(cmpTime);
        int preTime = 0;
        int nowindex = 0;
        for(Info info : food) {
            // 다음거랑 시간 차이.
            long cha2Time = info.time - preTime;
            // 0이면 연산 할 필요가 없음.
            if(cha2Time != 0) {
                long spendTime = cha2Time * size;
                if(spendTime <= k) {
                    k = k - spendTime;
                    preTime = info.time;
                }
                else {
                    // index 가려내기
                    k = k%size;
                    food.subList(nowindex,food_times.length).sort(cmpIndex);
                    return food.get(nowindex+(int)k).index;
                }
            }
            nowindex++;
            size--;
        }

        return -1;
    }

    public static class Info {
        int index;
        int time;

        public Info(int index, int time) {
            this.index = index;
            this.time = time;
        }

    }

}
