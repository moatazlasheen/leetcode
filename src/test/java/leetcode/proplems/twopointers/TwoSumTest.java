package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.TwoSum;

public class TwoSumTest {
	
	private TwoSum underTest = new TwoSum();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(int [] nums, int target, int [] expected) {
		int [] actual = underTest.twoSum(nums, target);
		assertTrue(Arrays.equals(expected, actual));
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(new int [] {2,7,11,15}, 9, new int [] {1,2}),
			Arguments.of(new int [] {2,3,4}, 6, new int [] {1,3}),
			Arguments.of(new int [] {-1, 0}, -1, new int [] {1,2})
		);
	}

}
