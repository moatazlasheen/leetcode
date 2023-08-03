package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.SubArrayProductLessThanK;

class SubArrayProductLessThanKTest {
	
	private SubArrayProductLessThanK underTest = new SubArrayProductLessThanK();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int expected ) {
		int actual = underTest.numSubarrayProductLessThanK(nums, k);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [] {10,5,2,6}, 100, 8),
			Arguments.of( new int [] {10,5,2,6}, 0, 0)
		);
	}

}
