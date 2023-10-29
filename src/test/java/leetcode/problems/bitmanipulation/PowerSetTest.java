package leetcode.problems.bitmanipulation;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PowerSetTest {

	private PowerSet underTest = new PowerSet();
	
	@ParameterizedTest
	@MethodSource
	void testWithParams(String in, List<String> expected) {
		List<String> actual = underTest.AllPossibleStrings(in);
		assertEquals(expected, actual);
	}
	
	private static Stream<Arguments> testWithParams() {
		return Stream.of(
			Arguments.of("a", Arrays.asList("a")),
			Arguments.of("ab", Arrays.asList("a", "ab", "b")),
			Arguments.of("abc", Arrays.asList("a", "ab", "abc", "ac", "b", "bc", "c"))
		);
	}
	
}
