public class Q02_lv2_삼각달팽이3 {
	private static final int[] dx = {0, 1, -1}; // 아래 -> 오른쪽 -> 왼쪽 위 이동
	private static final int[] dy = {1, 0, -1};
	
	public int[] solution(int n) {
		
		int[][] triangle = new int[n][n];
		int value = 1; // 채워 넣을 숫자
		
		int x = 0; // 현재 위치
		int y = 0;
		int d = 0; // 방향 변수 추가
		
		while(true) {
			/*
			// 아래로 이동하면서 값 채우기
			while(true) {
				triangle[y][x] = value++;
				if(y == n-1 || triangle[y+1][x] != 0) break;
				y++;
			}
			// 오른쪽으로 이동할 수 있을 때만 진행
			if(x == n-1 || triangle[y][x+1] != 0) break;
			x++;
			
			// 오른쪽으로 이동하면서 값 채우기
			while(true) {
				triangle[y][x] = value++;
				if(x == n-1 || triangle[y][x+1] != 0) break;
				x++;
			}
			// 왼쪽 위로 이동할 수 있을 때만 진행
			if(triangle[y-1][x-1] != 0) break;
			x--; y--;
			
			// 왼쪽 위로 이동하면서 값 채우기
			while(true) {
				triangle[y][x] = value++;
				if(triangle[y-1][x-1] != 0) break;
				x--; y--;
			}
			if(y == n-1 || triangle[y+1][x] != 0) break;
			y++;
			*/ 
			
			triangle[y][x] = value++;
			// 다음 이동 좌표 구하기
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			// 현재 진행 방향으로는 더 이상 값을 채울 수 없을 때
			if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) {
				d = (d+1) % 3; // 이동방향 변경
				nx = x + dx[d];
				ny = y + dy[d];
				if(nx == n || ny == n || nx == -1 || ny == -1 || triangle[ny][nx] != 0) break;
			}
			
			x = nx;
			y = ny;
		}
		
		int[] result = new int[value-1];
		int idx = 0;
		for(int i=0;i<n;i++)
			for(int j=0;j<=i;j++)
				result[idx++] = triangle[i][j];
		
        return result;
    }
}
