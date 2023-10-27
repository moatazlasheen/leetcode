package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class LongestCommonSubSequenceTest {
	
	private LongestCommonSubsequence underTest = new LongestCommonSubsequence();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams (String s1, String s2, int expected ) {
		
		int actual = underTest.longestCommonSubsequence(s1, s2);
		
		assertEquals(expected, actual);
		
	}

	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("abcde", "ace", 3),	
			Arguments.of("abc", "abc", 3),
			Arguments.of("abc", "def", 0)
		);
	}
}
