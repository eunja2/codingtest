import java.util.LinkedList;
import java.util.Queue;

public class Q61_lv3_게임맵최단거리 {
	private static class State {
		public final int x;
		public final int y;
		public final int step;
		
		private State(int x, int y, int step){
			this.x = x;
			this.y = y;
			this.step = step;
		}
	}
	
	private static final int[] dx = {0, 1, 0, -1};
	private static final int[] dy = {-1, 0, 1, 0};
	
	public int solution(int[][] maps) {
		boolean[][] isVisited = new boolean[maps.length][maps[0].length];
		
		Queue<State> q = new LinkedList<>();
		// 초기 상태
		q.add(new State(0, 0, 1));
		isVisited[0][0] = true;
		
		// 모든 탐색 공간 순회
		while(!q.isEmpty()) {
			State state = q.poll();
			if(state.y == maps.length-1 && state.x == maps[state.y].length-1)
				return state.step;
			for(int d=0;d<4;d++) {
				int nx = state.x + dx[d];
				int ny = state.y + dy[d];
				
				if(0>ny || ny>maps.length-1 || 0>nx || nx>maps[ny].length-1) continue;
				if(maps[ny][nx] != 1) continue;
				if(isVisited[ny][nx]) continue;
				
				// 전이 가능 상태
				isVisited[ny][nx] = true;
				q.add(new State(nx, ny, state.step+1));
			}
		}
		
        return -1;
    }
}
