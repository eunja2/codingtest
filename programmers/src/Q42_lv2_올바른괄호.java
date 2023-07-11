import java.util.Stack;

public class Q42_lv2_올바른괄호 {
	/* boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
        	if(c == '(') {
        		stack.add(c);
        	} else {
        		if(!stack.isEmpty()) 
        			stack.pop();
        		else
        			answer = false;
        	}
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    } */
	
	boolean solution(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();
        for(char c : s.toCharArray()) {
        	switch(c) {
        		case '(' -> stack.push(c);
        		case ')' -> {
        			if(!stack.isEmpty()) 
            			stack.pop();
            		else
            			answer = false;
        		}
        	}
        }
        
        if(!stack.isEmpty()) answer = false;
        
        return answer;
    }
}
