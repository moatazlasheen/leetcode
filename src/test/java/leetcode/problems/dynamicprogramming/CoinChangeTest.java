package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class CoinChangeTest {
	
	private CoinChange underTest = new CoinChange();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int nums [], int target, int expected) {
		int actual = underTest.coinChange(nums, target);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(new int [] {1, 2, 5}, 11, 3),
			Arguments.of(new int [] {2}, 3, -1),
			Arguments.of(new int [] {1}, 0, 0)
		);
	}
}
