import java.util.HashMap;
import java.util.Map;

public class Q35_lv0_A로B만들기 {
	public int solution(String before, String after) {
		return toMap(before).equals(toMap(after)) ? 1 : 0;
    }
	
	private static Map<Character, Integer> toMap(String word){
		Map<Character, Integer> map = new HashMap<>();
		for(char c : word.toCharArray()) {
			map.putIfAbsent(c,0);
			map.put(c, map.get(c)+1);
		}
		return map;
	}
}
