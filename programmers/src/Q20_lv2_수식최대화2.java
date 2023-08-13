import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Q20_lv2_수식최대화2 {
	private final String[][] precedences = {
			"+-*".split(""),
			"+*-".split(""),
			"-+*".split(""),
			"-*+".split(""),
			"*+-".split(""),
			"*-+".split("")
	};
	
	private long calculate(long lhs, long rhs, String op) {
		return switch(op) {
			case "+" -> lhs + rhs;
			case "-" -> lhs - rhs;
			case "*" -> lhs * rhs;
			default -> 0;
		};
	}
	
	private long calculate(List<String> tokens, String[] precedence) {
		for(String op : precedence) {
			for(int i=0;i<tokens.size();i++) {
				if(tokens.get(i).equals(op)) {
					long lhs = Long.parseLong(tokens.get(i-1));
					long rhs = Long.parseLong(tokens.get(i+1));
					long result = calculate(lhs, rhs, op);
					
					tokens.remove(i-1);
					tokens.remove(i-1);
					tokens.remove(i-1);
					tokens.add(i-1, String.valueOf(result));
					i -= 2;
				}
			}
		}
		return Long.parseLong(tokens.get(0));
	}
	
	public long solution(String expression) {
		StringTokenizer st = new StringTokenizer(expression, "+-*", true); // true -> 구분자도 토큰으로 간주됨
		List<String> tokens = new ArrayList<>();
		while(st.hasMoreTokens())
			tokens.add(st.nextToken());
		
		long max = 0;
		for(String[] precedence : precedences) {
			long temp = Math.abs(calculate(new ArrayList<>(tokens), precedence));
			if(temp>max) max = temp;
		}
		
        return max;
    }
}
