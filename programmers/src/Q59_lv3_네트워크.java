import java.util.Stack;

public class Q59_lv3_네트워크 {
	public int solution(int n, int[][] computers) {
		boolean[] isVisited = new boolean[n];
        int answer = 0;
        
        for(int i=0;i<n;i++) {
        	if(isVisited[i]) continue;
        	visitAll(i, computers, isVisited);
        	answer++;
        }
        
        return answer;
    }
	
	private void visitAll(int computer, int[][] computers, boolean[] isVisited) {
		Stack<Integer> stack = new Stack<>();
		stack.push(computer);
		
		while(!stack.isEmpty()) {
			int c = stack.pop();
			
			// 중복 검사
			if(isVisited[c]) continue;
			isVisited[c] = true;
			
			for(int next = 0; next < computers[c].length; next++) {
				if(computers[c][next] == 0) continue;
				stack.push(next);
			}
			
		}
	}
}
