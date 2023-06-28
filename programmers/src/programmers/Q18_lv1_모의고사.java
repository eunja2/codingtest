package programmers;

import java.util.stream.IntStream;

public class Q18_lv1_모의고사 {
	/* public int[] solution(int[] answers) {
		int[] a = {1, 2, 3, 4, 5};
		int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
		
		int[] aAnswer = new int[answers.length];
		int[] bAnswer = new int[answers.length];
		int[] cAnswer = new int[answers.length];
		
		for(int i=0;i<answers.length;i++) {
			aAnswer[i] = a[i%a.length];
			bAnswer[i] = b[i%b.length];
			cAnswer[i] = c[i%c.length];
		}
		
		int aCount = 0;
		int bCount = 0;
		int cCount = 0;

		for(int i=0;i<answers.length;i++) {
			if(answers[i] == aAnswer[i]) aCount++;
			if(answers[i] == bAnswer[i]) bCount++;
			if(answers[i] == cAnswer[i]) cCount++;
		}
		
        String max = "";
        if(aCount > bCount) {
        	if(aCount > cCount) {
        		max = "1";
        	} else if(cCount > aCount){
        		max = "3";
        	} else {
        		max = "13";
        	}
        } else if(bCount > cCount) {
        	if(bCount > aCount) {
        		max = "2";
        	} else if(aCount > bCount){
        		max = "1";
        	} else {
        		max = "12";
        	}
        } else if(cCount > aCount) {
        	if(cCount > bCount) {
        		max = "3";
        	} else if(bCount > cCount){
        		max = "2";
        	} else {
        		max = "23";
        	}
        } else
        	max = "123";
        
        char[] nums = max.toCharArray();
        int[] answer = new int[nums.length];
        
    	for(int i=0;i<nums.length;i++)
    		answer[i] = nums[i]-'0';
        return answer;
    } */
	
	private static final int[][] RULES = {
			{1, 2, 3, 4, 5},
			{2, 1, 2, 3, 2, 4, 2, 5},
			{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
	};
	
	private int getPicked(int person, int problem) {
		int[] rule = RULES[person];
		int index = problem % rule.length;
		
		return rule[index];
	}
	public int[] solution(int[] answers) {
		int[] corrects = new int[3];
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
