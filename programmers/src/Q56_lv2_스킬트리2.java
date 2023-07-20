import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Q56_lv2_스킬트리2 {
	public static int solution(String skill, String[] skill_trees) {
		int count = 0;
		
		for(String s : skill_trees) {
			String str = s.replaceAll("[^"+skill+"]", "");
			if(skill.startsWith(str)) count++;
		}
		
        return count;
    }
	
	/* public static int solution(String skill, String[] skill_trees) {
		return (int) Arrays.stream(skill_trees)
				.map(s -> s.replaceAll("[^"+skill+"]",""))
				.filter(skill::startsWith) // 특정 문자로 시작하는지 검사
				.count();
	} */
	
	public static void main(String[] args) {
		System.out.println(solution("CBD", new String[]{"BACDE","CBADF","AECB","BDA"}));
	} 
}
