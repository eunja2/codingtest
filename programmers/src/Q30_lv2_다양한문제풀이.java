import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Q30_lv2_다양한문제풀이 {
	// 매개변수 info 사용해서 조건별 리스트 생성하는 메서드
	private static Map<String, List<Integer>> buildScoresMap(String[] info){
		Map<String, List<Integer>> scoresMap = new HashMap<>();
		
		for(String s : info) {
			String[] tokens = s.split(" ");
			int score = Integer.parseInt(tokens[tokens.length-1]); // 코딩 점수
			
			// tokens로 만들 수 있는 모든 조건
			forEachKey(0, "", tokens, key -> {
				scoresMap.putIfAbsent(key, new ArrayList<>());
				scoresMap.get(key).add(score);
			});
		}
		
		for(List<Integer> list : scoresMap.values()) { // 리스트 정렬
			Collections.sort(list);
		}
		
		return scoresMap;
	}
	
	private static void forEachKey(int index, String prefix, String[] tokens, Consumer<String> action) {
		if(index == tokens.length-1) { // 코딩 점수 들어 있는 마지막 배열에 도달하면
			action.accept(prefix); // 검색조건 prefix를 처리
			return;
		}
		
		forEachKey(index+1, prefix + tokens[index], tokens, action);
		forEachKey(index+1, prefix + "-", tokens, action);
	}
	
	// 조건에 맞는 지원자 세기
	private static int count(String query, Map<String, List<Integer>> scoresMap) {
		String[] tokens = query.split(" (and)?"); // () 그룹으로 표현, x? x문자가 존재할 수도 존재하지 않을 수도
		
		String key = String.join("", Arrays.copyOf(tokens, tokens.length-1)); // 가장 마지막 점수는 포함X
		
		if(!scoresMap.containsKey(key)) return 0;
		List<Integer> scores = scoresMap.get(key); // 조건 만족하는 점수의 리스트
		
		int score = Integer.parseInt(tokens[tokens.length-1]); // 코딩 점수
		
		return scores.size() - binarySearch(score, scoresMap.get(key));
	}
	
	// 검사해야 할 점수보다 크거나 같은 값 중 가장 작은 값의 인덱스 반환
	private static int binarySearch(int score, List<Integer> scores) {
		int start = 0; // 포함
		int end = scores.size()-1; // 포함
		while(end>start) { // 원소 개수 : end - start + 1, end - start + 1 > 1
			int mid = (start + end) / 2;
			
			if(scores.get(mid) >= score)
				end = mid;
			else
				start = mid+1;
		}
		// 마지막 남은 요소 조건 검사
		if(scores.get(start) < score) return scores.size(); // 하나도 해당 되지 않음
		return start;
		
	}
	
	public static int[] solution(String[] info, String[] query) {
		Map<String, List<Integer>> scoresMap = buildScoresMap(info);
		
        int[] answer = new int[query.length];
        for(int i=0;i<answer.length;i++) {
        	answer[i] = count(query[i], scoresMap);
        }
        return answer;
    }
	
//	public static void main(String[] args) {
//		String[] answer = new String[] {"java backend junior pizza 150","python frontend senior chicken 210","python frontend senior chicken 150","cpp backend senior pizza 260","java backend junior chicken 80","python backend senior chicken 50"};
//		String[] query = new String[] {"java and backend and junior and pizza 100","python and frontend and senior and chicken 200","cpp and - and senior and pizza 250","- and backend and senior and - 150","- and - and - and chicken 100","- and - and - and - 150"};
//		System.out.println(solution(answer, query));
//	}
}
