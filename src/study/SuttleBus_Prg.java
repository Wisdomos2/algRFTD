package study;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SuttleBus_Prg {
    public static void main(String[] args) {
        int n = 2;
        int t = 10;
        int m = 2;
        String timetable[] = {"09:10", "09:09", "08:00"};
        System.out.println(solution(n,t,m,timetable));
        return;

    }
    /*
        n = 셔틀 운행 횟수
        t = 셔틀 운행 간격
        m = 한 셔틀에 최대 탈수 있는 크루 수
        timetable = 크루가 대기열에 도착하는 수
        구해야하는 것 :콘이 셔틀을 타고 사무실에 도착할때 가장 늦은 시간
     */
    public static String solution(int n, int t, int m, String[] timetable){
        String answer = "";
        Arrays.sort(timetable);

        if(n < 1 || t < 1 || m < 1 || timetable.length < 1) {
            return new String("fail");
        }
        if(n > 10 || n > 60 || m > 45 || timetable.length > 2000) {
            return new String("fail");
        }


        Queue<String> q = new LinkedList<String>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        long startTime = 0;
        long endTime = 0;
        try {
            startTime = dateFormat.parse("09:00").getTime();
            endTime = startTime + (1000 * 60) * t * n;

        }
        catch (ParseException e) {
            e.printStackTrace();
            return new String("fail");
        }

        for(int i=0;i<timetable.length;i++) {
            q.add(timetable[i]);
        }

        for(long i=startTime;i<=endTime;i=i+(1000 * 60) * t){
            int maxM = 0;
            while(!q.isEmpty()) {
                if(maxM > m) {
                    break;
                }
                try {
                    if(dateFormat.parse(q.peek()).getTime() > i) {
                        break;
                    }
                    else {
                        String temp = q.poll();
                        answer = temp;
                        maxM++;
                    }
                }
                catch (ParseException e) {
                    return new String("fail");
                }
            }
            if(q.isEmpty()) {
                return answer;
            }

        }



        return answer;
    }
}
