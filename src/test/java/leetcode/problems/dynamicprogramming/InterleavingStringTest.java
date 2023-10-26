package leetcode.problems.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class InterleavingStringTest {
	
private InterleavingString underTest = new InterleavingString();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String word1, String word2, String word3, boolean expected) {
		boolean actual = underTest.isInterleave(word1, word2, word3);
		assertEquals(expected, actual);
	}

	
	private static Stream<Arguments> testWithParams() {
		
		
		
		return Stream.of(
			Arguments.of("aabcc", "dbbca", "aadbbcbcac", true),
			Arguments.of("aabcc", "dbbca", "aadbbbaccc", false),
			Arguments.of("a", "b", "ab", true),
			Arguments.of("aa", "ab", "aaba", true),
			Arguments.of("", "", "", true)
			
		);
	}

}
