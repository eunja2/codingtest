

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Q21_lv2_소수찾기2 {
	public int solution(String numbers) {
        List<Integer> nums = numbers.chars().map(c -> c - '0').boxed().collect(Collectors.toList());
        return getPrimes(0, nums).size();
    }
	
	private Set<Integer> getPrimes(int acc, List<Integer> numbers){
		Set<Integer> primes = new HashSet<>();
		if(isPrime(acc)) primes.add(acc);
		
		for(int i=0;i<numbers.size();i++) {
			int nextAcc = acc*10 + numbers.get(i);
			
			List<Integer> nextNumbers = new ArrayList<>(numbers);
			nextNumbers.remove(i);
			primes.addAll(getPrimes(nextAcc, nextNumbers));
		}
		
		return primes;
	}
	
	private boolean isPrime(int acc) {
		if(acc<=1) return false;
		for(int i=2;i*i<=acc;i++)
			if(acc % i == 0) return false;
		return true;
	}
}
