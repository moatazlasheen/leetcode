package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.IsSubsequence;

class IsSubsequenceTest {
	
	private IsSubsequence underTest = new IsSubsequence();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String subSeq, String orig, boolean expected) {
		
		boolean actual = underTest.isSubsequence(subSeq, orig);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("ace", "abcde", true),
			Arguments.of("aec", "abcde", false),
			Arguments.of("awc", "abcdefghijklmo", false),
			Arguments.of("aaaaaaaaaaaaaaaaa", "abcdefghijklmo", false)
		);
	}

}
