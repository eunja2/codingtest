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
		owns.retainAll(Arrays.stream(reserve)
				.boxed().collect(Collectors.toSet()));
		
		// 체육복 빌려야 하는 lost 배열 -> 앞쪽 원소부터 차례대로 확인하므로 큐에 담기
		Queue<Integer> q = new LinkedList<>();
		for(int l : lost) q.add(l);
		
		// reserve 순회하며 큐에 담긴 학생 중 몇 명에게 빌려줄 수 있나 count
		int get = 0;
		for(int r : reserve) {
			if(owns.contains(r)) continue; // 체육복 가지고 있는 학생이 체육복 읽어버렸으면 pass
			
			// 체육복 빌려야 하는 학생 번호가 너무 작거나, 체육복 빌려야 하는 학생이 여벌 옷 가지고 있다면 pass
			while(!q.isEmpty() && (q.peek() < r - 1 || owns.contains(q.peek()))) {
				q.poll();
			}
			
			if(q.isEmpty()) break;
			
			if(q.peek() <= r + 1) { // 체육복 빌려줄 수 있는 번호일 때
				q.poll();
				get++;
			}
		}
		
		return n - lost.length + owns.size() + get;
    }
}
