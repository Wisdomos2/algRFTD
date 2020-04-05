package temp;

import java.util.ArrayList;
import java.util.List;

public class Line2020no1 {
    public static void main(String[] args) {
        String road1 = "111011110011111011111100011111";
        int n1 = 3;
        System.out.println(solution(road1,n1));

        String road2 = "001100";
        int n2 = 5;
        //System.out.println(solution(road2, n2));


    }


    public static int solution(String road, int n) {
        int answer = -1;
        list = new ArrayList<>();


        String roadArr[] = road.split("");
        for(int i=0;i<roadArr.length;i++) {
            if(roadArr[i].equals("0")) {
                list.add(i);
            }
        }

        if(list.size() <= n) {
            return roadArr.length;
        }

        visited = new boolean[list.size()];

        getCase(n, 0,0, roadArr);



        return result;
    }

    private static boolean visited[];
    private static List<Integer> list;
    private static int result = 0;

    private static void getCase(int n, int depth, int nextIndex, String roadArr[]) {
        if(depth == n) {
            String tempString[] = new String[roadArr.length];
            for(int i=0;i<tempString.length;i++) {
                tempString[i] = roadArr[i];
            }

            for(int i=0;i<visited.length;i++) {
                if(visited[i]) {
                    int modifyIndex = list.get(i);
                    tempString[modifyIndex] = "1";
                }
            }

            String sumString = "";
            for(int i=0;i<roadArr.length;i++) {
                sumString += tempString[i];
            }


            String sumStringArr[] = sumString.split("0");

            int maxLength = Integer.MIN_VALUE;
            for(int i=0;i<sumStringArr.length;i++) {
                maxLength = Math.max(maxLength,sumStringArr[i].length());
            }

            result = Math.max(maxLength,result);
            return;


        }
        else {
            for(int i=nextIndex;i<visited.length;i++) {
                visited[i] = true;
                getCase(n, depth+1,i+1, roadArr);
                visited[i] = false;
            }
        }
    }


}
