package programmers;

public class Q06_lv1_시저암호 {
	private char push(char c, int n) {
		if(!('a'<=c && c<='z') && !('A'<=c && c<='Z')) return c;
		
		int offset = Character.isUpperCase(c) ? 'A' : 'a';
		int position = c - offset;
		position = (position + n) % ('z' - 'a' + 1);
		return (char) (position + offset);
	}
	
	public String solution(String s, int n) {
		StringBuilder sb = new StringBuilder();
		for(char c : s.toCharArray()) {
			sb.append(push(c, n));
		}
			
        String answer = sb.toString();
        return answer;
    }
}
