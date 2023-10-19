package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class HouseRobberTest {
	
	private HouseRobber underTest = new HouseRobber();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] nums, int expected) {
		int actual = underTest.rob(nums);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(new int [] {1, 2, 3, 1}, 4),
			Arguments.of(new int [] {2, 7, 9, 3, 1}, 12)
		);
	}
}
