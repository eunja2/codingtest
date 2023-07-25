import java.util.Stack;
import java.util.stream.Collectors;

public class Q63_lv2_큰수만들기 {
	public String solution(String number, int k) {
		Stack<Character> s = new Stack<>();
		
		for(char c : number.toCharArray()) {
			while(k>0 && !s.isEmpty() && c > s.peek()) {
				s.pop();
				k--;
			}
			s.push(c);
		}
		
		while(k-- >0) {
			s.pop();
		}
		
        return s.stream()
        		.map(String::valueOf) // map() : 원하는 필드만 뽑아내거나 특정 형태로 변환할 때
        		.collect(Collectors.joining()); // joining() : 문자열 결합
												// 스트림의 요소가 문자열이 아닌 경우 먼저 map()을 이용해서 스트림의 요소를 문자열로 변환해야 함
    }
}
