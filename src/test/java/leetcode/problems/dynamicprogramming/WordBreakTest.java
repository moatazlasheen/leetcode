package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WordBreakTest {
	
	private WordBreak underTest = new WordBreak();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String in, List<String> dic,  boolean expected) {
		boolean actual = underTest.wordBreak(in, dic);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of("leetcode", Arrays.asList("leet", "code"), true),
			Arguments.of("applepenapple", Arrays.asList("apple", "pen"), true),
			Arguments.of("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"), false)
		);
	}
}
