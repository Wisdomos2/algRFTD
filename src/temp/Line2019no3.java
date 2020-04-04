package temp;



public class Line2019no3 {
    public static void main(String[] args) {
        int k = 3;
        Node nodes[] = new Node[k];
        nodes[0] = new Node(0,11);
        nodes[1] = new Node(10,16);
        nodes[2] = new Node(15,30);

        System.out.println(solution(nodes));
        return;
    }

    public static int solution(Node nodes[]) {
        int count = 1;
        for(int i=0;i<nodes.length;i++) {
            Node baseNode = nodes[i];
            int semiCount = 1;
            for(int j=0;j<nodes.length;j++) {
                if(i==j) {
                    continue;
                }
                else {
                    Node otherNode = nodes[j];
                    if(baseNode.start > otherNode.start && baseNode.start < otherNode.end) {
                        semiCount++;
                    }
                    else if(baseNode.end > otherNode.start && baseNode.end < otherNode.end) {
                        semiCount++;
                    }
                    else {

                    }
                }
            }
            count = Math.max(semiCount,count);
        }




        return count;
    }

    public static class Node {
        public Node(int start, int end) {
            this.start = start;
            this.end = end;
        }

        int start;
        int end;
    }
}
