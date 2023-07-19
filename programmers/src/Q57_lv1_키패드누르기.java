import java.util.Arrays;
import java.util.stream.Collectors;

public class Q57_lv1_키패드누르기 {
	/* public String solution(int[] numbers, String hand) {
		
		StringBuffer sb = new StringBuffer();
		int left = -1;
		int right = -1;
		
		for(int number : numbers) {
			switch(number) {
				case 1: case 4: case 7:
					sb.append("L");
					left = number;
					break;
				case 3: case 6: case 9:
					sb.append("R");
					right = number;
					break;
				case 0:
					if(Math.abs(number - left) > Math.abs(number - right)) {
						sb.append("L");
						left = number;
						break;
					} else if(Math.abs(number - left) < Math.abs(number - right)) {
						sb.append("R");
						right = number;
						break;
					} else {
						if(hand.equals("left")) {
							sb.append("L");
							left = number;
							break;
						} else {
							sb.append("R");
							right = number;
							break;
						}
					}
				default : 
					if(Math.abs(number - left) < Math.abs(number - right)) {
						sb.append("L");
						left = number;
						break;
					} else if(Math.abs(number - left) > Math.abs(number - right)) {
						sb.append("R");
						right = number;
						break;
					} else {
						if(hand.equals("left")) {
							sb.append("L");
							left = number;
							break;
						} else {
							sb.append("R");
							right = number;
							break;
						}
					}
			}
		}
        return sb.toString();
    } */
	
	public String solution(int[] numbers, String hand) {
		Hand right = new Hand("R", hand.equals("right"), 2); // #에서 시작하는 오른손
		Hand left = new Hand("L", hand.equals("left"), 0); // *에서 시작하는 왼손
		
		return Arrays.stream(numbers)
		.mapToObj(n -> press(n, right, left).hand)
		.collect(Collectors.joining());
	}
	
	private int getX(int number) {
		if(number == 0) return 1;
		return (number -1) % 3;
	}
	
	private int getY(int number) {
		if(number == 0) return 3;
		return (number - 1) / 3;
	}
	
	private static class Hand {
		private final int baseX; // 해당 손만 누를 수 있는 번호
		public final String hand;
		public final float preference; // 오른손잡이, 왼손잡이에 따라 결정되는 값
		
		private int x;
		private int y;
		
		public Hand(String hand, boolean isPreferred, int x) {
			this.hand = hand;
			this.baseX = x;
			this.preference = isPreferred ? 0.5f : 0; // 주 손이라면 0.5만큼 뺀 값으로 계산
			this.x = x;
			this.y = 3;
		}
		
		public float distance(int x, int y) { // 떨어진 거리 계산하기
			if(x == baseX) return 0;
			int distance = Math.abs(x - this.x) + Math.abs(y - this.y);
			return distance - preference;
		}
		
		public void move(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
	
	private Hand press(int number, Hand right, Hand left) { // 해당 손 위치 번호로 옮기기
		int x = getX(number);
		int y = getY(number);
		
		float rDistance = right.distance(x, y);
		float lDistance = left.distance(x, y);
	
		Hand hand = right;
		if(lDistance < rDistance)
			hand = left;
		
		hand.move(x, y);
		
		return hand;
	}
}
