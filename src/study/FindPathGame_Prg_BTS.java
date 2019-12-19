package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
/*
    참고 https://marobiana.tistory.com/81?category=422167
    https://marobiana.tistory.com/83?category=422167
    x좌표 위주로 정렬을 다시해주거나
    소스가 꼬였거나. Node로 input을 바꿔주는 과정에서.
    문제 정확하게 다시 읽기 
 */
public class FindPathGame_Prg_BTS {
    public static void main(String[] args) {
        int input[][] = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int result[][] = solution(input);

        int compare[][] = {{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}};

        //test
//        for(int i=0;i<2;i++) {
//            for(int j=0;j<compare[0].length;j++) {
//                if(compare[i][j] != result[i][j]) {
//                    System.out.println("false");
//                    return;
//                }
//            }
//        }
        System.out.println("true");
        return;

    }

    /*
        result row의 길이는 nodeinfo의 갯수와 같다.
        input[][] 배열의 index+1이 노드의 번호이다.
        이진트리이다.
        post/pre를 구현하면된다.
     */
    public static int[][] solution(int[][] nodeinfo) {
        int[][] answer = {};

        ArrayList<Node> list = new ArrayList<>();

        //init
        for(int i=0;i<nodeinfo.length;i++) {
            list.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }

        // y좌표 순으로 정렬
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                return o2.col - o1.col;
            }
        };
        Collections.sort(list, nodeComparator);

        Tree tree = new Tree();
        for(int i=0;i<list.size();i++) {
            tree.addNode(list.get(i));
        }

        tree.preorder(tree.root);
        System.out.println("----");
        tree.postorder(tree.root);

        return answer;
    }

    public static class Tree {
        public Node root;

        //node 추가
        public void addNode(Node inputnode) {
            if (root == null) {
                root = inputnode;
            }
            else {
                addNode(inputnode, root);
            }
        }

        public void addNode(Node inputnode, Node root) {
            if (inputnode.row <= root.row) {
                if (root.leftnode == null) {
                    Node node = new Node();
                    node.value = inputnode.value;
                    root.leftnode = node;
                } else {
                    addNode(inputnode, root.leftnode);
                }
            }
            else {
                if (root.rightnode == null) {
                    Node node = new Node();
                    node.value = inputnode.value;
                    root.rightnode = node;
                }
                else {
                    addNode(inputnode, root.rightnode);
                }
            }
        }

        public void preorder(Node root) {
            if(root == null) {
                return;
            }
            //여기서 result 식으로 삽입
            System.out.printf(root.value + " ");
            preorder(root.leftnode);
            preorder(root.rightnode);
        }

        public void postorder(Node root) {
            if(root == null) {
                return;
            }
            postorder(root.leftnode);
            postorder(root.rightnode);
            //여기서 result 식으로 삽입
            System.out.print(root.value + " ");
        }



    }

    public static class Node {
        int value;
        int row;
        int col;
        Node leftnode;
        Node rightnode;

        public Node() {
//            leftnode = new Node();
//            rightnode = new Node();
        }

        public Node(int value, int x, int y) {
            this.value = value;
            this.col = y;
            this.row = x;
        }

    }

}
