

public class Q10_lv2_이진변환반복하기 {
	public int[] solution(String s) {
		int loop = 0;
		int removed = 0;
		
		while(!s.equals("1")) {
			// 0의 개수 세기
			int zeros = countZero(s);
			loop++;
			removed += zeros;
			
			// 문자열 s 변환
			int ones = s.length() - zeros;
			s = Integer.toString(ones, 2);
		}
        int[] answer = {loop, removed};
        return answer;
    }
	
	private int countZero(String s) {
		int zero = 0;
		for(char c : s.toCharArray())
			if(c=='0') zero++;
		return zero;
	}
}
