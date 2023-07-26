

public class Q11_lv1_문자열내p와y의개수 {
	/* boolean solution(String s) {
        boolean answer = true;

        int countP = 0;
        int countY = 0;
        
        for(char c : s.toCharArray()) {
        	if(c=='p' || c=='P') countP++;
        	if(c=='y' || c=='Y') countY++;
        }
        
        if(countP != countY) answer = false;
        
        return answer;
    } */
	
	boolean solution(String s) {
		s = s.toLowerCase();
		
		// 문자열에 등장하는 모든 "p"를 문자열 ""로 치환해서 원본 문자열 길이에서 빼면 그게 p의 개수
		int ps = s.length() - s.replace("p", "").length(); 
		int ys = s.length() - s.replace("y", "").length(); 
		return ps==ys;
	}
}
