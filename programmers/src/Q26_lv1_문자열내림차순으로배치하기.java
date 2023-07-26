

import java.util.Arrays;
import java.util.Collections;

public class Q26_lv1_문자열내림차순으로배치하기 {
	public String solution(String s) {
//		return s.chars()
//			.boxed()
//			.sorted((v1, v2) -> v2 - v1)
//			.collect(StringBuilder::new,
//					 StringBuilder::appendCodePoint,
//					 StringBuilder::append)
//			.toString();
		
		String[] sArr = s.split("");
		Arrays.sort(sArr, Collections.reverseOrder());
		
		StringBuilder sb = new StringBuilder();
		for(String str : sArr)
			sb.append(str);
		
		return sb.toString();
    }
}