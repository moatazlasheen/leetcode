package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.SequentialDigits;

class SequentialDigitsTest {

	private SequentialDigits underTest = new SequentialDigits();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( int low, int high, List<Integer> expected ) {
		List<Integer> actual = underTest.sequentialDigits(low, high);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of( 
			Arguments.of(100, 300, Arrays.asList(123, 234)),
			Arguments.of(1000, 13000, Arrays.asList(1234, 2345, 3456, 4567, 5678, 6789, 12345))
		);
	}
}
