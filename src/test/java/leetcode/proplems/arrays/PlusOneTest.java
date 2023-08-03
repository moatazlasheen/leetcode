package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.PlusOne;

class PlusOneTest {
	
	private PlusOne underTest = new PlusOne();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int [] expected) {
		int [] actual = underTest.plusOne(nums);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {0}, new int [] {1}),
			Arguments.of(new int [] {1}, new int [] {2}),
			Arguments.of(new int [] {9}, new int [] {1,0}),
			Arguments.of(new int [] {1,9}, new int [] {2,0}),
			Arguments.of(new int [] {9,9}, new int [] {1,0,0}),
			Arguments.of(new int [] {7,9,9,9}, new int [] {8,0,0,0})
		);
	}

}
