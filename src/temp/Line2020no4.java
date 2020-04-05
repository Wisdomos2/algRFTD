package temp;

import java.util.*;

public class Line2020no4 {
    public static void main(String[] args) {
        String snapshots[][] = {
  {"ACCOUNT1", "100"}, 
  {"ACCOUNT2", "150"}
};
        String transactions[][] = {
                {"1", "SAVE", "ACCOUNT2", "100"},
  {"2", "WITHDRAW", "ACCOUNT1", "50"}, 
  {"1", "SAVE", "ACCOUNT2", "100"}, 
  {"4", "SAVE", "ACCOUNT3", "500"}, 
  {"3", "WITHDRAW", "ACCOUNT2", "30"}
        };


        String result[][] = solution(snapshots,transactions);
        for(int i=0;i<result.length;i++) {
            System.out.printf(result[i][0] + " " + result[i][1]);
        }
        System.out.println();

    }
    public static String[][] solution(String[][] snapshots, String[][] transactions) {
        String[][] answer = {};

        Map<String,Integer> bank = new HashMap<>();
        for(int i=0;i<snapshots.length;i++) {
            bank.put(snapshots[i][0],Integer.parseInt(snapshots[i][1]));
        }

        for(int i=0;i<transactions.length-1;i++) {
            String tempID = transactions[i][0];
            for(int j=i+1;j<transactions[0].length;j++) {
                if(transactions[j][0].equals(tempID)) {
                    transactions[j][0] = "0";
                }
            }
        }

        for(int i=0;i<transactions.length;i++) {
            if(transactions[i][0].equals("0")) {
                continue;
            }
            String accountName = transactions[i][2];
            if(!bank.containsKey(accountName)) {
                bank.put(accountName,0);
            }
                String order = transactions[i][1];
                //출금
                if(order.equals("WITHDRAW")) {
                    bank.replace(accountName,bank.get(accountName)-Integer.parseInt(transactions[i][3]));
                }
                //저장
                else if(order.equals("SAVE")) {
                    bank.replace(accountName,bank.get(accountName)+Integer.parseInt(transactions[i][3]));
                }
        }

        ///여기
        List<Map.Entry<String, Integer>> list = new LinkedList<>(bank.entrySet());
        Collections.sort(list, (o1, o2) -> {
            return o1.getKey().compareTo(o2.getKey());
        });

        answer = new String[list.size()][2];
        for(int i=0;i<list.size();i++) {
            answer[i][0] = list.get(i).getKey();
            answer[i][1] = String.valueOf(list.get(i).getValue());
        }


        return answer;
    }
}
