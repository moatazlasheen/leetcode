package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class FibonacciNumberTest {
	
	private FibonacciNumber underTest = new FibonacciNumber();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int num, int expected) {
		int actual = underTest.fib(num);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(0, 0),
			Arguments.of(1, 1),
			Arguments.of(2, 1),
			Arguments.of(3, 2),
			Arguments.of(4, 3),
			Arguments.of(5, 5),
			Arguments.of(6, 8),
			Arguments.of(7, 13),
			Arguments.of(8, 21),
			Arguments.of(9, 34)
		);
	}
}
