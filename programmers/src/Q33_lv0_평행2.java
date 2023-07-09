import java.util.HashSet;
import java.util.Set;

public class Q33_lv0_평행2 {
	public double getSlope(int x1, int y1, int x2, int y2) {
		return (double) (y2-y1) / (x2-x1);
	}
	
	public int solution(int[][] dots) {
		Set<Double> slopes = new HashSet<>();
		
		double slope2 = getSlope(dots[0][0], dots[0][1], dots[1][0], dots[1][1]);
		double slope3 = getSlope(dots[2][0], dots[2][1], dots[3][0], dots[3][1]);
		if(slope2 == slope3) return 1;
		
		double slope4 = getSlope(dots[0][0], dots[0][1], dots[2][0], dots[2][1]);
		double slope5 = getSlope(dots[1][0], dots[1][1], dots[3][0], dots[3][1]);
		if(slope4 == slope5) return 1;
		
		double slope6 = getSlope(dots[1][0], dots[1][1], dots[2][0], dots[2][1]);
		double slope7 = getSlope(dots[0][0], dots[0][1], dots[3][0], dots[3][1]);
		if(slope6 == slope7) return 1;

		return 0;
	}

}
