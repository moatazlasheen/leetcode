package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.ColorSorting;

class ColorSortingTest {
	
	private ColorSorting underTest = new ColorSorting();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int [] expected ) {
		
		underTest.sortColors(nums);
		
		assertTrue(Arrays.equals(expected, nums));
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1}, new int [] {1}),
			Arguments.of(new int [] {1,0}, new int [] {0,1}),
			Arguments.of(new int [] {1,0,1}, new int [] {0,1,1}),
			Arguments.of(new int [] {1,0,1,0}, new int [] {0,0,1,1}),
			Arguments.of(new int [] {2,1,0,1,0}, new int [] {0,0,1,1,2})
		);
	}

}
