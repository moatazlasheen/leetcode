package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.SquaresOfSortedArray;

class SquaresOfSortedArrayTest {
	
	private SquaresOfSortedArray underTest = new SquaresOfSortedArray();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] in, int [] expected ) {
		int [] actual = underTest.sortedSquares(in);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new int [] {-4,-1,0,3,10}, new int []{0,1,9,16,100}),
			Arguments.of( new int [] {-7,-3,2,3,11}, new int []{4,9,9,49,121}),
			Arguments.of( new int [] {1}, new int []{1}),
			Arguments.of( new int [] {-1}, new int []{1}),
			Arguments.of( new int [] {1,2}, new int []{1,4}),
			Arguments.of( new int [] {-5,-2}, new int []{4,25}),
			Arguments.of( new int [] {-5,-2,1,3}, new int []{1,4,9,25}),
			Arguments.of( new int [] {-5,-2,10,12}, new int []{4,25,100,144}),
			Arguments.of( new int [] {-3,-2,1,2,3}, new int []{1,4,4,9,9})
		);
	}

}
