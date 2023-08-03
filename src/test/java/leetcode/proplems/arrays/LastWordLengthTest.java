package leetcode.proplems.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.arrays.LastWordLength;

class LastWordLengthTest {

	
	private LastWordLength underTest = new LastWordLength();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String s, int expectedLength ) {
		int actuaLength = underTest.lengthOfLastWord(s); 
		assertEquals(expectedLength, actuaLength);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( "a", 1),
			Arguments.of( "a ", 1),
			Arguments.of( " a", 1),
			Arguments.of( " a ", 1),
			Arguments.of( " ab", 2),
			Arguments.of( "ab ", 2),
			Arguments.of( " ab ", 2),
			Arguments.of( " ab c", 1),
			Arguments.of( " ab cde", 3),
			Arguments.of( " ab cde     ", 3)
		);
	}
	
}
