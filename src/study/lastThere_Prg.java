package study;
/*
    https://programmers.co.kr/learn/courses/30/lessons/17683
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class lastThere_Prg {
    public static void main(String[] args) {
        String m1 = "ABCDEFG";
        String musicInfo1[] ={"12:00,12:14,HELLO,CDEFGAB","13:00,13:05,WORLD,ABCDEF"};

        String m2 = "CC#BCC#BCC#BCC#B";
        String musicInfo2[] = {"03:00,03:30,FOO,CC#B","04:00,04:08,BAR,CC#BCC#BCC#B"};

        String m3 = "ABC";
        String musicInfo3[] = {"12:00,12:14,HELLO,C#DEFGAB","13:00,13:05,WORLD,ABCDEF"};
        System.out.println(solution(m1, musicInfo1));
        System.out.println(solution(m2, musicInfo2));
        System.out.println(solution(m3, musicInfo3));
    }

    // 1분 = / 60000 해야함.
    public static String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        long playTime = 0;
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        for(int i=0;i<musicinfos.length;i++) {
            String spilitMusicInfo[] = musicinfos[i].split(",");

            long startTime = 0;
            long endTime = 0;
            try {
                startTime = dateFormat.parse(spilitMusicInfo[0]).getTime();
                endTime = dateFormat.parse(spilitMusicInfo[1]).getTime();
                long listenTime = (endTime - startTime)/60000;

                String playMusiclevel = spilitMusicInfo[3];

                if(playMusiclevel.length() < listenTime) {
                    // 재생 시간이 더 길 때
                    int index = 0;

                    long addNum = listenTime - playMusiclevel.length();
                    while(true) {
                        if(addNum == 0) {
                            break;
                        }
                        else {
                            if(index == playMusiclevel.length()-1) {
                                index = 0;
                            }
                            if(index+1 < playMusiclevel.length() && playMusiclevel.charAt(index+1) == '#') {
                                playMusiclevel = playMusiclevel + playMusiclevel.substring(index,index+2);
                                index = index+2;
                                addNum--;
                            }
                            else {
                                playMusiclevel = playMusiclevel + playMusiclevel.substring(index,index+1);
                                index++;
                                addNum--;
                            }
                        }
                    }
                }
                else {
                    // 재생 시간이 더 짧을 때
                    playMusiclevel = playMusiclevel.substring(0,(int)listenTime);
                }

                for(int k=0;k<playMusiclevel.length();k++) {
                    if(k+m.length() > playMusiclevel.length()) {
                        break;
                    }
                    String checkString = null;
                    if(k+m.length()+1 <= playMusiclevel.length()) {
                        checkString = playMusiclevel.substring(k,k+m.length()+1);
                        if(checkString.charAt(checkString.length()-1) == '#') {
                            continue;
                        }
                        else {
                            checkString = checkString.substring(0,checkString.length()-1);
                        }
                    }
                    else {
                        checkString = playMusiclevel.substring(k,k+m.length());
                    }

                    if(checkString.equals(m)) {
                        if(playTime < listenTime) {
                            answer = spilitMusicInfo[2];
                            playTime = listenTime;
                        }

                    }
                }

            }
            catch (ParseException e) {
                e.printStackTrace();
                return null;
            }

        }


        return answer;
    }
}
