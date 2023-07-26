

public class Q13_lv1_문자열다루기기본 {
	/* public boolean solution(String s) {
        boolean answer = true;
        if(!s.matches("^[0-9]${4}|^[0-9]${6}")) answer = false;
        
        return answer;
    } */
	
	public boolean solution(String s) {
        boolean answer = true;
        
        if(s.length() != 4 && s.length() != 6) answer = false;
        
        for(char c : s.toCharArray())
        	if(!Character.isDigit(c)) answer = false;
        
        return answer;
    }
}
