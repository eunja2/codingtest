import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q45_lv2_기능개발2 {
	public int[] solution(int[] progresses, int[] speeds) {
		
		Queue<Integer> queue = new LinkedList<>();
		for(int i=0;i<progresses.length;i++)
			queue.add(i);
		
		List<Integer> answer = new ArrayList<>();
		int count = 0;
		int days = 0;
		while(!queue.isEmpty()) {
			int index = queue.poll();
			int expiration = (int) Math.ceil(((double)(100-progresses[index]) / speeds[index]));
			if(expiration > days) {
				if(days != 0) {
					answer.add(count);
					count = 0;
				}
				days = expiration;
			}
			count++;
		}
		answer.add(count); // 추가작업이 필요하지 않은 마지막 count 기록
		
        return answer.stream()
        		.mapToInt(Integer::intValue) // IntStream인 기본형 스트림으로 변환(최종적으로 Integer[]형이 아닌 int[]형을 반환하기 위해)
        		.toArray(); // 배열로 변환
    }
}
