package study;

import java.util.HashMap;
import java.util.Map;

public class Trie_Lyric_Prg {
    static Map<String, Integer> map = new HashMap<>();
    public static void main(String[] args) {
        String input1[] = {"frodo", "front", "frost", "frozen", "frame", "kakao"};
        String input2[] = {"fro??", "????o", "fr???", "fro???", "pro?"};


        for(int i : solution(input1,input2)) {
            System.out.printf(i + " ");
        }

        String input12[] = {"frozen"};
        String nput22[] = {"??oz??"};
        for(int i : solution(input12,nput22)) {
            System.out.printf(i + " ");
        }
    }
    /*
    * 중요! Trie 자료구조에는 데이터가 저장되는게 아니고 자식 Node가 저장된다.
    * Trie는 leaf변수로 해당 노드가 마지막인지 확인하는 방법을 사용하지만
    * 이번에는 문자열 길이로 마지막인지 체크함.
    * */


    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        //?가 접미
        Trie basicTrie = new Trie();
        //?가 접두, 시작부터 ? 이면, 빈사되어서 못찾음,,
        Trie rvsTrie  = new Trie();

        for(int i=0;i<words.length;i++) {
            basicTrie.add(words[i]);
        }

        for(int i=0;i<words.length;i++) {
            rvsTrie.rvsadd(words[i]);
        }

        for(int i=0;i<queries.length;i++) {
            if(!map.containsKey(queries[i])) {
                if(queries[i].charAt(0) == '?') {
                    answer[i] = rvsTrie.rvsTrieCount(queries[i]);
                }
                else {
                    answer[i] = basicTrie.TrieCount(queries[i]);
                }
                map.put(queries[i],answer[i]);
            }
            else {
                answer[i] = map.get(queries[i]);
            }
        }


        return answer;
    }

    public static class Trie {
        Node root;

        public Trie() {
            root = new Node();
        }

        // 접미 count
        public int TrieCount(String str) {
            return root.Triecount(str,0);
        }

        // 접두 count, 뒤에 글자부터 검사함.
        public int rvsTrieCount(String str) {
            return root.rvsTrieCount(str, str.length()-1);
        }

        // 정방향대로 문자 추가.
        public void add(String str) {
            root.insert(str, 0);
        }

        // 문자열 끝에서부터 문자 추가.
        public void rvsadd(String str) {
            root.rvsinsert(str,str.length()-1);
        }

    }

    /**
     * @param data : 해당 노드에 입력될 '문자'
     * @param nodes[] : 해당 노드가 가지고 있는 링크배열
     * @param word : 검색하고자 했던 word 데이터. -> 마지막 노드가 갖고있다.
     * @see Triecount : Trie에 해당 Query를 검색하여 숫자만큼 return.
     * @see insert : Trie에 해당 String(word)를 추가.
     * @return
     */
    public static class Node {
        Node nodes[];
        String word;
        // boolean leaf : 마지막 표시

        // ascii 코드를 index로 지정[알파벳개수만큼]하여 링크로 사용.
        public Node() {
            nodes = new Node[26];
        }

        // searching word in query
        public int Triecount(String str, int index) {
            int count = 0;
            if(index == str.length()) {
                if(word != null) {
                    count = 1;
                }
            }
            else {
                // 해당 문자의 ascii code get.
                int data = str.charAt(index) - 'a';
                // 해당 문자가 ? 가 아니고.
                if(str.charAt(index) != '?') {
                    // 다음 링크가 있다면 다음 글자로 이동, 재귀로 리턴 받는다.
                    if(nodes[data] != null) {
                        count = nodes[data].Triecount(str, index+1);
                    }
                }
                // 해당 문자가 ? 이라면
                // ? 와 연결된 문자들을 모두 탐색하여 그 노드로 이동한다.
                else {
                    for(int i=0;i<26;i++) {
                        if(nodes[i] != null) {
                            count = count + nodes[i].Triecount(str,index+1);
                        }
                    }
                }
            }
            return count;
        }

        // word insert into trie
        public void insert(String str, int index) {
            //마지막 문자까지 왔으면 == 마지막 노드까지 왔으면.
            // word에 최종문자를 저장한다 -> 마지막 노드만 최종문자를 가짐.
            if(index == str.length()) {
                this.word = str;
            }
            else {
                int data = str.charAt(index) - 'a';
                // 다음 노드링크가 없으면 만들어주고.
                if(nodes[data] == null) {
                    nodes[data] = new Node();
                }
                // 있으면 다음 노드로 이동.
                nodes[data].insert(str, index+1);

            }
        }

        public int rvsTrieCount(String str, int index) {
            int count = 0;
            if(index == -1) {
                if(word != null) {
                    count = 1;
                }
            }
            else {
                int data = str.charAt(index) - 'a';
                if(str.charAt(index) != '?') {
                    if(nodes[data] != null) {
                        count = nodes[data].rvsTrieCount(str, index-1);
                    }
                }
                else {
                    for(int i=0;i<26;i++) {
                        if(nodes[i] != null) {
                            count = count + nodes[i].rvsTrieCount(str, index-1);
                        }
                    }
                }
            }

            return count;
        }

        public void rvsinsert(String str, int index) {
            if(index == -1) {
                this.word = str;
            }
            else {
                int data = str.charAt(index) - 'a';
                if(nodes[data] == null) {
                    nodes[data] = new Node();
                }
                nodes[data].rvsinsert(str, index-1);
            }

        }
    }

}
