package study;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.function.Function;

public class Ship {
    private Hashtable<Integer, List<Integer>> containers;

    public Ship(int containerCount, Function<Integer, List> fillContainer) {
        this.containers = new Hashtable<Integer, List<Integer>>();

        for (int i = 0; i < containerCount; i=i+10) {
            List<Integer> list = new ArrayList<>();
            for(int j=i;j<j+10;j++) {
                list.add(j);
            }
            this.containers.put(i, fillContainer.apply(list));
        }
    }

    public List<Integer> peekContainer(int containerIndex) {
        return this.containers.get(containerIndex);
    }

    public static void main(String[] args) {
        Ship ship = new Ship(10, ArrayList::new);

        for (int i = 0; i < 10; i++) {
            System.out.println("Container: " + i + ", cargo: " + ship.peekContainer(i));
        }
    }
}