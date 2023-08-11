package leetcode.proplems.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.sorting.FindingKthLargestElement;

class FindingKthLargestElementTest {
	
	private FindingKthLargestElement underTest = new FindingKthLargestElement();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int expected ) {
		int actual = underTest.findKthLargest(nums, k);
		assertEquals(expected, actual);
	}
	
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {3,2,1,5,6,4}, 2, 5),
			Arguments.of(new int [] {3,2,3,1,2,4,5,5,6}, 4, 4)
		);
	}

}
