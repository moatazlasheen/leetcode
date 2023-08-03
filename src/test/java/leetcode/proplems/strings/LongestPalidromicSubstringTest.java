package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.LongestPalidromicSubstring;

class LongestPalidromicSubstringTest {
	
	
	private LongestPalidromicSubstring underTest = new LongestPalidromicSubstring();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String input, String expected ) {
		String actual = underTest.longestPalindrome(input);
		
		assertEquals( expected, actual);
	}

	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( "a", "a" ),
			Arguments.of( "bb", "bb"),
			Arguments.of( "cacc", "cac" ),
			Arguments.of( "dddddddddddd", "dddddddddddd" ),
			Arguments.of( "babad", "bab" ),
			Arguments.of( "bababd", "babab" ),
			Arguments.of( "cbbd", "bb" ),
			Arguments.of("aacabdkacaa", "aca")
		);
	}
}
