package CallBusLap;

import java.util.ArrayList;

public class No4_StraightLine {
    /*
        세 개 이상의 점이 한 직선에 있을까?
     */

    public static void main(String[] args) {
        System.out.println("기본 테스트 예제");
        ArrayList<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(0, 0));
        nodes1.add(new Node(1, 1));
        nodes1.add(new Node(2, 2));

        System.out.println("한 직선위에 점들이 있는지? (0,0) (1,1) (2,2) : " + isStraightLine(nodes1));

        ArrayList<Node> nodes2 = new ArrayList<>();
        nodes2.add(new Node(0, 0));
        nodes2.add(new Node(1, 2));
        nodes2.add(new Node(2, 2));
        System.out.println("한 직선위에 점들이 있는지? (0,0) (1,2), (2,2): " + isStraightLine(nodes2));

        System.out.println("--------------------------------------------------");
        System.out.println("***TEST CASE***");
        test();

        return;


    }

    /* 각 점들이 서로 직선 위에 있는지 확인 -> 모든 점들이 연쇄적으로 같은 직선방정식을 가져야한다고 생각. */
    private static boolean isStraightLine(ArrayList<Node> list) {

        boolean sameXFlag = false;
        int sameXValue = 0;

        for (int baseI = 0; baseI < list.size() - 1; baseI++) {

            for (int i = baseI+1; i < list.size(); i++) {
                if (i == baseI+1) {
                    Node beforeNode = list.get(baseI);
                    Node nowIndexINode = list.get(i);

                    /* index1, index2의 X좌표가 같다면 쭉 같은 X이어야 한다. */
                    if (beforeNode.X == nowIndexINode.X) {
                        sameXFlag = true;
                        sameXValue = beforeNode.X;
                    } else {
                        sameXValue = (((nowIndexINode.Y - beforeNode.Y) / (nowIndexINode.X - beforeNode.X)) * (1 - beforeNode.X)) + beforeNode.Y;
                    }
                } else {
                    if (sameXFlag) {
                        Node nowIndexINode = list.get(i);
                        if (nowIndexINode.X == sameXValue) {
                            continue;
                        } else {
                            return false;
                        }
                    } else {
                        Node beforeNode = list.get(baseI);
                        Node nowIndexINode = list.get(i);

                        int compareToSameXValue = (((nowIndexINode.Y - beforeNode.Y) / (nowIndexINode.X - beforeNode.X)) * (1 - beforeNode.X)) + beforeNode.Y;
                        if (compareToSameXValue == sameXValue) {
                            continue;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }




        /* 각 점들이 서로 직선 위에 있다면 */
        return true;

    }

    private static void test() {
        System.out.println("--------------------------------------------------");
        ArrayList<Node> nodes1 = new ArrayList<>();
        nodes1.add(new Node(3, 0));
        nodes1.add(new Node(1, 0));
        nodes1.add(new Node(2, 0));

        System.out.println("X가 같을 경우 한 직선위에 점들이 있는지? (3,0) (1,0) (2,0) : " + isStraightLine(nodes1));
        System.out.println("--------------------------------------------------");

        ArrayList<Node> nodes2 = new ArrayList<>();
        nodes2.add(new Node(0, 0));
        nodes2.add(new Node(1, 1));
        nodes2.add(new Node(2, 2));
        nodes2.add(new Node(2, 2));

        System.out.println("점이 4개인 경우 한 직선위에 점들이 있는지? (0,0) (1,1) (2,2) (3,3) : " + isStraightLine(nodes1));
        System.out.println("--------------------------------------------------");


    }


    private static class Node {
        int X;
        int Y;

        public Node(int x, int y) {
            X = x;
            Y = y;
        }
    }
}
