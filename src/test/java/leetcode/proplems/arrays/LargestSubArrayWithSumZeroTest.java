package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.LargestSubArrayWithSumZero;

class LargestSubArrayWithSumZeroTest {

	
	private LargestSubArrayWithSumZero underTest = new LargestSubArrayWithSumZero();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int expected ) {
		int actual = underTest.getLongestSubArrayLengthWithSumZero(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {15,-2,2,-8,1,7,10,23}, 5),
			Arguments.of(new int [] {1,2,3}, 0),
			Arguments.of(new int [] {1,2,-1}, 0),
			Arguments.of(new int [] {5, 7, 15, -2, 2, -27}, 6)
		);
	}
}
