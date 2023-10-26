package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestIncreasingSubSequenceTest {
	
	private LongestIncreasingSubSequence underTest = new LongestIncreasingSubSequence();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int expected ) {
		
		int actual = underTest.lengthOfLIS(nums);
		
		assertEquals(expected, actual);
		
	}

	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {10,9,2,5,3,7,101,18}, 4),	
			Arguments.of(new int [] {10,9,2,5,3,7,101,18, 19, 102, 105, 20}, 7),
			Arguments.of(new int [] {0,1,0,3,2,3}, 4),
			Arguments.of(new int [] {0,1,0,3,2,3,1,4}, 5),
			Arguments.of(new int [] {7,7,7,7,7,7,7}, 1),
			Arguments.of(new int [] {4,10,4,3,8,9}, 3)
		);
	}
}
