package Kakao2019;

public class num33 {

    static int count = 0;
    public static void main(String[] args) {

        String input1[] = {"frodo", "fradi", "crodo", "abc123", "frodoc"};
        String input2[] = {"*rodo", "*rodo", "******"};

        System.out.println(solution(input1, input2));
    }

    public static int solution(String[] user_id, String[] banned_id) {
        int answer = 0;
        boolean visited[] = new boolean[user_id.length];

        go(user_id,banned_id,visited,0, banned_id.length);

        answer = count;
        return answer;
    }

    public static void go(String user_id[], String banned_id[], boolean visited[], int now, int max) {
        if(now == max) {
            int sum = 0;
            for(int i=0;i<visited.length;i++) {
                if(visited[i] == true) {
                    sum++;
                }
            }
            if(sum == banned_id.length) {
                count = count + 1;
            }
            return;
        }
        else {
            String ban[] = banned_id[now].split("");
            for(int i=0;i<user_id.length;i++) {
                String check[] = user_id[i].split("");
                if(visited[i] == false) {
                    if(checking(check,ban)) {
                        visited[i] = true;
                        go(user_id,banned_id,visited,now+1,max);
                        visited[i] = false;
                    }
                }
            }
        }
    }

    public static boolean checking(String user[], String ban[]) {

        if(user == null || ban == null) {
            return false;
        }

        if(user.length != ban.length) {
            return false;
        }
        else if(user.length == ban.length) {
            for(int i=0;i<ban.length;i++) {
                if(ban[i].equals("*")) {
                    continue;
                }
                else {
                    if(!ban[i].equals(user[i])) {
                        return false;
                    }
                    else {
                        continue;
                    }
                }
            }
        }

        return true;
    }
}
