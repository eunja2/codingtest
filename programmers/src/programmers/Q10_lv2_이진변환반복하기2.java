package programmers;

public class Q10_lv2_이진변환반복하기2 {
	public int[] solution(String s) {
		int loop = 0;
		int removed = 0;
		
		while(!s.equals("1")) {
			int zeros = countZero(s);
			loop++;
			removed += zeros;
			
			// 문자열 변환
			int one = s.length() - zeros;
			s = Integer.toString(one, 2);
		}
		
        int[] answer = {loop, removed};
        return answer;
    }
	
	private int countZero(String str) {
		int zero = 0;
		for(char c : str.toCharArray())
			if(c == '0') zero++;
		
		return zero;
	}
}
