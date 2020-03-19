package study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class CsTraffic_Prg {
    public static void main(String[] args) {
        String input1[] = {"2016-09-15 01:00:04.001 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(input1));

        String input2[] = {"2016-09-15 01:00:04.002 2.0s", "2016-09-15 01:00:07.000 2s"};
        System.out.println(solution(input2));

        String input3[] = {
                "2016-09-15 20:59:57.421 0.351s",
                "2016-09-15 20:59:58.233 1.181s",
                "2016-09-15 20:59:58.299 0.8s",
                "2016-09-15 20:59:58.688 1.041s",
                "2016-09-15 20:59:59.591 1.412s",
                "2016-09-15 21:00:00.464 1.466s",
                "2016-09-15 21:00:00.741 1.581s",
                "2016-09-15 21:00:00.748 2.31s",
                "2016-09-15 21:00:00.966 0.381s",
                "2016-09-15 21:00:02.066 2.62s"};
        System.out.println(solution(input3));

    }

    public static int solution(String[] lines) {
        int answer = 0;

        ArrayList<Node> list = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");

        //Parse 떄문에 try - catch 써야함.
        for (int i = 0; i < lines.length; i++) {
            String temp[] = lines[i].split(" ");
            try {
                long getEndTime = dateFormat.parse(temp[0] + " " + temp[1]).getTime();
                long getMidTime = (long)(Double.parseDouble(temp[2].replace("s", "")) * 1000);
                long getStartTime = getEndTime - getMidTime + 1;
                list.add(new Node(getStartTime, getEndTime));

            }
            catch (ParseException e) {
                e.printStackTrace();
                return -1;
            }
        }


        for(int i=0;i<list.size();i++) {
            Node node = list.get(i);

            long getStartTime = node.startTime;
            long getEndTime = node.endTime;

            int startCount = 0;
            int endedCount = 0;

            for(int j=0;j<list.size();j++) {
                Node compareNode = list.get(j);
                //1초 구간 탐색
                if(getStartTime <= compareNode.endTime && getStartTime + 999 >= compareNode.startTime) {
                    startCount++;
                }
                if(getEndTime <= compareNode.endTime && getEndTime + 999 >= compareNode.startTime) {
                    endedCount++;
                }
            }
            if(startCount > answer) {
                answer = startCount;
            }

            if(answer < endedCount) {
                answer = endedCount;
            }
        }

        return answer;
    }

    public static class Node {
        long startTime;
        long endTime;

        public Node(long startTime, long endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}
