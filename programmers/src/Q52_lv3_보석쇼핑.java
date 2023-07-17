import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Q52_lv3_보석쇼핑 {
	public int[] solution(String[] gems) {
		int start = 0;
		int end = gems.length - 1;
		
		// 모든 보석 종류
		Set<String> gemSet = new HashSet<>(List.of(gems)); // 배열 -> List -> Set 변환
		
		int s = 0;
		int e = s;
		Map<String, Integer> includes = new HashMap<>();
		includes.put(gems[s], 1);
		
		while(s < gems.length) { // 구간[s,e]가 보석을 모두 포함하고 있는지 확인
			if(includes.keySet().size() == gemSet.size()) {
				if(e - s < end - start) { // 기존 구간 [start, end]와 이번에 발견한 구간[s, e] 비교하여 짧은 구간 선택
					start = s;
					end = e;
				}
				
				
				includes.put(gems[s], includes.get(gems[s]) - 1); // 구간 맨 앞에 있던 보석 1개 감소
				if(includes.get(gems[s]) == 0)
					includes.remove(gems[s]); // 맨 앞 보석이 0개라면 보석 자체 제거
				s++; // 시작점 뒤로 이동
			} else if(e<gems.length-1) { // 보석이 모두 포함되지 않았으므로
				e++; // 구간 끝점 뒤로 이동
				includes.put(gems[e], includes.getOrDefault(gems[e], 0) +1); // 기존 반환값 없을 경우 0 반환하고 1 더해줌
			} else 
				break;
		}
			
        return new int[] {start+1, end+1};
    }
}
