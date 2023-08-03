package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.MinSubArraySize;

class MinSubArraySizeTest {

	private MinSubArraySize underTest = new MinSubArraySize();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int target, int expected ) {
		int actual = underTest.minSubArrayLen(target, nums);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {2,3,1,2,4,3}, 7, 2),
			Arguments.of(new int [] {1,4,4}, 4, 1),
			Arguments.of(new int [] {1,1,1,1,1,1,1,1}, 11, 0),
			Arguments.of(new int [] {1,1,1,1,1,1,1,1,1,1,1,50}, 50, 1),
			Arguments.of(new int [] {1,1,1,1,1,1,1,1,1,1,1,50}, 51, 2),
			Arguments.of(new int [] {1,1,1,1,1,1,1,1,1,1,1,50}, 52, 3)
		);
	}
}
