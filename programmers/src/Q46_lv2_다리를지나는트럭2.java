import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q46_lv2_다리를지나는트럭2 { 
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
		int bridgeWeight = 0;
		Queue<Integer> bridge = new LinkedList<>();
		
		for(int i=0;i<bridge_length;i++)
			bridge.add(0);
		
		int time = 0;
		int truckIndex = 0;
		
		while(truckIndex < truck_weights.length) {
			bridgeWeight -= bridge.poll();
			
			int truckWeight = truck_weights[truckIndex];
			if(bridgeWeight + truckWeight <= weight) {
				bridge.add(truckWeight);
				bridgeWeight += truckWeight;
				truckIndex++;
			} else {
				bridge.add(0);
			}
			
			time++;
		}
		
		while(bridgeWeight>0) {
			bridgeWeight -= bridge.poll();
			time++;
		}
		
		return time;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(2, 10, new int[]{7, 4, 5, 6}));
	}
}
