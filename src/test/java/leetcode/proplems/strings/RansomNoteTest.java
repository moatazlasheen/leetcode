package leetcode.proplems.strings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import leetcode.problems.strings.RansomNote;

class RansomNoteTest {

	private RansomNote underTest = new RansomNote();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams ( String ransomeNote, String magazine, boolean expeced ) {
		boolean actual = underTest.canConstruct(ransomeNote, magazine);
		assertEquals(expeced, actual);
	}
	
	private static Stream<Arguments> testWithParams ( ) {
		return Stream.of(
			Arguments.of("bad", "abcd", true),
			Arguments.of("baad", "abcd", false),
			Arguments.of("program", "mrrpgoa", true),
			Arguments.of("program", "mrrpga", false)
		);
	}
}
