public class Q09_lv1_3진법뒤집기2 {
	
	public static void main(String[] args) {
		
		String binary = "1010";
		int value = Integer.parseInt(binary);
		int value2 = Integer.parseInt(binary, 2);
		String hex = Integer.toString(value2, 16).toUpperCase();
		
		String three = Integer.toString(10, 3);
		
		System.out.println(value); // 1010
		System.out.println(value2); // 10 = 8 + 2
		System.out.println(hex); // A
		
		System.out.println(three); // A
	}
	
	
	public int solution(int n) {
        String three = Integer.toString(n, 3);
		String reversed = new StringBuilder(three).reverse().toString();
		
        return Integer.parseInt(reversed, 3);
    }
}
