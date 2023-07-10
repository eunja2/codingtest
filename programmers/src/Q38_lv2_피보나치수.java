import java.util.Arrays;

public class Q38_lv2_피보나치수 {
	final int[] mem = new int[1000001];
	
	public int solution(int n) {
		Arrays.fill(mem, -1);
		for(int i=0;i<=n;i++)
			fibonacci(n);
		
        return fibonacci(n);
    }
	
	private int fibonacci(int n) {
		// 종료 조건
		if(mem[n] != -1) return mem[n];
		if(n==0 || n==1) return n;

		return mem[n] = (fibonacci(n-1) + fibonacci(n-2)) % 1234567;
	}
}
