package programmers;

public class Q02_lv2_삼각달팽이 {
	public int[] solution(int n) {
		int[][] triangle = new int[n][n];
		int value = 1;
		int x = 0;
		int y = 0;
		
		// triangle 채우기
		while(true) {
			// 아래로 이동
			while(true) {
				triangle[y][x] = value++;
				
				if(y+1 == n || triangle[y+1][x] != 0) break;
				y += 1;
			}
			if(x+1 == n || triangle[y][x+1] != 0) break;
			x += 1;
			
			// 오른쪽으로 이동
			while(true) {
				triangle[y][x] = value++;
				
				if(x+1 == n || triangle[y][x+1] != 0) break;
				x += 1;
			}
			if(triangle[y-1][x-1] != 0) break;
			x -= 1;
			y -= 1;
			
			// 왼쪽 위로 이동
			while(true) {
				triangle[y][x] = value++;
				
				if(triangle[y-1][x-1] != 0) break;
				x -= 1;
				y -= 1;
			}
			if(y+1 == n || triangle[y+1][x] != 0) break;
			y += 1;
		}

        int[] answer = new int[value - 1];
        int idx = 0;
        for(int i=0;i<n;i++)
        	for(int j=0;j<=i;j++)
        		answer[idx++] = triangle[i][j];
        return answer;
    }
}
