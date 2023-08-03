package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.SlidingWindowMax;

class SlidingWindowMaxTest {
	
	private SlidingWindowMax underTest = new SlidingWindowMax();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int [] expected ) {
		int [] actual = underTest.maxSlidingWindow(nums, k);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1,3,-1,-3,5,3,6,7}, 3, new int [] {3,3,5,5,6,7}),
			Arguments.of(new int [] {1,3,-1,-3,5,3,6,7,0}, 3, new int [] {3,3,5,5,6,7,7}),
			Arguments.of(new int [] {1,3,-1,-3,5,3,6,7,9}, 3, new int [] {3,3,5,5,6,7,9}),
			Arguments.of(new int [] {1}, 1, new int [] {1})
		);
	}

}
