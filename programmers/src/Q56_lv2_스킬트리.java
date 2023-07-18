import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q56_lv2_스킬트리 {
	/* public static int solution(String skill, String[] skill_trees) {
		Queue<Character> q = new LinkedList<>();
		int answer = 0;
		
		for(int i=0;i<skill_trees.length;i++) {
			q.clear();
			for(char c : skill.toCharArray())
				q.add(c);
			
			String s = skill_trees[i].replaceAll("[^"+skill+"]", ""); // skill 제외한 문자 제거
			for(char c : s.toCharArray()) {
				char peek = q.peek();
				if(c == peek) {
					q.poll();
					if(q.isEmpty()) break;
				}
			}
			
			if(skill.length() - q.size() == s.length()) {
				answer++;
			}
		}
        
        return answer;
    } */
	
	public static int solution(String skill, String[] skill_trees) {
		return (int) Arrays.stream(skill_trees)
				.map(s -> s.replaceAll("[^"+skill+"]",""))
				.filter(skill::startsWith) // 특정 문자로 시작하는지 검사
				.count();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"}));
	} 
}
