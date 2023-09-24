package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class DescendingConsecutiveValuesTest {
	
	private DescendingConsecutiveValues underTest = new DescendingConsecutiveValues();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( String input, boolean expected) {
		boolean actual = underTest.splitString(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of("1234", false),
			Arguments.of("050043", true),
			Arguments.of("9080701", false),
			Arguments.of("0090089", true),
			Arguments.of("20000000000000000001", true)
		);
	}
	
	
}
