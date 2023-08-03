package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.NextPermutation;

class NextPermutationTest {
	
	
	private NextPermutation underTest = new NextPermutation();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int [] expected ) {
		
		underTest.nextPermutation(nums);
		
		assertTrue(Arrays.equals(expected, nums));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of( 
			Arguments.of(new int [] {1,2,3}, new int [] {1,3,2}),
			Arguments.of(new int [] {1,3,2}, new int [] {2,1,3}),
			Arguments.of(new int [] {2,1,3}, new int [] {2,3,1}),
			Arguments.of(new int [] {2,3,1}, new int [] {3,1,2}),
			Arguments.of(new int [] {3,2,1}, new int [] {1,2,3}),
			Arguments.of(new int [] {1,1,5}, new int [] {1,5,1})
		);
	}

}
