package Kakao2019;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
/*
    map, list를 사용할 수 있는지.
 */

public class openTalk {
    public static void main(String[] args) {

        String records[] = {"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"};

        Solution(records);

        return;
    }

    /*
    ["Prodo님이 들어왔습니다.", "Ryan님이 들어왔습니다.", "Prodo님이 나갔습니다.", "Prodo님이 들어왔습니다."]
     */
    static void Solution(String records[]) {
        String answer[] = null;
        Map<String, String> idmap = new HashMap<String, String>();
        List<String[]> temp = new LinkedList<String[]>();

        for(String i : records) {
            String msg[] = i.split(" ");
            if(msg[0].equals("Enter")) {
                if(idmap.containsKey(msg[1])) {
                    idmap.replace(msg[1],msg[2]);
                    temp.add(msg);
                }
                else {
                    idmap.put(msg[1],msg[2]);
                    temp.add(msg);
                }
            }
            else if(msg[0].equals("Leave")) {
                temp.add(msg);
            }
            else if(msg[0].equals("Change")) {
                idmap.replace(msg[1],msg[2]);
            }
        }

        answer = new String[temp.size()];

        for(int i=0;i<temp.size();i++) {
            String outmsg[] = temp.get(i);
            String sign = outmsg[0];
            String name = idmap.get(outmsg[1]);
            if(sign.equals("Enter")) {
                answer[i] = name + "님이 들어왔습니다.";
            }
            else if(sign.equals("Leave")) {
                answer[i] = name + "님이 나갔습니다.";
            }
        }

        for(String test : answer) {
            if(test != null) {
                System.out.println(test);
            }
        }


        return;

    }
}
