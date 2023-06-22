package programmers;

public class Q07_lv1_이상한문자만들기 {
	public String solution(String s) {
		StringBuilder sb = new StringBuilder();
		boolean toUpper = true;
		
		for(char c : s.toCharArray()) {
			if(!Character.isAlphabetic(c)) {
				sb.append(c);
				toUpper = true;
			} else {
				if(toUpper) sb.append(Character.toUpperCase(c));
				else sb.append(Character.toLowerCase(c));
				toUpper = !toUpper;
			}
		}
		
        String answer = sb.toString();
        return answer;
    }
}
