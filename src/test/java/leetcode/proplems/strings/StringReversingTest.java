package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.StringReversing;

class StringReversingTest {
	
	private StringReversing underTest = new StringReversing();
	
	
//	@ParameterizedTest
//	@CsvSource({"a, a", "L, L", "abc, cba", "abcd, dcba", "moataz, zataom"})
//	void test ( String input, String expected ) {
//		
//		String actual = underTest.reverse(input);
//		
//		assertEquals(expected, actual);
//		
//	}
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String input, String expected ) {
		
		String actual = underTest.reverse(input);
		
		assertEquals(expected, actual);
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(null, null),
			Arguments.of("", ""),
			Arguments.of(" ", " "),
			Arguments.of("  ", "  "),
			Arguments.of("a", "a"),
			Arguments.of(" abc", "cba "),
			Arguments.of("abc ", " cba"),
			Arguments.of("Moataz", "zataoM"),
			Arguments.of("lasHeen", "neeHsal"),
			Arguments.of("Moustafa", "afatsuoM")
				);
	}

}
