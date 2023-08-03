package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.Anagrams;

class AnagramsTest {

	
	private Anagrams underTest = new Anagrams();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String s1, String s2, boolean expected ) {
		boolean actual = underTest.isAnagram(s1, s2);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("anagram", "ngmraaa", true),
			Arguments.of("anagram", "nagaram", true),
			Arguments.of("anagram", "ngmraa", false)
		);
	}
}
