public class Q06_lv1_시저암호2 {
	public String solution(String s, int n) {
		
		char[] c = s.toCharArray();
		StringBuilder sb = new StringBuilder();
		
		for(int i=0;i<c.length;i++) {
			if(!Character.isAlphabetic(c[i])) continue;
			
			int offset = Character.isUpperCase(c[i]) ? 'A' : 'a';
			int position = c[i] - offset;
			
			position = (position + n) % 26;
			
			c[i] = (char)(offset + position) ;
		}
		
		for(char cc : c)
			sb.append(cc);
        return sb.toString();
    }
}
