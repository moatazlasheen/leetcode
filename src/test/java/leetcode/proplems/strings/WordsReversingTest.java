package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.WordsReversing;

class WordsReversingTest {
	
	
	private WordsReversing underTest = new WordsReversing();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String input, String expected ) {
		String actual = underTest.reverseWords(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("the sky is blue", "blue is sky the"),
			Arguments.of("  hello world  ", "world hello"),
			Arguments.of("a good   example", "example good a")
		);
	}

}
