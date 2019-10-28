package Searching;

import java.util.*;
    class moEgosa_Prg {



        public int[] solution(int[] answers) {

            int[] answer = {};



            int p1[] = {1,2,3,4,5};

            int p2[] = {2,1,2,3,2,4,2,5};

            int p3[] = {3,3,1,1,2,2,4,4,5,5};





            int[] count = new int[3];

            for(int i=0;i<answers.length;i++) {

                if(p1[i%5] == answers[i]) {

                    count[0] += 1;

                }

                if(p2[i%8] == answers[i]) {

                    count[1] += 1;

                }

                if(p3[i%10] == answers[i]) {

                    count[2] += 1;

                }



            }



            int maxValue = count[0];

            for(int i=1;i<3;i++) {

                if(count[i] > maxValue) {

                    maxValue = count[i];

                }

            }



            List<Integer> list = new ArrayList<Integer>();

            for(int i=0;i<3;i++) {

                if(maxValue == count[i]) {

                    list.add(i);

                }

            }



            answer = new int[list.size()];

            for(int i=0;i<list.size();i++) {

                answer[i] = list.get(i) + 1;

            }



            return answer;

        }

    }
