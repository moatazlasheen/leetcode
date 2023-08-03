package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.ValidParentheses;

class ValidParenthesesTest {
	
	private ValidParentheses underTest = new ValidParentheses();

	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String input, boolean expected ) {
		boolean actual = underTest.isValid(input);
		
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("(", false),
			Arguments.of("}", false),
			Arguments.of("(]", false),
			Arguments.of("()", true),
			Arguments.of("{()[]}", true),
			Arguments.of("[{()}{}]", true),
			Arguments.of("[{()}{]", false)
		);
	}
	
}
