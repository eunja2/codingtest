public class Q13_lv1_문자열다루기기본2 {
	public boolean solution(String s) {
		boolean answer = false;
		
		if(s.matches("[0-9]{4}|[0-9]{6}")) {
			answer = true;
		}
        
        return answer;
    }
}
