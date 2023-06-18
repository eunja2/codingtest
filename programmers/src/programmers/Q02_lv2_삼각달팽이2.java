package programmers;

public class Q02_lv2_삼각달팽이2 {
	private static final int[] dx = {0, 1, -1}; 
	private static final int[] dy = {1, 0, -1}; // 하->우->좌상으로 이동
	
	public int[] solution(int n) {
		 	int[][] triangle = new int[n][n];
		 	int value = 1;
		 	int x = 0;
		 	int y = 0;
		 	int d = 0; // 진행 방향
		 	
		 	while(true) {
		 		triangle[y][x] = value++;
		 		int nx = x + dx[d];
		 		int ny = y + dy[d];
		 		if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) { // 현재 방향으로 더 진행 불가
		 			d = (d+1)%3; // 방향 전환
		 			nx = x + dx[d]; // 위치 계산
		 			ny = y + dy[d];
		 			if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break; // 방향 전환하고도 진행 불가
		 		}
		 		x = nx; // 현재 위치 업데이트
		 		y = ny;
		 	}
		 	
	        int[] answer = new int[value-1];
	        int idx = 0;
	        for(int i=0;i<n;i++)
	        	for(int j=0;j<=i;j++)
	        		answer[idx++] = triangle[i][j];
	        return answer;
	}
}
