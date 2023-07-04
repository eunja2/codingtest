package programmers;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Q28_lv2_가장큰수 {
	public String solution(int[] numbers) {
		return Arrays.stream(numbers)
				.mapToObj(String::valueOf) // 문자열로 변환
				.sorted((s1, s2) -> {
					int original = Integer.parseInt(s1+s2);
					int reversed = Integer.parseInt(s2+s1);
					return reversed - original; // 음수면 s2가 더 크다는 의미로 순서 바꿈 
				})
				.collect(Collectors.joining(""))
				.replaceAll("^0+","0"); // 0만으로 구성되었을 때
    }
}
