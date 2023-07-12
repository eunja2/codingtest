import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q45_lv2_기능개발 {
	public int[] solution(int[] progresses, int[] speeds) {
		Queue<Integer> queue = new LinkedList<>();
		
		for(int i=0;i<progresses.length;i++) {
			queue.add(i);
		}
		
		int days = 0;
		int count = 0;
		List<Integer> result = new ArrayList<>();
		
		while(!queue.isEmpty()) {
			int index = queue.poll();
			int expiration = (int) Math.ceil((double)(100 - progresses[index]) / speeds[index]);
			
			if(expiration > days) {
				if(days != 0) {
					result.add(count);
					count = 0;
				}
				days = expiration;
			}
			count++;
			
		}
		result.add(count);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}
