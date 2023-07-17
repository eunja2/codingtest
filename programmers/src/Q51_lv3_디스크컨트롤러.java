import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q51_lv3_디스크컨트롤러 {
	
	private static class Job {
		public final int start;
		public final int duration;
		
		private Job(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}
	}
	
	public int solution(int[][] rawJobs) {
		Job[] jobs = new Job[rawJobs.length];
		for(int i=0;i<rawJobs.length;i++) 
			jobs[i] = new Job(rawJobs[i][0], rawJobs[i][1]);
		
		// 먼저 들어온 작업부터 처리하므로 정렬
		Arrays.sort(jobs, Comparator.comparing(job -> job.start)); // 작업 시작 시간으로 배열 정렬
		
		// 모든 작업 순회
		// asList(배열) : 배열->리스트 변환 LinkedList(Collection) : 주어진 컬렉션 포함하는 LinkedList 생성
		Queue<Job> q = new LinkedList<>(Arrays.asList(jobs)); 
		// 시작할 수 있는 작업 중 가장 수행 시간 짧은 작업 선택
		PriorityQueue<Job> pq = new PriorityQueue<>(Comparator.comparingInt(job -> job.duration));
		
		int exec = 0; // 작업 누적 시간
		int time = 0; // 현재 시간
 		
		while(!q.isEmpty() || !pq.isEmpty()) {
			while(!q.isEmpty() && q.peek().start <= time) {  // 시작할 수 있는 작업들 골라내야 함 
				pq.add(q.poll());
			}
			
			if(pq.isEmpty()) {
				time = q.peek().start; // 그 다음으로 빠른 요청시간
				continue;
			}
			
			Job job = pq.poll();
			exec += time - job.start + job.duration; // 대기시간 + 실행시간
			time += job.duration;
		}
		
        return exec / jobs.length;
    }
}
