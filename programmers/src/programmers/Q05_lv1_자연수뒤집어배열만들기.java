package programmers;

public class Q05_lv1_자연수뒤집어배열만들기 {
	public int[] solution(long n) {
		String nums = Long.toString(n);
		String numsRev = new StringBuilder(nums).reverse().toString();
		char[] charArr = numsRev.toCharArray();
		
		int[] answer = new int[charArr.length];
		
		for(int i=0;i<charArr.length;i++)
			answer[i] = charArr[i]-'0';
        
        return answer;
    }
}
