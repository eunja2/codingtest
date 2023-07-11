import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Q43_lv2_괄호회전하기 {
	Stack<Character> stack = new Stack<>();
	Queue<Character> queue = new LinkedList<>();
	
    public int solution(String s) {
    	
    	for(char c : s.toCharArray()) {
    		queue.add(c);
    	}
    	
    	int answer = 0;
    	
    	for(int i=0;i<s.length();i++) {
    		if(isCorrect(s))
    			answer++;
    		s = rotateLeft(s);
    	}
    	
        return answer;
    }
    
    private String rotateLeft(String s) {
    	queue.offer(queue.poll());
    	
    	String str = "";
    	Iterator<Character> iterator = queue.iterator();
    	while(iterator.hasNext())
    		str += iterator.next()+"";
    		
    	return str;
    }
    
    private boolean isCorrect(String s) {
    	for(char c : s.toCharArray()) {
    		switch(c) {
    			case '(': 
    				stack.push(')'); break;
				case '[': 
					stack.push(']'); break;
				case '{':
					stack.push('}'); break;
    			case ')': case ']': case '}': 
    				if(stack.isEmpty()) return false;
    				if(stack.pop()!=c) return false;;
    				break;
    		}
    	}
    	return stack.isEmpty();
    }
}
