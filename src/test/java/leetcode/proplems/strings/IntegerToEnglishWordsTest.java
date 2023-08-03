package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.IntegerToEnglishWords;

class IntegerToEnglishWordsTest {
	
	private IntegerToEnglishWords underTest = new IntegerToEnglishWords();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( int input, String expected ) {
		String actual = underTest.numberToWords(input);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of(0, "Zero"),
			Arguments.of(1, "One"),
			Arguments.of(10, "Ten"),
			Arguments.of(40, "Forty"),
			Arguments.of(12, "Twelve"),
			Arguments.of(34, "Thirty Four"),
			Arguments.of(77, "Seventy Seven"),
			Arguments.of(100, "One Hundred"),
			Arguments.of(130, "One Hundred Thirty"),
			Arguments.of(1256, "One Thousand Two Hundred Fifty Six"),
			Arguments.of(13456, "Thirteen Thousand Four Hundred Fifty Six"),
			Arguments.of(100000, "One Hundred Thousand"),
			Arguments.of(134567, "One Hundred Thirty Four Thousand Five Hundred Sixty Seven"),
			Arguments.of(1345678, "One Million Three Hundred Forty Five Thousand Six Hundred Seventy Eight"),
			Arguments.of(13456789, "Thirteen Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"),
			Arguments.of(913456789, "Nine Hundred Thirteen Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine"),
			Arguments.of(2113456789, "Two Billion One Hundred Thirteen Million Four Hundred Fifty Six Thousand Seven Hundred Eighty Nine")
		);
	}

}
