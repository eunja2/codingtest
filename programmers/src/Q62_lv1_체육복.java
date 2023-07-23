import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.stream.Collectors;

public class Q62_lv1_체육복 {
	public int solution(int n, int[] lost, int[] reserve) {
		Arrays.sort(lost);
		Arrays.sort(reserve);
		
		// 체육복 가져온 학생이 체육복 도난당했을 경우
		// lost와 reserve를 Set으로 변환하고 retainAll() 메서드로 교집합 구하기
		Set<Integer> owns = Arrays.stream(lost)
				.boxed()
				.collect(Collectors.toSet());
		owns.retainAll(Arrays.stream(reserve).boxed().collect(Collectors.toSet()));
		
		Queue<Integer> q = new LinkedList<>();
		for(int l : lost) q.add(l);
		
		int get = 0;
		for(int r : reserve) {
			if(owns.contains(r)) continue;
			
			while(!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
				q.poll();
			}
			
			if(q.isEmpty()) break;
			
			if(q.peek() <= r + 1) {
				q.poll();
				get++;
			}
		}
		
		return n- lost.length + owns.size() + get;
    }
}
