package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.DisappearedNumbers;

class DisappearedNumbersTest {

	private DisappearedNumbers underTest = new DisappearedNumbers();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, List<Integer> expected ) {
		List<Integer> actual = underTest.findDisappearedNumbers(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {4,3,2,7,8,2,3,1}, Arrays.asList(5,6)),
			Arguments.of(new int [] {1,1}, Arrays.asList(2)),
			Arguments.of(new int [] {1,2,2,2,1,1}, Arrays.asList(3,4,5,6))
		);
	}

}
