package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.ZeroMoving;

class ZeroMovingTest {
	
	private ZeroMoving underTest = new ZeroMoving();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int [] expected ) {
		
		underTest.moveZeroes(nums);
		
		assertTrue(Arrays.equals(expected, nums));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {0,1,0,3,12}, new int [] {1,3,12,0,0}),
			Arguments.of(new int [] {1,0,0,2,0,3,4,5}, new int [] {1,2,3,4,5,0,0,0}),
			Arguments.of(new int [] {0}, new int [] {0})
		);
	}

}
