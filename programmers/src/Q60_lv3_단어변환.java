import java.util.LinkedList;
import java.util.Queue;

public class Q60_lv3_단어변환 {
	private static class State {
		public final String word;
		public final int step;
		
		private State(String word, int step) {
			this.word = word;
			this.step = step;
		}
	}
	
	public int solution(String begin, String target, String[] words) {
		boolean[] isVisited = new boolean[words.length];
		
		Queue<State> q = new LinkedList<>();
		q.add(new State(begin, 0));
		
		while(!q.isEmpty()) {
			State state = q.poll();
			
			if(state.word.equals(target))
				return state.step;
			
			for(int i=0;i<words.length;i++) {
				String next = words[i];
				if(!isConvertable(state.word, next)) continue;
				if(isVisited[i]) continue;
				
				// 전이 될 수 있는 상태
				isVisited[i] = true;
				q.add(new State(next, state.step + 1));
			} 
		}
        return 0;
    }
	
	// 두 단어가 변환될 수 있는지 검사
	private boolean isConvertable(String src, String dst) {
		char[] srcArr = src.toCharArray();
		char[] dstArr = dst.toCharArray();
		
		int count = 0;
		
		for(int i=0; i<srcArr.length; i++) {
			if(srcArr[i] != dstArr[i]) count++;
		}
		
		return count == 1;
	}
}
