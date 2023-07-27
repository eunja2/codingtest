public class Q05_lv1_자연수뒤집어배열만들기2 {
	public int[] solution(long n) {
		
		StringBuilder sb = new StringBuilder(String.valueOf(n));
		sb.reverse();
		
        char[] answer = sb.toString().toCharArray();
        int[] result = new int[answer.length];
        
        for(int i=0;i<answer.length;i++)
        	result[i] = answer[i] - '0';
        
        return result;
    }
}
