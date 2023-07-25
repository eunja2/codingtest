import java.util.Arrays;
import java.util.Comparator;

public class Q64_lv3_단속카메라 {
	public int solution(int[][] routes) {
		
		// 끝 시점 기준으로 이동 경로 정렬
		Arrays.sort(routes, Comparator.comparing(route -> route[1]));
		
		int count = 0;
		int last = Integer.MIN_VALUE;
		
		for(int[] route : routes) {
			if(route[0] <= last && last <= route[1]) continue; // 이미 단속 카메라 만난 경로
			
			last = route[1]; // 이동 경로의 끝 지점에 단속카메라 설치
			count++;
		}
		
        return count;
    }
}
