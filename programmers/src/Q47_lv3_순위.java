
public class Q47_lv3_순위 {
	public static int solution(int n, int[][] results) {
		
		boolean[][] graph = new boolean[n][n];
		for(int[] edge : results) {
			int u = edge[0] - 1; // 인덱스에 맞게 변환
			int v = edge[1] - 1;
			graph[u][v] = true;
		}
		
		int count = 0;
		for(int u=0; u<n; u++) {
			int wins = countForward(u, graph, new boolean[n]) - 1;
			int loses = countBackward(u, graph, new boolean[n]) - 1;
			if(wins + loses + 1 == n) count++;
		}
		
		return count;
	}
	
	private static int countForward(int u, boolean[][] graph, boolean[] isVisted) {
		int count = 1;
		
		for(int v = 0; v < graph[u].length; v++) {
			if(!graph[u][v] || isVisted[v]) continue;
			isVisted[v] = true;
			count += countForward(v, graph, isVisted);
		}
		
		return count;
	}
	
	private static int countBackward(int u, boolean[][] graph, boolean[] isVisted) {
		int count = 1;
		
		for(int v = 0; v < graph.length; v++) {
			if(!graph[v][u] || isVisted[v]) continue;
			isVisted[v] = true;
			count += countBackward(v, graph, isVisted);
		}
		
		return count;
	}
	
	public static void main(String[] args) {
		int[][] results = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
		System.out.println(solution(5, results));
	}
}
