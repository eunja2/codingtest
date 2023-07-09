import java.util.HashSet;
import java.util.Set;

public class Q33_lv0_평행 {
	public static int solution(int[][] dots) {
		
		Set<Double> slopes = new HashSet<>();
		
		for(int i=0;i<dots.length;i++) {
			for(int j=i+1;j<dots.length;j++) {
				int a = dots[i][0];
				int b = dots[i][1];
				
				int c = dots[j][0];
				int d = dots[j][1];
				
				double slope = getSlope(a, b, c, d);
				if(slopes.contains(slope)) return 1;
				
				slopes.add(slope);
			}
		}
        return 0;
    }
	
	private static double getSlope(int x1, int y1, int x2, int y2) {
		return (double) (y2 - y1) / (x2 - x1);
	}
	
	public static void main(String[] args) {
	int[][] answer = {{1,4},{9,2},{3,8},{11,6}};
	System.out.println(solution(answer));
}
}
