package programmers;

public class Q09_lv1_3진법뒤집기 {
	public int solution(int n) {
		String digit3 = Integer.toString(n, 3);
		String reversed = new StringBuilder(digit3).reverse().toString();
        int answer = Integer.parseInt(reversed, 3);
        return answer;
    }
}
