package leetcode.proplems.search;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.search.BinarySearch;

class BinarySearchTest {

	private BinarySearch underTest = new BinarySearch();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] input, int target, int expected ) {
		int actual = underTest.search(input, target);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {-1}, 0, -1 ),
			Arguments.of(new int [] {-1}, -1, 0 ),
			Arguments.of(new int [] {-1,0,3,5,9,12}, 9, 4 ),
			Arguments.of(new int [] {-1,0,3,5,9,12}, 2, -1 ),
			Arguments.of(new int [] {-5, -3, -2, 1, 4, 7, 9, 19, 25}, 25, 8),
			Arguments.of(new int [] {-1, 0, 5}, -1, 0),
			Arguments.of(new int [] {-1,0,3,5,9,12}, 0, 1 ) 
			
		);
	}
	
}
