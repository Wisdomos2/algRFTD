package study;

import java.util.*;

public class TravelRoute_Prg {
    public static void main(String[] args) {
        String tikets[][] = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}};
        String tikets2[][] = {{"ICN","SFO"},{"ICN","ATL"},{"SFO","ATL"},{"ATL","ICN"},{"ATL","SFO"}};
//        String result1[] = solution(tikets);
//        String return1[] = {"ICN","JFK","HND","IAD"};
//        for(String i :  result1) {
//            System.out.printf(i + " ");
//        }

//        String result2[] = solution(tikets2);
//        String return2[] = {"ICN","ATL","ICN","SFO","ATL","SFO"};
//        for(String i :  result2) {
//            System.out.printf(i + " ");
//        }

        String tikets3[][] = {{"ICN","BOO"},{"ICN","COO"},{"COO","DOO"},{"DOO","COO"},{"BOO","DOO"},{"DOO","BOO"},{"BOO","ICN"},{"COO","BOO"}};
        String[][] tickets = {{ "ICN", "AOO" },{ "AOO", "BOO" },{ "BOO", "ICN" },{"ICN","AOO"},{"ICN","AOO"}};
        String result3[] = solution(tikets3);
        for(String i :  result3) {
            System.out.printf(i + " ");
        }

    }

    /*
        HashMap<String,ArrayList<String> 형태로 짰다가 대가뤼 뽀사지고 visited check하기 넘 어려워서 다시.
        다시 돌아올수 있어야한다.
        꼭 손으로 쓰면서 눈으로 다시 보기 !!!!!!!!!!!!
        dfs / backtracking , vistied false로 놓는부분!
    */
    static ArrayList<String> cities = new ArrayList<>();
    static boolean visited[] = null;
    static boolean completed = false;
    static String answer[] = null;
    public static String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        //String answer[];
        boolean visited[] = new boolean[tickets.length];

        //sort , 출발지가 같으면 도착지점으로 정렬, 출발지 같은거 없으면 앞에 것으로 정렬.
        Arrays.sort(tickets,(o1, o2) -> {
            if(o1[0].equals(o2[0])){
                return o1[1].compareTo(o2[1]);
            }
            else{
                return o1[0].compareTo(o2[0]);
            }
        });

        cities.add("ICN");
        dfs(tickets,"ICN",0,tickets.length);


        return answer;
    }

    public static void dfs(String tickets[][], String now, int depth, int depthmax) {
        // 끝났는데, 나머지 경우에 대해서 더 할 필요가 없음 (이미 정렬해놓아서 조건만족)
        if(completed) {
            return;
        }
        if(depth == depthmax) {
            completed = true;
            answer = new String[cities.size()];
            for(int i=0;i<answer.length;i++) {
                answer[i] = cities.get(i);
            }
            return;
        }

        for(int i=0;i<tickets.length;i++) {
            if(tickets[i][0].equals(now) && !visited[i]) {
                cities.add(tickets[i][1]);
                visited[i] = true;
                dfs(tickets,tickets[i][1],depth+1,depthmax);

                //backtracking
                visited[i] = false;
                //tickets[i][1]과 같은 것중 마지막 index에 있는거 삭제.
                cities.remove(cities.lastIndexOf(tickets[i][1]));
            }
        }
    }


}
