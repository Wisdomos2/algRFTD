package temp;

import java.util.*;

public class Line2020no3 {
    public static void main(String[] args) {
        String datasource[][] = {
    {"doc1", "t1", "t2", "t3"},
    {"doc2", "t0", "t2", "t3"},
    {"doc3", "t1", "t6", "t7"},
    {"doc4", "t1", "t2", "t4"},
    {"doc5", "t6", "t100", "t8"}};
        String tags[] = {"t1", "t2", "t3"};
        String[] result = solution(datasource,tags);
        for(int i=0;i<result.length;i++) {
            System.out.println(result[i]);
        }
        return;

    }
    public static String[] solution(String[][] dataSource, String[] tags) {
        String[] answer = {};
        Map<String, Integer> map = new HashMap<>();

        for(int i=0;i<dataSource.length;i++) {
            map.put(dataSource[i][0],0);
            for(int t=0;t<tags.length;t++) {
                String tag = tags[t];
                for(int j=1;j<dataSource[0].length;j++) {
                    if(dataSource[i][j].equals(tag)) {
                        map.replace(dataSource[i][0],map.get(dataSource[i][0])+1);
                    }
                }
            }
            if(map.get(dataSource[i][0]) == 0) {
                map.remove(dataSource[i][0]);
            }
        }

        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> {
            int returnCompVal = o2.getValue().compareTo(o1.getValue());
            return returnCompVal == 0 ? o1.getKey().compareTo(o2.getKey()) : returnCompVal;
        });


        answer = new String[list.size()];
        for(int i=0;i<list.size();i++) {
            answer[i] = list.get(i).getKey();
        }



        return answer;
    }
}
