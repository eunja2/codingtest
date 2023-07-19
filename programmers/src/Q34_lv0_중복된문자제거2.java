import java.util.HashSet;
import java.util.Set;

public class Q34_lv0_중복된문자제거2 {
	public static String solution(String my_string) {
		Set<Character> used = new HashSet<>();
		StringBuilder sb = new StringBuilder();
		
		for(char c : my_string.toCharArray()) {
			if(used.contains(c)) continue;
			used.add(c);
			sb.append(c);
		}
		
		return sb.toString();
    }
	
	public static void main(String[] args) {
		String my_string = "people";
		System.out.println(solution(my_string));
	}
}
