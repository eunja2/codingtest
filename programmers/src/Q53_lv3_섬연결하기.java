import java.util.Arrays;
import java.util.Comparator;

public class Q53_lv3_섬연결하기 {
	private static class Node {
		private int depth = 1;
		private Node parent = null;
		
		public boolean isConnected(Node o) {
			return root() == o.root();
		}
		
		public void merge(Node o) {
			if(isConnected(o)) return;
			
			Node root1 = root();
			Node root2 = o.root();
			
			if(root1.depth < root2.depth) root1.parent = root2;
			else if(root1.depth > root2.depth) root2.parent = root1;
			else {
				root2.parent = root1;
				root1.depth++;
			}
		}
		
		private Node root() {
			if(parent == null) return this;
			return parent.root();
		}
	}
	
	private static class Edge {
		public final int u;
		public final int v;
		public final int cost;
		
		private Edge(int u, int v, int cost) {
			this.u = u;
			this.v = v;
			this.cost = cost;
		}
	}
	
	public int solution(int n, int[][] costs) {
		Edge[] edges = new Edge[costs.length]; 
		for(int i=0;i<costs.length;i++) {
			edges[i] = new Edge(costs[i][0], costs[i][1], costs[i][2]);
		}
		Arrays.sort(edges, Comparator.comparing(e -> e.cost));
		
		Node[] nodes = new Node[n];
		for(int i=0;i<n;i++)
			nodes[i] = new Node();
		
		int totalCost = 0;
		for(Edge edge : edges) {
			Node node1 = nodes[edge.u];
			Node node2 = nodes[edge.v];
			
			if(node1.isConnected(node2)) continue;
			node1.merge(node2);
			totalCost += edge.cost;
		}
		
        return totalCost;
    }
}
