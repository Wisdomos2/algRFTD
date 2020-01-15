package study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    게리멘더링
    Simulation, DFS / GaryManthering2_Boj
*/
public class GaryManthering_Boj {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        arr = new int[N+1];
        visited = new int[N+1];
        for(int i=1;i<=N;i++) {
            arr[i] = scanner.nextInt();
        }

        list = new ArrayList<>();
        list.add(new ArrayList<>());
        for(int i=0;i<N;i++) {
            int size = scanner.nextInt();
            list.add(new ArrayList<>());
            for(int j=0;j<size;j++) {
                int temp = scanner.nextInt();
                list.get(i+1).add(temp);
            }
        }

        getCase(1);
        scanner.close();
        if(result == Integer.MAX_VALUE) {
            System.out.println(-1);
            return;
        }
        System.out.println(result);
        return;


    }

    static int N = 0;
    static int arr[];
    static int visited[];
    static ArrayList<ArrayList<Integer>> list;
    static int result = Integer.MAX_VALUE;

    public static void getCase(int index) {

        if(index == N+1) {
            /* 두 구역으로 나누어져있고, 잘 연결되었을 때  */
            if(AandBCoexistence()&&RightConnection()) {
                int difference = differenceInvalue();
                result = Math.min(difference,result);
            }
            return;
        }
        else {
            for(int k=1;k<=2;k++) {
                visited[index] = k;
                getCase(index+1);
            }
        }
    }

    // 1, 2모두 존재하는지
    public static boolean AandBCoexistence() {
        boolean Aflag = false;
        boolean Bflag = false;
        for(int i=1;i<visited.length;i++) {
            if(visited[i] == 1) {
                Aflag = true;
            }
            if(visited[i] == 2) {
                Bflag = true;
            }
        }

        if(Aflag && Bflag) {
            return true;
        }

        return false;
    }

    //각각 제대로 연결되어있는지
    static boolean connectionVisited[];
    public static boolean RightConnection() {
        Queue<Integer> teamA = new LinkedList<>();
        Queue<Integer> teamB = new LinkedList<>();

        for(int i=1;i<visited.length;i++) {
            if(visited[i] == 1 && teamA.isEmpty()) {
                teamA.add(i);
            }
            if(visited[i] == 2 && teamB.isEmpty()) {
                teamB.add(i);
            }
            if(!teamA.isEmpty() && !teamB.isEmpty()) {
                break;
            }
        }

        if(!checkTeamLinked(teamA,1) || !checkTeamLinked(teamB,2)) {
            return false;
        }
        return true;
    }


    private static boolean checkTeamLinked(Queue<Integer> team, int value) {
        connectionVisited = new boolean[N+1];
        connectionVisited[team.peek()] = true;

        while (!team.isEmpty()){
            int q = team.poll();
            ArrayList<Integer> semi_List = list.get(q);
            for(int k=0;k<semi_List.size();k++) {
                int index = semi_List.get(k);
                if(!connectionVisited[index] && visited[index] == value) {
                    team.offer(index);
                    connectionVisited[index] = true;
                }
            }

        }

        for(int i=1; i<N+1; ++i){
            if(visited[i] == value && !connectionVisited[i]){
                return false;
            }
        }

        return true;
    }


    // 두 선거구의 차이
    public static int differenceInvalue() {
        int resultA = 0;
        int resultB = 0;

        for(int i=1;i<visited.length;i++) {
            if(visited[i] == 1) {
                resultA += arr[i];
            }
            if(visited[i] == 2) {
                resultB += arr[i];
            }
        }

        int differ = resultA - resultB;

        return differ > -1 ? differ : Math.abs(resultA - resultB);
    }

}
