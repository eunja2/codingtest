

import java.util.Arrays;

public class Q27_lv1_문자열내마음대로정렬하기2 {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (s1, s2) -> {
			if(s1.charAt(n) != s2.charAt(n)) {
				return s1.charAt(n) - s2.charAt(n);
			} else
				return s1.compareTo(s2);
		});
		
        return strings;
    }
}
