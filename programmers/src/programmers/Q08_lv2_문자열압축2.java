package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q08_lv2_문자열압축2 {
	public int solution(String s) {
		int min = Integer.MAX_VALUE;
		
		for(int length=1;length<=s.length();length++) {
			// 문자열 압축 후 가장 짧은 길이 선택
			int minLength = compress(s, length);
			if(minLength<min) min = minLength;
		}
		
		return min;
    }
	
	private int compress(String str, int length) {
		StringBuilder sb = new StringBuilder();
		String last = "";
		int count = 0;
		
		for(String token : split(str, length)) { // 설정된 길이만큼 문자열을 잘라낸 token의 배열 생성
			if(token.equals(last)) count++;
			else {
				if(count>1) sb.append(count);
				sb.append(last);
				last = token;
				count = 1;
			}
		}
		if(count>1) sb.append(count);
		sb.append(last);
		
		return sb.length();
	}
	
	private List<String> split(String str, int length){
		List<String> list = new ArrayList<>();
		for(int startIdx=0;startIdx<str.length();startIdx+=length) {
			int endIdx = startIdx + length;
			if(endIdx>str.length()) endIdx = str.length();
			list.add(str.substring(startIdx, endIdx));
		}
		
		return list;
	}
}

