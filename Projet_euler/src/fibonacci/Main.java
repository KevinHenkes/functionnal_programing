package fibonacci;

import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		final Supplier<Stream<Long>> stream = () -> Stream.of(1L, 2L);

		System.out.println(String.valueOf(suitFibonacci(stream)));
	}

	// Retrieve sum and max value for continue calcul with recursion
	public static Long suitFibonacci(Supplier<Stream<Long>> streamSupplier) {
		final Supplier<Stream<Long>> ss = () -> {
			return Stream.of(sum(streamSupplier.get()), streamSupplier.get().max(Long::compare).get());
		};

		if (sum(streamSupplier.get()) > 89)
			return streamSupplier.get().max(Long::compare).get();

		return suitFibonacci(ss);
	}

	// Sum content of long stream, return a long
	public static Long sum(Stream<Long> stream) {
		return stream.reduce(0L, (sum, n) -> {
			return sum += n;
		}, (sum1, sum2) -> {
			return sum1 + sum2;
		});
	}
}