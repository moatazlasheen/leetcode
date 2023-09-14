package leetcode.proplems.heap;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.heap.KLargestElement;

class KLargestElementTest {
	
	private KLargestElement underTest = new KLargestElement();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, int k, int expected ) {
		int actual = underTest.findKthLargest(nums, k);
		assertEquals(expected, actual);
	}
	
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {3,2,1,5,6,4}, 2, 5),
			Arguments.of(new int [] {3,2,3,1,2,4,5,5,6}, 4, 4),
			Arguments.of(new int [] {6,8,7,5,9,4,2,3}, 6, 4),
			Arguments.of(new int [] {1,2,12,2,11,9,7,30}, 3, 11),
			Arguments.of(new int [] {13,-21,12,22,-11,29,17,-16,24,19,-18}, 9, -16),
			Arguments.of(new int [] {-2,8,0,-5,7,-1,3,-3,-4,1,4}, 10, -4)
		);
	}

}
