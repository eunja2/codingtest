import java.util.Stack;

public class Q58_lv2_타겟넘버 {
	
	private static class State {
		public final int index; // 연산자 결정할 위치
		public final int acc; // 현재까지 연산자로 결정된 값
		
		State(int index, int acc){
			this.index = index;
			this.acc = acc;
		}
	}
	
	public int solution(int[] numbers, int target) {
		
		Stack<State> s = new Stack<>();
		s.push(new State(0, 0));
		
		int count = 0;
		
		while(!s.isEmpty()) {
			State state = s.pop();
			
			if(state.index == numbers.length) {
				if(state.acc == target) count++;
				continue;
			}
			
			// + 선택
			s.push(new State(state.index+1, state.acc + numbers[state.index])); 
			s.push(new State(state.index+1, state.acc - numbers[state.index])); 
		}
		
        return count;
    }
}
