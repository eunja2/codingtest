import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q46_lv2_다리를지나는트럭 {
	/* public static int solution(int bridge_length, int weight, int[] truck_weights) {
		List<Integer> out = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		int bridge_weights = 0;
		int count = 0;
		int idx = 0;
		
		for(int i=0;i<bridge_length;i++)
			q.add(0);
		
		while(out.size() < truck_weights.length ) {
			
			int poll = q.poll();
			if(poll!=0) {
				out.add(poll);
				bridge_weights -= poll;
			}
			
			int next = 0;
			
			if(idx<truck_weights.length) 
				next = truck_weights[idx];
			 else 
				next = 0;
			
			if(bridge_weights + next <= weight) {
				q.add(next);
				bridge_weights += next;
				idx++;
			} else {
				q.add(0);
			}
			count++;
		}
		
        return count;
    } */ 
	
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
