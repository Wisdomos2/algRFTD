package temp;

public class Line2019no1 {
    public static void main(String[] args) {

        int msg[] = {4,3,5,2,8};
        int consumer = 2;
        int result = solution(msg, consumer);
        System.out.println(result);
    }

    public static int solution(int msg[], int consumer) {

        int count = 0;
        int cs[] = new int[consumer];

        int msgindex = 0;


        while(msgindex <= msg.length) {
            if(msgindex == msg.length) {
                int max = Integer.MIN_VALUE;
                for(int i=0;i<cs.length;i++) {
                    max = Math.max(max, cs[i]);
                }
                count += max;
                return count;
            }


            for(int i=0;i<cs.length;i++) {
                if(cs[i] == 0 ) {
                    cs[i] = msg[msgindex];
                    cs[i]--;
                    msgindex++;
                }
                else {
                    cs[i]--;
                }
            }
            count++;

            System.out.println(count + " 초 경과" );
            for(int i=0;i<cs.length;i++) {
                System.out.printf(cs[i] + " ");
            }
            System.out.println();
        }




        return count;
    }
}
