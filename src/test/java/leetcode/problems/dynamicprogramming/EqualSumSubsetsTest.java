package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class EqualSumSubsetsTest {
	
	private EqualSumSubSets underTest = new EqualSumSubSets();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] nums, boolean expected) {
		boolean actual = underTest.canPartition(nums);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of(new  int [] {1, 5, 11, 5}, true),
			Arguments.of(new  int [] {1, 2, 3, 5}, false),
			Arguments.of(new  int [] {2, 1, 5, 4, 11, 2, 5}, true)
		);
	}
}
