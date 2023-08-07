import java.util.ArrayList;
import java.util.List;

public class Q17_lv2_모음사전3 {
	public static char[] words = {'A','E','I','O','U'};
	
	public int solution(String word) {
        return generate("").indexOf(word);
    }
	
	public List<String> generate(String word) {
		List<String> list = new ArrayList<>();
		list.add(word);
		
		if(word.length() == 5) return list;
		
		for(char c : words) 
			list.addAll(generate(word + c));
		
		return list;
	}
}