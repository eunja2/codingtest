public class Q07_lv1_이상한문자만들기2 {
	public String solution(String s) {
		
		char[] words = s.toCharArray();
		int index = 0;
		StringBuilder sb = new StringBuilder();
		for(char c : words) {
			if(c==' ') {
				index = 0;
				sb.append(c);
				continue;
			} else if(index%2==0) {
//				sb.append((c +"").toUpperCase());
				sb.append(Character.toUpperCase(c));
			} else { 
//				sb.append((c +"").toLowerCase());
				sb.append(Character.toLowerCase(c));
			}
			
			index++;
		}
		
        return sb.toString();
    }
}
