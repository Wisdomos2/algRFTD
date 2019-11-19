package study;

public class SeachingLyrics_Prg {
    public static void main(String[] args) {
        String input1[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String input2[] = {"fro??", "????o", "fr???", "fro???", "pro?"};

        for(int i : solution(input1,input2)) {
            System.out.printf(i + " ");
        }

    }

    /*
    #process
    1. 각 Query당 모든 Word에 대하여 검사하는 방식으로 진행.
    O(n^2)?
    - > 문제는 다 통과함. 근데 시간초과 뜸.
    -> 트라이 자료구조를 사용해야함.
    -> 왜 ? O(logN) 으로 빠른 문자열 검색가능.
       사전, 인터넷 자동완성에 주로 쓰임.
    -> 특징 ? 정보를 마지막 노드만 가지고있음. 나머지 노드는 링크만 가짐.



    #condition
    1. 길이가 같아야한다.
    2. ?를 제외한 나머지가 같아야한다.
    X3. 위 조건을 만족할 시에 answer의 index에 해당되는 값을 증가시킨다.
    다 필요없고 트라이 자료구조쓰면된다. 이게 내 결론이다~

    ->1. 트라이는 "접두사 트리"이다. 즉 ???가 앞에 붙을 수도 있으므로
         word를 뒤집어서 넣고, query도 뒤집어서 확인해줄 필요가 있다.

     */
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        //root , 비어있는 상태로 생성.
        Trie trie = new Trie();

        // '?'가 접두로 붙은 경우 reverse해서 검색하기 위함.
        Trie trie_reverse = new Trie();

        //trie 객체에 word 집어넣음.
        for(int i=0;i<words.length;i++) {
            trie.insert(words[i]);
        }

        // reverse
        for(int i=0;i<queries.length;i++) {
            StringBuffer sb = new StringBuffer(words[i]);
            trie_reverse.insert(sb.reverse().toString());
        }

        // 검색
        for(int i=0;i<queries.length;i++) {
            //접두가 ? 이면 reverse trie 에서 검색.
            if(queries[i].charAt(0) == '?') {
                if(trie_reverse.searching(queries[i],queries[i].length())) {
                    answer[i] = answer[i] + 1;
                }
            }
            else {
                if(trie.searching(queries[i],queries[i].length())) {
                    answer[i] = answer[i] + 1;
                }
            }
        }

        return answer;
    }

    // Node class
    public static class Node {
        String character;
        //int size;
        Node alpha[];
        boolean leaf;

        //root node 에서 최초생성자 (최초 root는 아무 것도 없음.)
        //next node 는 소문자 크기만큼 노드의 크기를 가짐.
        public Node(String character) {
            this.character = character;
            this.alpha = new Node[26];
        }

        public void setAlpha(int index, Node node) {
            //node.size = size;
            this.alpha[index] = node;
        }

    }

    // Trie class
    // create empty Node when it is init created.
    // root - > init empty node
    // leaf - > last node(have data info)
    public static class Trie {
        Node root;

        // 최초 비어있는 상태로 시작.
        public Trie() {
            this.root = new Node("");
        }

        //This is method Word insert into Trie.
        public void insert(String word) {
            Node tempNode = root;
            for(int i=0;i<word.length();i++) {
                char c = word.charAt(i);
                int asciicode = c - 'a';
                // 해당 아스키값에 대한 index에 값이 없으면.
                if(tempNode.alpha[asciicode] == null) {
                    //새로운 노드 생성
                    Node node = new Node(String.valueOf(c));

                    tempNode.setAlpha(asciicode,node);
                    tempNode = node;
                }
                else {
                    //하위 노드로 이동
                    tempNode = tempNode.alpha[asciicode];
                }
            }

            tempNode.leaf = true;
        }

        //This is method Word is searched.
        public boolean searching(String word, int size) {
            Node trieNode = root;

            int count = 0;

            for(int i=0;i<word.length();i++) {
                if(word.charAt(i) == '?') {
                    count++;
                }
                else {
                    int asciincode = word.charAt(i) - 'a';
                    //추출한 asccicode에 대한 index에 값이 있는지 확인.
                    //없으면 해당 문자 없는거임(안맞는거임)
                    if(trieNode.alpha[asciincode] == null) {
                        break;
                    }
                    else {
                        //있으면 다음 하위노드로 이동
                        trieNode = trieNode.alpha[asciincode];
                        count++;
                    }
                }
            }

            if(count == size) {
                return true;
            }
            return false;
        }
    }

    /*------------------------------------------------------------------*/
    public static int[] before_solution(String[] words, String[] queries) {
        /*
         O(n^3)의 아주 비효울적은 검색 -> 답은 다 맞음.
         */
        int[] answer = new int[queries.length];


        for(int i=0;i<queries.length;i++) {
            String query[] = queries[i].split("");
            for(int j=0;j<words.length;j++) {
                String word[] = words[j].split("");

                if(query.length != word.length) {
                    continue;
                }
                else {

                }
                if(compare(query,word)) {
                    answer[i] = answer[i] + 1;
                }

            }
        }
        return answer;
    }


    public static boolean compare(String query[], String word[]) {

        //condition 1.
        if(query.length != word.length) {
            return false;
        }
        else {
            for(int i=0;i<query.length;i++) {
                // ? 이면 통과.
                if(query[i].equals("?")) {
                    continue;
                }
                // 같은지 확인.
                else if(!query[i].equals(word[i])){
                    return false;
                }
            }
        }
        return true;
    }
}
