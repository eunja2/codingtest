public class Q11_lv1_문자열내p와y의개수2 {
	boolean solution(String s) {
		s = s.toLowerCase();
		int p = 0;
		int y = 0;
		
		for(char c : s.toCharArray()) {
			if(c=='p') p++;
			if(c=='y') y++;
		}

        return p==y;
    }
}
