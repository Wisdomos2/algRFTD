package String;

public class Phonelist_Prg {
    public static void main(String[] args) {

        String input[] = {"119", "97674223", "1195524421"};
        String input2[] = {"123","456","789"};

        System.out.println(solution(input));
        System.out.println(solution(input2));

    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        for(int i=0;i<phone_book.length-1;i++) {
            String base = phone_book[i];
            for(int j=i+1;j<phone_book.length;j++) {
                if(phone_book[j].startsWith(phone_book[i])) {
                    answer = false;
                    return answer;
                }
                if(phone_book[i].startsWith(phone_book[j])) {
                    answer = false;
                    return answer;
                }

            }
        }

        return answer;
    }
}
