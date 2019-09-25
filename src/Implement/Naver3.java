package Implement;

public class Naver3 {
    public static void main(String[] args) {
        int cook_timesp[] = {5, 30, 15, 30, 35, 20, 4, 50, 40};
        int order[][] = {{2,4},{2,5},{3,4},{3,5},{1,6},{4,6},{5,6},{6,7},{8,9}};
        int k =  9;
        int ouput[] = solution(cook_timesp,order,k);
        for(int i : ouput) {
            System.out.println(i);
        }
    }

    public static int[] solution(int[] cook_times, int[][] order, int k) {
        int[] answer = new int[2];

        int data[][] = new int [cook_times.length+1][3];
        for(int i=1;i<=cook_times.length;i++) {
            data[i][0] = i;
            data[i][1] = cook_times[i-1];
        }

        for(int i=0;i<order.length;i++) {
            for(int j=0;j<2;j++) {
                int b = order[i][1];
                int a = order[i][0];
                if(data[b][2] <= a) {
                    data[b][2] = a;
                }
            }
        }

        int beforeStep = k-1;
        int beforeSteplevel = data[k-1][2];

        int output1 = 0;
        int output2 = 0;
        for(int i=0;i<data[k][2];i++) {
            int checkstep = 0;
            for(int j=1;j<=k;j++) {
                if(data[j][2] == i) {
                    checkstep = Math.max(data[j][1],checkstep);
                }
            }
            output2 += checkstep;
        }


        for(int i=1;i<=k;i++) {
            if(beforeSteplevel == 0) {
                output1 = 1;
                break;
            }
            else if(i <= beforeStep && data[i][2] <= beforeSteplevel ) {
                output1++;
            }
        }




        answer[0] = output1;
        answer[1] = output2;




        return answer;
    }
}
