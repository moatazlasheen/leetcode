package leetcode.proplems.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.search.RotatedSortedArray;

class RotatedSortedArrayTest {

	private RotatedSortedArray underTest = new RotatedSortedArray(); 
	
	@ParameterizedTest
	@MethodSource
	void testSearchWithParams ( int [] nums, int target, int expected ) {
		int actual = underTest.search(nums, target);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testSearchWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {4,5,6,7,0,1,2}, 0, 4),
			Arguments.of(new int [] {4,5,6,7,0,1,2}, 3, -1),
			Arguments.of(new int [] {1}, 0, -1),
			Arguments.of(new int [] {5,1,3}, 5, 0)
		);
	}
	
	
	@ParameterizedTest
	@MethodSource
	void testFindMinWithParams ( int [] nums, int expected ) {
		int actual = underTest.findMin(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testFindMinWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {3,4,5,1,2}, 1),
			Arguments.of(new int [] {4,5,6,7,0,1,2}, 0),
			Arguments.of(new int [] {11,13,15,17}, 11)
		);
	}
	
}
