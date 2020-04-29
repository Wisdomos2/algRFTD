package temp;

public class DevCamp2 {
    public static void main(String[] args) {
        int office[][] = {{5,-1,4},{6,3,-1},{2,-1,1}};
        int r = 1;
        int c = 0;
        String move[] = {"go","go","right","go","right","go","left","go"};

        System.out.println(solution(office,r,c,move));
    }

    static int[] DIRY = {-1, 0, 1, 0};
    static int[] DIRX = {0, 1, 0, -1};
    static int answer = 0;
    static int current_direction = 0;
    static int[] current_location = {0,0};

    public static int solution(int[][] office, int r, int c, String[] move) {
        int n = office.length - 1;
        current_location[0] = r;
        current_location[1] = c;

        clear(office);

        for(int i=0;i<move.length;i++){
            if(move[i].equals("go")){
                go(n,office);
            }else{
                rotate(move[i]);
            }
        }

        return answer;
    }

    public static void go(int n,int[][] office){
        int ny = current_location[0] + DIRY[current_direction];
        int nx = current_location[1] + DIRX[current_direction];

        if( 0<=ny && ny<= n && 0<=nx && nx<= n && office[ny][nx] != -1){
            current_location[0] += DIRY[current_direction];
            current_location[1] += DIRX[current_direction];
            clear(office);
        }
    }

    public static void rotate(String direction){
        if(direction.equals("right")){
            current_direction = (current_direction + 1) % 3;
        }else{
            if (current_direction == 0) {
                current_direction = 3;
            }else{
                current_direction -=1;
            }
        }
    }

    public static void clear(int[][] office){
        answer+= office[current_location[0]][current_location[1]];
        office[current_location[0]][current_location[1]] = 0;
    }
}
