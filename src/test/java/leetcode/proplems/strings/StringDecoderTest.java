package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.StringDecoder;

class StringDecoderTest {
	
	private StringDecoder underTest = new StringDecoder();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String encoded, String expected ) {
		
		String actual = underTest.decode(encoded);
		
		assertEquals(expected, actual);
		
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("a", "a"),
			Arguments.of("aa", "aa"),
			Arguments.of("1[b]", "b"),
			Arguments.of("2[c]", "cc"),
			Arguments.of("e2[d]", "edd"),
			Arguments.of("2[d]e", "dde"),
			Arguments.of("2[f]3[g]", "ffggg"),
			Arguments.of("2[h3[i]]", "hiiihiii"),
			Arguments.of("13[abc]", "abcabcabcabcabcabcabcabcabcabcabcabcabc")
		);
	}

}
