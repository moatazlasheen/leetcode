package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.FirstMissingPositive;

class FirstMissingPositiveTest {
	
	private FirstMissingPositive underTest = new FirstMissingPositive();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int expected ) {
		int actual = underTest.firstMissingPositive(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1}, 2),
			Arguments.of(new int [] {-11}, 1),
			Arguments.of(new int [] {1,-1}, 2),
			Arguments.of(new int [] {1,2,3,7,5,2}, 4),
			Arguments.of(new int [] {3,4,2,1}, 5)
		);
	}

}
