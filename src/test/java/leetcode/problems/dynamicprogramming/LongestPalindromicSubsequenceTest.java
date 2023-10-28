package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class LongestPalindromicSubsequenceTest {
	
	private LongestPalindromicSubSequence underTest = new LongestPalindromicSubSequence();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String s, int expected) {
		int actual = underTest.longestPalindromeSubseq(s);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of("bbbab", 4),
			Arguments.of("cbbd", 2),
			Arguments.of("a", 1),
			Arguments.of("aaaaaa", 6),
			Arguments.of("abcdefghijklmnopqrstuvw", 1)
		);
	}
}
