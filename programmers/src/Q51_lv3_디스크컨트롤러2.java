import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q51_lv3_디스크컨트롤러2 {
	private static class Task {
		private int start;
		private int duration;
		
		public Task(int start, int duration) {
			this.start = start;
			this.duration = duration;
		}
	}
	
	public int solution(int[][] jobs) {
		Task[] tasks = new Task[jobs.length];
		for(int i=0;i<jobs.length;i++) 
			tasks[i] = new Task(jobs[i][0], jobs[i][1]);
			
		Arrays.sort(tasks, Comparator.comparingInt(task -> task.start));
		
		Queue<Task> q = new LinkedList<>(Arrays.asList(tasks));
		PriorityQueue<Task> pq = new PriorityQueue<>(Comparator.comparingInt(task -> task.duration));
		
		int acc = 0;
		int time = 0;
		
		while(!q.isEmpty() || !pq.isEmpty()) {
			while(!q.isEmpty() && q.peek().start <= time) { // q에서 요청 시간이 지난 작업 추출
				pq.add(q.poll());
			}
			
			if(pq.isEmpty()) { // 시작할 수 있는 작업 없음
				time = q.peek().start;
				continue;
			}
			
			// pq의 가장 앞 원소는 시작 가능한 작업 중 시간이 가장 짧은 작업
			Task task = pq.poll();
			acc += time + task.duration - task.start;
			time += task.duration;
		}
		
        return acc / tasks.length;
    }
}
