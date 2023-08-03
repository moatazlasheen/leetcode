package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.DuplicationChecker;

class DuplicationCheckerTest {

	private DuplicationChecker underTest = new DuplicationChecker();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int [] nums, boolean expected ) {
		boolean actual = underTest.containsDuplicate(nums);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(new int [] {1}, false),
			Arguments.of(new int [] {-1, 0}, false),
			Arguments.of(new int [] {-1, 0, 1}, false),
			Arguments.of(new int [] {-1, 0, 1, -1}, true)
		);
	}
}
