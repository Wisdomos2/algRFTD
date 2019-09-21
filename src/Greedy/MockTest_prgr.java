package Greedy;

public class MockTest_prgr {
    public static void main(String[] args) {
        int arr[] = {1,3,2,4,2};

        int result[] = solution(arr);

        for(int i : result) {
            System.out.println(i);
        }

        return;


    }

    public static int[] solution(int[] answers) {
        int[] answer = {};

        int count[][] = {{1,2,3},{0,0,0}};
        for(int i=0;i<answers.length;i++) {
            count[1][0] = count[1][0] + nextSelect(1, answers[i],i);
            count[1][1] = count[1][1] + nextSelect(2, answers[i],i);
            count[1][2] = count[1][2] + nextSelect(3, answers[i],i);
        }

       /*
       아오 슈바 그냥 정렬은 map 에 담궈서 오름차순 Sort하자 역겹네
        */




        return answer;
    }

    public static int nextSelect(int person, int nowValue, int index) {
        int first[] = {1,2,3,4,5};
        int second[] = {2,1,2,3,2,4,2,5};
        int third[] = {3,3,1,1,2,2,4,4,5,5};

        if(person == 1) {
            index = index%first.length;
            if(nowValue == first[index]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(person == 2) {
            index = index%second.length;
            if(nowValue == second[index]) {
                return 1;
            }
            else {
                return 0;
            }
        }
        else if(person == 3) {
            index = index%third.length;
            if(nowValue == third[index]) {
                return 1;
            }
            else {
                return 0;
            }
        }

        return 0;


    }
}
