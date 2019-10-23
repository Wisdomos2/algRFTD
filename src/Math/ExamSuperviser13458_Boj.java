package Math;

import java.util.Scanner;

/*
총감독 1명씩, 그리고 그걸 뺴놓음.
부감독관이 감당할 수있는 인원으로 나눔.
주의 : 사람이므로 나누었을때 소수점이 나온다? +1 해야함으로
계산전에 %연산자 이용해서 0인지 아닌지 판별 0아니면( 몫 + 1해줌.)
0으로 나누어 떨어지면 그 인원이 최소 인원임
 */
public class ExamSuperviser13458_Boj {
    static int data[] = null;
    static int first = 0;
    static int second = 0;
    static long cnt = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        data = new int[N];

        for(int i=0;i<N;i++) {
            data[i] = sc.nextInt();
        }

        first = sc.nextInt();
        second = sc.nextInt();
        sc.close();


        for(int i=0;i<N;i++) {
            data[i] = data[i] - first;
            cnt++;

            if(data[i] >= 0) {
                if(data[i]%second > 0) {
                    cnt = cnt + (data[i]/second + 1);
                }
                else if(data[i]%second == 0) {
                    cnt = cnt + (data[i]/second);
                }
            }
        }

        System.out.println(cnt);

    }
}
