package programmers;

public class Q12_lv1_숫자문자열과영단어2 {
	private final String[] nums = {
			"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
	};
	
	public int solution(String s) {
		s = s.toLowerCase();
		
		for(int i=0;i<nums.length;i++) {
			s = s.replace(nums[i], Integer.toString(i));
		}
			
		return Integer.parseInt(s);
		
    }
}
