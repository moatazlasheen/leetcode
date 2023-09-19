package leetcode.problems.recursion;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class ParenthesesGenerationTest {
	
	private ParenthesesGeneration underTest = new ParenthesesGeneration();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( int n, List<String> expected) {
		List<String> actual = underTest.generateParenthesis(n);
		assertEquals(expected, actual);
	}
	
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of(1, Arrays.asList("()")),
			Arguments.of(2, Arrays.asList("(())", "()()")),
			Arguments.of(3, Arrays.asList("((()))", "(()())", "(())()", "()(())", "()()()"))
		);
	}
}
