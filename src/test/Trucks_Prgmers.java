package test;

import java.util.LinkedList;
import java.util.Queue;

public class Trucks_Prgmers {
	public static void main(String[] args) {
		int bridge_length = 2;
		int weight = 10;
		int truck_weights[] = {7,4,5,6}; 
		
		int result = solution(bridge_length,weight,truck_weights);
		System.out.println(result);
		return;
	}
	
    static public int solution(int bridge_length, int weight, int[] truck_weights) {
        int time = 0;
        int total_weight = 0;
        Queue<Integer> bridge = new LinkedList<>();
        
        for(int i=0;i<truck_weights.length;i++) {

        		while(true) {
        			if(bridge.isEmpty()) {
        				bridge.offer(truck_weights[i]);
        				total_weight += truck_weights[i]; 
        				time++;
        				break;
        			}
        			else if(bridge.size() == bridge_length) {
        				total_weight -= bridge.peek();
        				bridge.poll();
        			}
        			else {
        				if(total_weight + truck_weights[i] <= weight) {
        					bridge.offer(truck_weights[i]);
        					total_weight += truck_weights[i];
        					time++;
        					break;
        				}
        				else {
        					bridge.offer(0);
        					time++;
        				}
        			}
        		}
        }
        
        return time + bridge_length;
    }
}
