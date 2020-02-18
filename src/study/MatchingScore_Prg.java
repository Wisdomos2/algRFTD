package study;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class MatchingScore_Prg {
    public static void main(String[] args) {
        String word = "Muzi";
        String pages[] = {"<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://careers.kakao.com/interview/list\"/>\n</head>  \n<body>\n<a href=\"https://programmers.co.kr/learn/courses/4673\"></a>#!MuziMuzi!)jayg07con&&\n\n</body>\n</html>", "<html lang=\"ko\" xml:lang=\"ko\" xmlns=\"http://www.w3.org/1999/xhtml\">\n<head>\n  <meta charset=\"utf-8\">\n  <meta property=\"og:url\" content=\"https://www.kakaocorp.com\"/>\n</head>  \n<body>\ncon%\tmuzI92apeach&2<a href=\"https://hashcode.co.kr/tos\"></a>\n\n\t^\n</body>\n</html>"};
        System.out.println(solution(word, pages));
        return;
    }

    static Map<String, Integer> pageMap = new HashMap<>();
    static ArrayList<Node> pageInfo = new ArrayList<>();
    public static int solution(String word, String[] pages) {
        int answer = 0;
        word = word.toLowerCase();

        for(int i=0;i<pages.length;i++) {
            String page = pages[i].toLowerCase();


            int searchLeft = page.indexOf("<meta") + 1;
            int searchRight = page.indexOf(">", searchLeft);
            int searchhttp = page.lastIndexOf("https://", searchRight);
            while(true) {
                if(searchhttp != -1) {
                    break;
                }
                searchLeft = page.indexOf("<meta",searchLeft+1);
                searchRight = page.indexOf(">", searchLeft);
                searchhttp = page.lastIndexOf("https://", searchRight);
            }

            int searchhttpEnd = page.lastIndexOf("/",searchRight);

            //set Url
            String url = page.substring(searchhttp,searchhttpEnd-1);

            //get basic score
            int getBasicScore = 0;
            //int searchWord = 0;

            while(true) {
                searchLeft = page.indexOf(word,searchLeft+1);
                if(searchLeft < 0) {
                    break;
                }
                else {
                    if(!Character.isLetter(page.charAt(searchLeft-1)) && !Character.isLetter(page.charAt(searchLeft+word.length()))) {
                        getBasicScore++;
                        searchLeft = searchLeft + word.length();
                    }
                }
            }

            int getLinks = 0;

            while(true) {
                searchLeft = page.indexOf("<a href",searchLeft+1);
                searchRight = page.indexOf("/", searchLeft);
                searchhttp = page.lastIndexOf("https://", searchRight);
                if(searchhttp < 0) {
                    break;
                }
                else {
                    getLinks++;
                }
            }

            pageMap.put(url,i);
            pageInfo.add(new Node(i,getBasicScore, getLinks, (double)getBasicScore));

        }

        for(int i=0;i< pages.length;i++) {
            String page = pages[i].toLowerCase();
            int searchLeft = 0;
            int searchRight = 0;

            /*
                원래 위와 같이해도 정상 작동함.
                디버깅 포인트를 잘못잡아서 바꾸게되었음.
            */
            while(true) {
                searchLeft = page.indexOf("<a href", searchRight);
                if(searchLeft < 0) {
                    break;
                }
                searchLeft = page.indexOf("https://",searchLeft);
                searchRight = page.indexOf("\"",searchLeft);

                String connectUrl = page.substring(searchLeft,searchRight);

                Integer connectWebIndex = pageMap.get(connectUrl);
                if(connectWebIndex != null) {
                    pageInfo.get(connectWebIndex).matchingScore += (double)pageInfo.get(i).basicScore / (double)pageInfo.get(i).outerLinks;
                }

            }
        }

        //sort
        pageInfo.sort(new compareNodes());

        return pageInfo.get(0).indexOfPage;
    }

    public static class compareNodes implements Comparator<Node> {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.matchingScore == o2.matchingScore) {
                return o1.indexOfPage - o2.indexOfPage;
            }
            else if(o1.matchingScore < o2.matchingScore) {
                return 1;
            }
            else {
                return -1;
            }
        }
    }

    public static class Node {
        int indexOfPage;
        int basicScore;
        int outerLinks;
        double matchingScore;

        public Node(int indexOfPage, int basicScore, int outerLinks, double matchingScore) {
            this.indexOfPage = indexOfPage;
            this.basicScore = basicScore;
            this.outerLinks = outerLinks;
            this.matchingScore = matchingScore;
        }
    }


}
