package leetcode.proplems.famousalgo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.famousalgo.MaxSubarray;

class MaxSubarrayTest {

	private MaxSubarray underTest = new MaxSubarray();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int expected ) {
		int actual = underTest.maxSubArray(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {-2,1,-3,4,-1,2,1,-5,4}, 6),
			Arguments.of(new int [] {1}, 1),
			Arguments.of(new int [] {5,4,-1,7,8}, 23)
		);
	}
	
	
}
