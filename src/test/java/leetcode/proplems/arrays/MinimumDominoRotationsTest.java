package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.MinimumDominoRotations;

class MinimumDominoRotationsTest {

	private MinimumDominoRotations underTest = new MinimumDominoRotations(); 
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] tops, int [] bottoms, int expected ) {
		int actual = underTest.minDominoRotations(tops, bottoms);
		
		assertEquals(expected, actual);
				
	}
	
	private static Stream<Arguments> testWithParams () {
		return Stream.of(
			Arguments.of(new int [] {2,1,2,4,2,2}, new int [] {5,2,6,2,3,2}, 2),
			Arguments.of(new int [] {3,5,1,2,3}, new int [] {3,6,3,3,4}, -1),
			Arguments.of(new int [] {1,2,1,1,1,2,2,2}, new int [] {2,1,2,2,2,2,2,2}, 1),
			Arguments.of(new int [] {1,3,4,1,2,1,3,4}, new int [] {1,3,1,2,2,1,4,4}, -1)
		);
	}
}
