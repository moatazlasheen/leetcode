package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.KDiffPairsInArray;

class KDiffPairsInArrayTest {
	
	private KDiffPairsInArray underTest = new KDiffPairsInArray();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int expected ) {
		int actual = underTest.findPairs(nums, k);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1,2,3,4}, 1, 3),
			Arguments.of(new int [] {1,2,3,4}, 0, 0),
			Arguments.of(new int [] {1,2,1,1}, 0, 1),
			Arguments.of(new int [] {1,2,4,4,3,3,0,9,2,3}, 3, 2)
		);
	}
}
