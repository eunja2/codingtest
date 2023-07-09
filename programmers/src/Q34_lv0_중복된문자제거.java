import java.util.HashSet;
import java.util.Set;

public class Q34_lv0_중복된문자제거 {
	public String solution(String my_string) {
		Set<Character> used = new HashSet<>();
		char[] my_char = my_string.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(char c : my_char) {
			if(used.contains(c)) continue;
			used.add(c);
			sb.append(c);
		}
			
        String answer = sb.toString();
        return answer;
    }
}
