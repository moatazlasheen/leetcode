package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.ArrayRotation;

class ArrayRotationTest {

	
	private ArrayRotation underTest = new ArrayRotation();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int[] expected ) {
		
		underTest.rotate(nums, k);
		assertEquals(expected.length, nums.length);
		for ( int i=0; i<expected.length; i++ ) {
			assertEquals(expected[i], nums[i]);
		}
		
		
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1,2,3,4,5,6,7}, 3, new int [] {5,6,7,1,2,3,4}),
			Arguments.of(new int [] {-1,-100,3,99}, 2, new int [] {3,99,-1,-100})
		);
	}
}
