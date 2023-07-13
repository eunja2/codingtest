import java.util.Stack;

public class Q44_lv2_주식가격2 {
	public int[] solution(int[] prices) {
		Stack<Integer> stack = new Stack<>();
		
		int[] answer = new int[prices.length];
		for(int i=0;i<prices.length;i++) {
			if(!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int index = stack.pop();
				answer[index] = i - index;
			}
			stack.push(i);
		}
		
		// 순회해도 stack에 남아있는 원소들 -> 한 번도 가격이 떨어지지 않은 index
		while(!stack.isEmpty()) {
			int index = stack.pop();
			answer[index] = prices.length - index - 1;
		}
        
        return answer;
    }
}
