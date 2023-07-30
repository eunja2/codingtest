import java.util.Arrays;

public class Q10_lv2_이진변환반복하기3 {
	public static int[] solution(String s) {
		
		int zerosCnt = 0; // 총 삭제된 0의 개수
		int binaryCnt = 0; // 총 이진변환된 횟수
		
		while(!s.equals("1")) {
			int zero = countZero(s);
			zerosCnt += zero;
			int length = s.length() - zero;
			binaryCnt++;
			
			s = Integer.toString(length, 2);
		}
		
        int[] answer = {binaryCnt, zerosCnt};
        return answer;
    }
	
	public static int countZero(String s) {
		int zero = 0;
		for(char c : s.toCharArray()) {
			if(c == '0') zero++;
		}
		return zero;
	}
	
	public static void main(String[] args) {
		int[] arr = solution("01110");
		System.out.println(Arrays.toString(arr));
	}
}
