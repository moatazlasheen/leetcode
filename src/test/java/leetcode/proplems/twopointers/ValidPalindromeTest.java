package leetcode.proplems.twopointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.towpointers.ValidPalindrome;

class ValidPalindromeTest {
	
	private ValidPalindrome underTest = new ValidPalindrome();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams( String in, boolean expected ) {
		boolean actual = underTest.isPalindrome(in);
		assertEquals(expected, actual);
	}
	
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("A man, a plan, a canal: Panama", true),
			Arguments.of("race a car", false),
			Arguments.of(".,", true),
			Arguments.of("0P", false)
			
		);
	}

}
