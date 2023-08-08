package leetcode.proplems.sorting;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.sorting.QuickSort;

class QuickSortTest {
	
	private QuickSort underTest = new QuickSort();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int [] expected ) {
		int [] actual = underTest.sortArray(nums);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1}, new int [] {1}),
			Arguments.of(new int [] {1,1}, new int [] {1,1}),
			Arguments.of(new int [] {-1,0,1}, new int [] {-1,0,1}),
			Arguments.of(new int [] {5,2,3,1}, new int [] {1,2,3,5}),
			Arguments.of(new int [] {5,2,3,1,3}, new int [] {1,2,3,3,5})
		);
	}

}
