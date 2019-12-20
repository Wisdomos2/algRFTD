package study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class FindPathGame_Prg_BTS {
    public static void main(String[] args) {
        int input[][] = {{5,3},{11,5},{13,3},{3,5},{6,1},{1,3},{8,6},{7,2},{2,2}};
        int result[][] = solution(input);

        int compare[][] = {{7,4,6,9,1,8,5,2,3},{9,6,5,8,1,4,3,2,7}};

        for(int i=0;i<2;i++) {
            for(int j=0;j<compare[0].length;j++) {
                if(compare[i][j] != result[i][j]) {
                    System.out.println("false");
                    return;
                }
                System.out.printf(result[i][j] + " ");
            }
            System.out.println();
        }
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
        int[][] answer = null;

        ArrayList<Node> list = new ArrayList<>();

        //init
        for(int i=0;i<nodeinfo.length;i++) {
            list.add(new Node(i+1,nodeinfo[i][0],nodeinfo[i][1]));
        }

        // y좌표 순으로 정렬 y가 같으면 x순으로 정렬.
        Comparator<Node> nodeComparator = new Comparator<Node>() {
            @Override
            public int compare(Node o1, Node o2) {
                if(o1.col == o2.col) {
                    return o1.row - o2.row;
                }
                else {
                    return o2.col - o1.col;
                }
            }
        };
        Collections.sort(list, nodeComparator);

        for(int i=0;i<list.size();i++) {
            System.out.println(list.get(i).col + " " + list.get(i).row + " " + list.get(i).value);
        }
        System.out.println();


        Node root  = list.get(0);
        for(int i=1;i<list.size();i++) {
            addNode(list.get(i), root);
        }
        answer = new int[2][nodeinfo.length];
        preorder(answer, root);
        index = 0;
        postorder(answer, root);

        return answer;
    }

    static int index = 0;
    private static void preorder(int[][] answer, Node node) {
        if(node == null) {
            return;
        }
        else {
            answer[0][index++] = node.value;
            preorder(answer, node.leftnode);
            preorder(answer, node.rightnode);
        }
    }

    private static void postorder(int[][] answer, Node node) {
        if(node == null) {
            return;
        }
        else {
            postorder(answer, node.leftnode);
            postorder(answer, node.rightnode);
            answer[1][index++] = node.value;
        }
    }


    public static void addNode(Node inputNode, Node root) {
        if(inputNode.row < root.row) {
            if(root.leftnode == null) {
                root.leftnode = inputNode;
            }
            else {
                addNode(inputNode, root.leftnode);
            }
        }
        else {
            if(root.rightnode == null) {
                root.rightnode = inputNode;
            }
            else {
                addNode(inputNode, root.rightnode);
            }
        }
    }

    public static class Node {
        int value;
        int row;
        int col;
        Node leftnode;
        Node rightnode;

        public Node(int value, int x, int y) {
            this.value = value;
            this.col = y;
            this.row = x;
        }

    }

}
