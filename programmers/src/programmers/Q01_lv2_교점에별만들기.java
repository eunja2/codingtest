package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q01_lv2_교점에별만들기 {
	private static class Point {
		public final long x, y;
		private Point(long x, long y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
		double x = (double) (b1*c2 - c1*b2) / (a1*b2 - a2*b1);
		double y = (double) (c1*a2 - a1*c2) / (a1*b2 - b2*b1);
		
		if(x%1 !=0 || y%1 !=0) return null; // x,y 둘 중 하나라도 정수 아니면 null 반환
		
		return new Point((long)x, (long)y);
	}
	
	private Point getMinimum(List<Point> points) {
		long x = Long.MAX_VALUE;
		long y = Long.MAX_VALUE;
		
		for(Point p : points) {
			if(p.x < x) x = p.x;
			if(p.y < y) y = p.y;
		}
		
		return new Point(x, y);
	}
	private Point getMaximum(List<Point> points) {
		long x = Long.MIN_VALUE;
		long y = Long.MIN_VALUE;
		
		for(Point p : points) {
			if(p.x > x) x = p.x;
			if(p.y > y) y = p.y;
		}
		
		return new Point(x, y);
	}
	
	public String[] solution(int[][] line) {
		List<Point> points = new ArrayList<>();
		
		for(int i=0;i<line.length;i++) {
			for(int j=0;j<line.length;j++) {
				Point intersection = intersection(line[i][0], line[i][1], line[i][2], line[j][0], line[j][1], line[j][2]);
				if(intersection != null)
					points.add(intersection); // 정수 좌표만 저장
			}
		}
		
		// 2차원 배열의 크기 구하기
		// 좌표 중 최소, 최댓값 구하기
		Point min = getMinimum(points);
		Point max = getMaximum(points);
		
		int width = (int)(max.x - min.x + 1);
		int height = (int)(max.y - min.y + 1);
		
		char[][] arr = new char[height][width]; // 2차원 배열 -> y좌표 먼저 접근
		for(char[] row : arr)
			Arrays.fill(row, '.');
		
		for(Point p : points) {
			int x = (int) (p.x-min.x);
			int y = (int) (max.y-p.y);
			arr[y][x] = '*';
		}
		
        String[] answer = new String[arr.length];
        for(int i=0;i<answer.length;i++)
        	answer[i] = new String(arr[i]);
        
        return answer;
    }

}
 
