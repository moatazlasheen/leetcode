package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.LongestSubstring;

class LongestSubstringTest {

	
	private LongestSubstring underTest = new LongestSubstring();
	
	
	@ParameterizedTest
	@MethodSource
	void testLengthOfLongestSubstring ( String input, int expected ) {
		
		int actual = underTest.lengthOfLongestSubstring(input);
		assertEquals(expected, actual);
		
	}
	
	private static Stream<Arguments> testLengthOfLongestSubstring ( ) {
		return Stream.of(
			Arguments.of("abcabcbb", 3),
			Arguments.of("bbbbbbbb", 1),
			Arguments.of("pwwkew", 3),
			Arguments.of(" ", 1),
			Arguments.of("#", 1),
			Arguments.of("ewfsdsdsyjhdasdasdfyk7iyujnbdas345dscqwe4t", 14),
			Arguments.of("au", 2),
			Arguments.of("aabaab!bb", 3)
		);
	}
	
}
