package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.TwoSum;

class TwoSumTest {
	
	private TwoSum underTest = new TwoSum();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int target, int [] expected ) {
		int [] actual = underTest.twoSum(nums, target);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [] {2,7,11,15}, 9, new int [] {0,1} ),
			Arguments.of( new int [] {3,2,4}, 6, new int [] {1,2} ),
			Arguments.of( new int [] {3,3}, 6, new int [] {0,1} )
		);
	}

}
