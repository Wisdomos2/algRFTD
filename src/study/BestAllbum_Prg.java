package study;

import java.util.*;

/**
 * Hash / https://programmers.co.kr/learn/courses/30/lessons/42579?language=java
 *
 */
public class BestAllbum_Prg {
    public static void main(String[] args) {

        String genres[] = {"classic", "pop", "classic", "classic", "pop"};
        int plays[] = {500, 600, 150, 800, 2500};

        int result[] = solution(genres,plays);
        for(int i : result) {
            System.out.printf(i + " ");
        }

    }

    /*
        0. 가장 많이 재생된 노래를 '2개'씩 모음.
        1. 가장 많이 재생된 '장르'
        2. '장르'내에서 가장 많이 재생된'노래'
        3. '재상횟수'가 같으면 고유번호가 낮은 노래
     */
    public static int[] solution(String[] genres, int[] plays) {
        int[] answer = {};

        Map<String, Integer> genrelist = new HashMap<>();
        Map<String,HashMap<Integer,Integer>> songlist = new HashMap<>();


        // data init.
        for(int i=0;i<genres.length;i++) {
            //해당 장르 최초 삽입 시.
            if(!genrelist.containsKey(genres[i])) {
                genrelist.put(genres[i],plays[i]);
                /*
                    해당 노래에 대한 정보 삽입.
                    1. 고유번호
                    2. 플레이 횟수
                 */
                HashMap<Integer, Integer> inputMap = new HashMap<>();
                inputMap.put(i,plays[i]);
                songlist.put(genres[i],inputMap);
            }
            //해당 장르 있으면 카운트 증가하고 노래 정보 삽입.
            else {
                genrelist.replace(genres[i],genrelist.get(genres[i])+plays[i]);
                HashMap tempMap = songlist.get(genres[i]);
                tempMap.put(i,plays[i]);
                songlist.put(genres[i],tempMap);
            }
        }

        // genrelist 정렬. (가장 많이 재생 장르 찾기위해서 내림차순)
        /*
         * Map 을 Collections 으로 정렬하면,
         * 비교 연산된 후 순서에따라 List에 해당 Key만 저장함!!! map자체가 바뀌는게 아님.
         */
        List<String> keySetList = new ArrayList<>(genrelist.keySet());
        Collections.sort(keySetList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return genrelist.get(o2).compareTo(genrelist.get(o1));
            }
        });

        List<Integer> result = new ArrayList<>();
        List<Integer> songkeySetList;
        // 각 키에 대해 정렬 [index,cycle], cycle 기준
        for(String key : keySetList) {
            songkeySetList = new ArrayList<>(songlist.get(key).keySet());
            Collections.sort(songkeySetList, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return songlist.get(key).get(o2).compareTo(songlist.get(key).get(o1));
                }
            });
            /*
            for(Integer key2 : songkeySetList) {
                System.out.println("정렬확인 ");
                System.out.println(String.format("Key : %s, Value : %s", key2, songlist.get(key).get(key2)));
            }
            System.out.println("-------------");
            */

            if(songlist.get(key).size() > 1) {
                result.add(songkeySetList.get(0));
                result.add(songkeySetList.get(1));
            }
            else {
                result.add(songkeySetList.get(0));
            }

        }

        answer = new int[result.size()];
        for(int i=0;i<result.size();i++) {
            answer[i] = result.get(i);
        }

       /* for(String key : keySetList) {
            System.out.println(String.format("Key : %s, Value : %s", key, genrelist.get(key)));
        }*/




        return answer;
    }
}
