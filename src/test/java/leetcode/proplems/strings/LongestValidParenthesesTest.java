package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.LongestValidParentheses;

class LongestValidParenthesesTest {
	
	private LongestValidParentheses underTest = new LongestValidParentheses();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String input, int expected ) {
		int actual = underTest.longestValidParentheses ( input );
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("", 0),
			Arguments.of("(", 0),
			Arguments.of("((", 0),
			Arguments.of(")(", 0),
			Arguments.of("()", 2),
			Arguments.of("(()", 2),
			Arguments.of("())", 2),
			Arguments.of("()(", 2),
			Arguments.of("(((()", 2),
			Arguments.of("(())", 4),
			Arguments.of("(())(", 4),
			Arguments.of("(()))", 4),
			Arguments.of("(()()(", 4),
			Arguments.of("(()())", 6),
			Arguments.of("(((())))", 8),
			Arguments.of("(((())))((()))", 14),
			Arguments.of("()()()", 6),
			Arguments.of(")()())()()(", 4)
		);
	}

}
