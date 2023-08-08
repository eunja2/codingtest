import java.util.stream.IntStream;

public class Q18_lv1_모의고사2 {
	
	private static final int[][] RULES = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};
	
	// 사람에 따른 문제의 답 반환
	private int getPicked(int person, int problem) {
		int[] rule = RULES[person]; // 몇 번째 사람의 답
		int index = problem % rule.length; // 문제에 따라 반복되는 답의 위치
		
		return rule[index]; // 답 반환
	}
	
	public int[] solution(int[] answers) {
		int[] corrects = new int[3]; // 사람마다의 정답 개수
		int max = 0;
		
		for(int problem=0;problem<answers.length;problem++) {
			int answer = answers[problem];
			
			for(int person=0;person<3;person++) {
				int picked = getPicked(person, problem);
				if(answer == picked) {
					if(++corrects[person] > max)
						max = corrects[person];
				}
			}
		}
		
		final int maxCorrects = max;
		return IntStream.range(0, 3)
				.filter(i -> corrects[i] == maxCorrects)
				.map(i -> i+1)
				.toArray();
	}
}
