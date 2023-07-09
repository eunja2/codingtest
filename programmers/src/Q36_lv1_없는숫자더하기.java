import java.util.HashSet;
import java.util.Set;

public class Q36_lv1_없는숫자더하기 {
    public int solution(int[] numbers) {
    	Set<Integer> nums = new HashSet<>();
    	for(int n : numbers)
    		nums.add(n);
    	
    	int sum = 0;
    	for(int i=0;i<10;i++) {
    		if(!nums.contains(i)) sum += i;
    	}
    		
        return sum;
    }
}
