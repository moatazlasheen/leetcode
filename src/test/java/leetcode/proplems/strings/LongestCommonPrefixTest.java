package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.LongestCommonPrefix;

class LongestCommonPrefixTest {
	
	private LongestCommonPrefix underTest = new LongestCommonPrefix();
	
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String [] input, String expected ) {
		String actual = underTest.findLongestCommonPrefix( input );
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of( new String [] {"floor", "flower", "flour"}, "flo"),
			Arguments.of( new String [] {"floor"}, "floor"),
			Arguments.of( new String [] {"floor", "ground"}, ""),
			Arguments.of( new String [] {}, ""),
			Arguments.of( new String [] {"floor", "flower", "flour", "sdsflasdas"}, "")
		);
	}

}
