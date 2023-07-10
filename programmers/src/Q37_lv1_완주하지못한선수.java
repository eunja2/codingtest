import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Q37_lv1_완주하지못한선수 {
	/* public String solution(String[] participant, String[] completion) {
		List<String> list = new ArrayList<>();
		for(String s : participant)
			list.add(s);
		
		for(int i=0;i<completion.length;i++) 
			if(list.contains(completion[i])) list.remove(completion[i]);
		
		StringBuilder sb = new StringBuilder();
		for(String item : list)
			sb.append(item);
		
        return sb.toString();
    } */
	
	public String solution(String[] participant, String[] completion) {
		Map<String, Integer> count = new HashMap<>();
		
		for(String s : participant) {
			count.putIfAbsent(s,0);
			count.put(s, count.get(s)+1);
		}
		
		for(String s : completion) {
			int v = count.get(s)-1;
			count.put(s, v);
			if(v==0) count.remove(s);
		}
		
        return count.keySet().iterator().next();
    }
}
