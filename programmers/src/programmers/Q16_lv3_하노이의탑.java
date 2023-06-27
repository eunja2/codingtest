package programmers;

import java.util.ArrayList;
import java.util.List;

public class Q16_lv3_하노이의탑 {
	/* public int[][] solution(int n) {
        int[][] answer = hanoi(n, 1, 3).toArray(new int[0][]);
        return answer;
    }
	
	private List<int[]> hanoi(int n, int from, int to){
		if(n==1) return List.of(new int[] {from, to}); // List.of(array) : Array -> List로 변환
		
		int empty = 6 - from - to;
		List<int[]> result = new ArrayList<>();
		result.addAll(hanoi(n-1, from, empty));
		result.addAll(hanoi(1, from, to));
		result.addAll(hanoi(n-1, empty, to));
		
		return result;
	} */
	
	// List 순회과정 제거
	public int[][] solution(int n) {
		List<int[]> process = new ArrayList<>();
		hanoi(n, 1, 3, process);
		
		return process.toArray(new int[0][1]);
       
    }
	
	private void hanoi(int n, int from, int to, List<int[]> process) {
		if(n==1) {
			process.add(new int[] {from, to});
			return;
		} 
		int empty = 6 - from - to;
		
		hanoi(n-1, from, empty, process);
		hanoi(1, from, to, process);
		hanoi(n-1, empty, to, process);
	}
}
