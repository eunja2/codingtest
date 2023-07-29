import java.util.ArrayList;
import java.util.List;

public class Q08_lv2_문자열압축3 {
	public int solution(String s) {
        int min = Integer.MAX_VALUE;
        for(int length=1;length<=s.length();length++) {
        	int compressed = compress(s, length);
        	if(compressed<min) min = compressed;
        }
        
        return min;
    }
	
	// 문자열을 length 길이만큼 잘라 리스트에 담기
	private List<String> split(String source, int length){
		List<String> token = new ArrayList<>();
		// source를 length 길이만큼 잘라 token 리스트에 추가
		for(int startIdx=0;startIdx<source.length();startIdx+=length) {
			int endIdx = startIdx + length;
			if(endIdx>source.length()) endIdx = source.length();
			token.add(source.substring(startIdx, endIdx));
		}
		return token;
	}
	
	// 문자열을 받아 압축된 문자열 길이를 반환
	private int compress(String source, int length) {
		StringBuilder sb = new StringBuilder();
		
		String last ="";
		int count = 0;
		
		for(String token : split(source, length)) {
			if(token.equals(last)) count++;
			else {
				if(count>1) sb.append(count);
				sb.append(last);
				last = token;
				count = 1;
			}
		}
		// 안 들어간 마지막 last 추가해주기
		if(count>1) sb.append(count);
		sb.append(last);
		
		return sb.length();
	}
}

