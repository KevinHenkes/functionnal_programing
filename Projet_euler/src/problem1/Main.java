package problem1;

import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) {
		Set<Long> numbers = new HashSet();
		
		for (Long i = 0L; i < 1000; i++)
			numbers.add(i);

		Long output = numbers.parallelStream().filter(n -> {
			return (n % 3 == 0 || n % 5 == 0) ? true : false;
		}).reduce(0L, (sum, n) -> {
			return sum += n;
		}, (sum1, sum2) -> {
			return sum1 + sum2;
		});
		
		System.out.println(output);
	}

}
